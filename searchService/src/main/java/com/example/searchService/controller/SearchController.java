package com.example.searchService.controller;


import com.example.searchService.dto.ProductDto;
import com.example.searchService.entity.Product;
import com.example.searchService.service.SearchService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping(value = "/save")
    void add(@RequestBody Product product){
        searchService.save(product);
    }


    @RabbitListener(queues = "queue.ProductSearch")
    public void receiveLoginEmail(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        searchService.save(product);
    }

    @GetMapping()
    List<Product> get(){
        Iterable<Product>  iterable = searchService.getAll();
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

}
