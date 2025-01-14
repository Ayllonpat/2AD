package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> result = productRepository.getAll();
        if (result.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return result;
    }

    public List<Product>
}
