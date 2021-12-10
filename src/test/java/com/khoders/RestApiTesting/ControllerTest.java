package com.khoders.RestApiTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khoders.RestApiTesting.Service.ProductService;
import com.khoders.RestApiTesting.entity.Product;
import com.khoders.RestApiTesting.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;


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

        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJasonResponse = mvcResult.getResponse().getContentAsString();
        String expectJsonResponse = objectMapper.writeValueAsString(productList);
//        System.out.println(actualJasonResponse);
//        System.out.println(expectJsonResponse);
;
        JSONAssert.assertEquals(actualJasonResponse,expectJsonResponse, JSONCompareMode.LENIENT);
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product newProduct = new Product("Rapper",10,10.20);
        Product saveProduct = new Product(1l,"Rapper",10,10.20);

        Mockito.when(productService.createProduct(newProduct)).thenReturn(saveProduct);
        String url = "/api/create";
        mockMvc.perform(
                post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newProduct))
        ).andExpect(status().isOk()).andExpect(content().string("1"));
    }
}
