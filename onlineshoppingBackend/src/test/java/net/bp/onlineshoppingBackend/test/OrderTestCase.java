package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.OrderDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Orders;

public class OrderTestCase {

	private static AnnotationConfigApplicationContext context;
	private static OrderDAO orderDAO;
	private Orders order;
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp.onlineshoppingBackend");
		context.refresh();
		orderDAO = (OrderDAO) context.getBean("orderDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	@Test
	public void testAddOrder() {
		order = new Orders();
		order.setTotalItems(2);
		order.setUser(userDAO.get(2));
		order.setGrandTotal(100);
		
		assertEquals("Successfully added a cart inside a table", true, orderDAO.add(order));

	}
}
