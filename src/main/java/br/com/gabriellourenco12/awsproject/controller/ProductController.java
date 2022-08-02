package br.com.gabriellourenco12.awsproject.controller;

import br.com.gabriellourenco12.awsproject.enums.EventType;
import br.com.gabriellourenco12.awsproject.model.Product;
import br.com.gabriellourenco12.awsproject.repository.ProductRepository;
import br.com.gabriellourenco12.awsproject.service.ProductPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductPublisher productPublisher;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductPublisher productPublisher) {
        this.productRepository = productRepository;
        this.productPublisher = productPublisher;
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bycode")
    public ResponseEntity<Product> findByCode(@RequestParam String code) {
        return productRepository.findByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product productCreated = productRepository.save(product);
        productPublisher.publishProductEvent(productCreated, EventType.PRODUCT_CREATED, "postter");
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setName(product.getName());
                    p.setModel(product.getModel());
                    p.setCode(product.getCode());
                    p.setPrice(product.getPrice());
                    Product productUpdated = productRepository.save(p);
                    productPublisher.publishProductEvent(productUpdated, EventType.PRODUCT_UPDATED, "updater");
                    return ResponseEntity.ok(productUpdated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        return productRepository.findById(id)
                .map(p -> {
                    productRepository.delete(p);
                    productPublisher.publishProductEvent(p, EventType.PRODUCT_DELETED, "deleter");
                    return ResponseEntity.ok(p);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
