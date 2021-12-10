package com.khoders.RestApiTesting.controller;

import com.khoders.RestApiTesting.Service.ProductService;
import com.khoders.RestApiTesting.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/allproduct")
    public List<Product> getListProduct(){
        return productService.getProduct();
    }
    @PostMapping("/api/create")
    public String createNewProduct(@RequestBody Product product){
        Product saveproduct =  productService.createProduct(product);
        return String.valueOf(saveproduct.getId());
    }
}
