package com.example.searchService.service.impl;

import com.example.searchService.entity.Product;
import com.example.searchService.repository.ProductRepository;
import com.example.searchService.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
