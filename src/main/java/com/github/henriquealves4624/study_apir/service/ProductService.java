package com.github.henriquealves4624.study_apir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.henriquealves4624.study_apir.dto.ProductRequestCreate;
import com.github.henriquealves4624.study_apir.dto.ProductRequestUpdate;
import com.github.henriquealves4624.study_apir.model.Product;
import com.github.henriquealves4624.study_apir.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductRequestCreate dto) {
        return productRepository.save(dto.toModel());
    }

    public Optional<Product> getProductById(Long id) {

        // Antes estava assim:
        // return products.stream()
        // .filter(p -> p.getId().equals(id))
        // .findFirst();

        return productRepository.findById(id);

    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> updateProduct(
            Long id, ProductRequestUpdate dto) {

        // Antes era assim:
        // return products.stream()
        // .filter(p -> p.getId().equals(id))
        // .findFirst()
        // .map(p -> {
        // p.setValor(dto.getValor());
        // return p;
        // }
        // );

        return productRepository.findById(id)
                .map(p -> productRepository.save(dto.toModel(p)));

    }

    public boolean deleteProduct(Long id) {
        // Antes era assim:
        // return products.removeIf(p -> p.getId().equals(id));

        // Depois ficou assim:
        // Optional<Product> opt = productRepository.findById(id);
        // if (opt.isPresent()) {
        // productRepository.deleteById(id);
        // return true;
        // }
        // return false;

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }

        return false;

    }
}
