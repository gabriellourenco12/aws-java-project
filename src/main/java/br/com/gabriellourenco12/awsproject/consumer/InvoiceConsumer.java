package br.com.gabriellourenco12.awsproject.consumer;

import br.com.gabriellourenco12.awsproject.model.Invoice;
import br.com.gabriellourenco12.awsproject.model.SnsMessage;
import br.com.gabriellourenco12.awsproject.repository.InvoiceRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class InvoiceConsumer {
    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    private ObjectMapper objectMapper;
    private InvoiceRepository invoiceRepository;
    private AmazonS3 amazonS3;

    @Autowired
    public InvoiceConsumer(ObjectMapper objectMapper, InvoiceRepository invoiceRepository, AmazonS3 amazonS3) {
        this.objectMapper = objectMapper;
        this.invoiceRepository = invoiceRepository;
        this.amazonS3 = amazonS3;
    }

    @JmsListener(destination = "${aws.sqs.queue.invoice.events.name}")
    public void receiveS3Event(TextMessage textMessage) throws JMSException, IOException {
        log.info("Message received - Id: {} - ", textMessage.getText());

        SnsMessage snsMessage = objectMapper.readValue(textMessage.getText(), SnsMessage.class);

        S3EventNotification s3EventNotification = objectMapper.readValue(snsMessage.getMessage(), 
                S3EventNotification.class);
        
        processInvoiceNotification(s3EventNotification);
    }

    private void processInvoiceNotification(S3EventNotification s3EventNotification) throws IOException {

        for (S3EventNotification.S3EventNotificationRecord notificationRecord : s3EventNotification.getRecords()) {
            S3EventNotification.S3Entity s3Entity = notificationRecord.getS3();

            String bucketName = s3Entity.getBucket().getName();
            String objectKey = s3Entity.getObject().getKey();

            String invoiceFile = downloadObject(bucketName, objectKey);

            Invoice invoice = objectMapper.readValue(invoiceFile, Invoice.class);
            log.info("Invoice received: {} - ", invoice.getInvoiceNumber());

            invoiceRepository.save(invoice);

            amazonS3.deleteObject(bucketName, objectKey);
        }
    }

    private String downloadObject(String bucketName, String objectKey) throws IOException {
        S3Object s3Object = amazonS3.getObject(bucketName, objectKey);

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(s3Object.getObjectContent()));

        String content;
        while ((content = bf.readLine()) != null) {
            sb.append(content);
        }
        return sb.toString();
    }
}
