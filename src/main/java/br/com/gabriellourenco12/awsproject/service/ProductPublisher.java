package br.com.gabriellourenco12.awsproject.service;

import br.com.gabriellourenco12.awsproject.enums.EventType;
import br.com.gabriellourenco12.awsproject.model.Envelope;
import br.com.gabriellourenco12.awsproject.model.Product;
import br.com.gabriellourenco12.awsproject.model.ProductEvent;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductPublisher {
    private final AmazonSNS snsClient;
    private final Topic productEventsTopic;
    private final ObjectMapper objectMapper;

    public ProductPublisher(AmazonSNS snsClient,
                            @Qualifier("productEventsTopic") Topic productEventsTopic,
                            ObjectMapper objectMapper) {
        this.snsClient = snsClient;
        this.productEventsTopic = productEventsTopic;
        this.objectMapper = objectMapper;
    }

    public void publishProductEvent(Product product, EventType eventType, String username) {
        ProductEvent productEvent = new ProductEvent(product.getId(), product.getCode(), username);

        try {
            Envelope envelope = new Envelope(eventType, objectMapper.writeValueAsString(productEvent));

            snsClient.publish(
                    productEventsTopic.getTopicArn(),
                    objectMapper.writeValueAsString(envelope));
        } catch (JsonProcessingException e) {
            log.error("Failed to create product event message", e);
        }
    }
}
