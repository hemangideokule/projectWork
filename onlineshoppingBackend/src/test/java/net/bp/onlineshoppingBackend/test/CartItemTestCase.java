package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dao.CartItemDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.CartItem;
import net.bp.onlineshoppingBackend.dto.Product;
import net.bp.onlineshoppingBackend.dto.User;

public class CartItemTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartItemDAO cartItemDAO;
	private static UserDAO userDAO;
	private static CartDAO cartDAO;
	private static ProductDAO productDAO;

	private CartItem cartItem;
	private User user;
	private Product product;
	private Cart cart;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp.onlineshoppingBackend");
		context.refresh();
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*
	 * @Test public void testListCartItem() {
	 * 
	 * // get the user User user = userDAO.get(1); // get the cart Cart cart =
	 * user.getCart(); // get the cartItems
	 * 
	 * assertEquals("List CartItem fetched Successfully!", 0,
	 * cartItemDAO.list().size());
	 * 
	 * }
	 */
	// Adding a new cartItem

	@Test
	public void testAddCartItem() {

		// get the user
		User user = userDAO.get(1); 
		Cart cart = user.getCart();
		Product product = productDAO.getProduct(1);

		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(5);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());

		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
		cart.setTotalItems(cart.getTotalItems() + 1);
		assertEquals("Successfully added the cart item!", true, cartItemDAO.add(cartItem));

	}

	// updating the existing cart item
	/*
	 * @Test public void testUpdateCartItem() {
	 * 
	 * CartItem cartItem = cartItemDAO.get(7);
	 * 
	 * Cart cart = cartItem.getCart();
	 * 
	 * Product product = cartItem.getProduct();
	 * 
	 * int oldQuantity = cartItem.getQuantity();
	 * 
	 * cartItem.setQuantity(cartItem.getQuantity() + 1);
	 * 
	 * cartItem.setTotalPrice(product.getUnitPrice() * cartItem.getQuantity());
	 * 
	 * cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() -
	 * oldQuantity) * product.getUnitPrice());
	 * 
	 * assertEquals("Successfully updated the cart item!", true,
	 * cartItemDAO.update(cartItem));
	 * 
	 * // assertEquals("Successfully updated the cart item!",true, //
	 * cartItemDAO.updateCart(cart));
	 * 
	 * }
	 */
}
