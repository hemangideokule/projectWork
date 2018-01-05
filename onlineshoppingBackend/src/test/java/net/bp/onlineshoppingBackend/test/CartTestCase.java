package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Cart;

public class CartTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartDAO cartDAO;
	private Cart cart;
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp.onlineshoppingBackend");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

/*	@Test
	public void testAddCart() {
		cart = new Cart();
		cart.setTotalItems(2);
		cart.setUser(userDAO.get(1));
		cart.setGrandTotal(1000);
		
		assertEquals("Successfully added a cart inside a table", true, cartDAO.add(cart));

	}*/
}