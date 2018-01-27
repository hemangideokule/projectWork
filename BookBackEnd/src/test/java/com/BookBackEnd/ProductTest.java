package com.BookBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.model.Product;



public class ProductTest {

	private static AnnotationConfigApplicationContext context;

	private static ProductDao productDao;
	private static CategoryDao categoryDao;

	private Product prod;

	@Test
	public void testUpdateProduct() {
		prod= productDao.get(249);

		prod.setStock(10);
		assertEquals("Successfully updated data inside a table", true, productDao.update(prod));
	}
	
	
	
}
