package net.bp.onlineshoppingBackend.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dao.CartItemDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.CartItem;
import net.bp.onlineshoppingBackend.dto.Product;
import net.bp.onlineshoppingBackend.dto.User;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserDAO userDAO;

	private User user;
	CartItem cartItem = new CartItem();

	@RequestMapping(value = "/user/viewcart")
	public String userviewcart(Principal principal, Model model) {

		if (principal != null) {
			user = userDAO.getUserByUserName(principal.getName());

			if (user.getRole().equals("admin"))
				return "redirect:/admin/show/product";

		}

		model.addAttribute("title", "View Cart");

		model.addAttribute("cartitemlist", (user.getCart()).getCartItem());

		model.addAttribute("userClickViewCart", true);
		return "index";
	}

	@RequestMapping(value = "/user/addtocart/{id}")
	public String useraddproducttocart(@PathVariable("id") int id, Principal principal, Model model) {

		Product product = productDAO.get(id);
		User user = userDAO.getUserByUserName(principal.getName());
		Cart cart = user.getCart();
		
		CartItem cartItem = cartItemDAO.getCartItemByCartIdAndProductId(cart.getId(), product.getId());
		Set<CartItem> cartItems = null;
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice());
			cart.setGrandTotal(cart.getGrandTotal() + product.getPrice());
			cart.setTotalItems(cart.getTotalItems() + 1);
			cartItems = new HashSet<CartItem>();
			cartItems.add(cartItem);
			cart.setCartItem(cartItems);
			cartDAO.update(cart);
			
		} else {
			System.out.println("entering into else");
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice(cartItem.getTotalPrice() + product.getPrice());
			cartItem.getCart().setGrandTotal(cart.getGrandTotal() + product.getPrice());
			cartItem.getCart().setTotalItems(cart.getTotalItems() + 1);
			cartItemDAO.update(cartItem);
		}
		

		
	

		return "redirect:/cart/user/viewcart";

	}

	@RequestMapping(value = "/user/delete/{id}")
	public String userdeleteproductfromcart(@PathVariable("id") int id, Model mv) {

		CartItem cartItem = cartItemDAO.get(id);
		Cart cart = cartItem.getCart();
		cart.setTotalItems(cart.getTotalItems() - cartItem.getQuantity());
		cart.setGrandTotal(cart.getGrandTotal() - cartItem.getTotalPrice());
		cartDAO.update(cart);
		cartItemDAO.delete(id);
		return "redirect:/cart/user/viewcart";
	}

	public void confirmDeleteCartItem(CartItem cartItem) {
		Cart existingCart = new Cart();

		// if no items in the cart
		if (existingCart == null || existingCart.getId() == 0) {

		} else {
			if (cartItem.getQuantity() == 1)
				cartItemDAO.delete(existingCart.getId());
			else {
				cartItem.setQuantity(cartItem.getQuantity() - 1);

				cartItemDAO.update(cartItem);
			}
		}

	}

}
