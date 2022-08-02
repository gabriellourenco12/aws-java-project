package br.com.gabriellourenco12.awsproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Envelope {
    private String eventType;
    private String data;
}
