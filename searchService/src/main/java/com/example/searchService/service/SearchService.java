package com.example.searchService.service;


import com.example.searchService.entity.Product;

public interface SearchService {
    Iterable<Product> getAll();
    void save(Product product);
}
