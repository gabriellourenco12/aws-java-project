package br.com.gabriellourenco12.awsproject.repository;

import br.com.gabriellourenco12.awsproject.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByCode(String code);
}
