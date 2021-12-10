package com.khoders.RestApiTesting;

import com.khoders.RestApiTesting.entity.Product;
import com.khoders.RestApiTesting.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestApiTestingApplicationTests {
    @Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

//	@Test
//	@Order(1)
//	public void testCreate(){
//		Product product = new Product();
//		product.setId(1l);
//		product.setPrice(2.00);
//		product.setName("Milk Powder");
//		product.setQuantity(20);
//		productRepository.save(product);
//
//		Assertions.assertNotNull(productRepository.findById(1l).get());
//	}
//	@Test
//	@Order(2)
//	public void testReadAll(){
//		List<Product> list = productRepository.findAll();
//		assertFalse(list.isEmpty());
//	}
//
//	@Test
//	@Order(3)
//	public void testSingleProduct(){
//		Product product = productRepository.findById(1l).get();
//		Assertions.assertEquals(2.00,product.getPrice());
//	}
//
//	@Test
//	@Order(4)
//	public void TestUpdateProduct(){
//		Product product = productRepository.findById(1l).get();
//		product.setPrice(4.50);
//		productRepository.save(product);
//		Assertions.assertNotEquals(2.00,productRepository.findById(1l).get().getPrice());
//	}

//	@Test
//	@Order(5)
//	public void TestDeletProduct(){
//		productRepository.deleteById(1l);
//		assertThat(productRepository.existsById(1l)).isFalse();
//	}
}
