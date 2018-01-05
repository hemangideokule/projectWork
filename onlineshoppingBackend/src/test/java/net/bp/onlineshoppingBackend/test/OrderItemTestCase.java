package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.AddressDAO;
import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dao.CartItemDAO;
import net.bp.onlineshoppingBackend.dao.OrderDAO;
import net.bp.onlineshoppingBackend.dao.OrderItemDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.OrderItem;
import net.bp.onlineshoppingBackend.dto.Orders;
import net.bp.onlineshoppingBackend.dto.Product;
import net.bp.onlineshoppingBackend.dto.User;

public class OrderItemTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	private static OrderItemDAO orderItemDAO;
	private static UserDAO userDAO;
	private static OrderDAO orderDAO;
	//private static ProductDAO productDAO;
	private static CartDAO cartDAO;
	private static CartItemDAO cartItemDAO;
	private static AddressDAO addressDAO;
	private OrderItem orderItem;
	private User user;
	private Product product;
	private Orders order;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp.onlineshoppingBackend");
		context.refresh();
		orderItemDAO = (OrderItemDAO) context.getBean("orderItemDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		//productDAO = (ProductDAO) context.getBean("productDAO");
		orderDAO=	(OrderDAO) context.getBean("orderDAO");
		cartDAO=	(CartDAO) context.getBean("cartDAO");
		cartItemDAO=(CartItemDAO) context.getBean("cartItemDAO");
		addressDAO=(AddressDAO) context.getBean("addressDAO");
	}
	@Test
	public void testAddOrderItem() {

		// get the user
		User user = userDAO.get(2); 
		Orders ord = new Orders();
		Cart cart = user.getCart();
		//Product product = productDAO.getProduct(6);

		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order);
		orderItem.setProduct(product);
		orderItem.setQuantity(2);
		orderItem.setTotalPrice(product.getPrice() * orderItem.getQuantity());

		order.setGrandTotal(order.getGrandTotal() + orderItem.getTotalPrice());
		order.setTotalItems(order.getTotalItems() + 1);
		assertEquals("Successfully added the cart item!", true, orderItemDAO.add(orderItem));

	}

}



