package br.com.gabriellourenco12.awsproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEvent {
    private long productId;
    private String code;
    private String username;
}
