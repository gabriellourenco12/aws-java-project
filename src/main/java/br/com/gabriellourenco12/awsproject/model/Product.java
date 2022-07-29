package br.com.gabriellourenco12.awsproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 24, nullable = false)
    private String model;

    @Column(length = 8, nullable = false)
    private String code;

    private  float price;

    @Column(length = 12, nullable = true)
    private  String color;
}
