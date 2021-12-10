package com.khoders.RestApiTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khoders.RestApiTesting.Service.ProductService;
import com.khoders.RestApiTesting.controller.ProductController;
import com.khoders.RestApiTesting.entity.Product;
import com.khoders.RestApiTesting.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

//@WebMvcTest(ProductController.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    @Test
    public void testListProduct() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Milo",10,20.1));
        productList.add(new Product("Nido",4,10.1));
        productList.add(new Product("Kenkey",100,15.1));

      //  Mockito.when(productRepository.findAll()).thenReturn(productList);
        Mockito.when(productService.getProduct()).thenReturn(productList);

        String url ="/api/allproduct";

        mockMvc.perform(get(url)).andExpect(status().isOk());
    }
}
