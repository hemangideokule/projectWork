package net.bp.onlineshoppingBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.bp.onlineshoppingBackend.dao.CategoryDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dto.Product;

@Controller
class PageController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Home");

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);

		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value = { "/product1" })
	public ModelAndView product1() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Products");
		mv.addObject("userClickProduct1", true);
		return mv;
	}

	// display the login view

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {

		if (error != null) {
			model.addAttribute("error", true);
		}

		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = { "/Register", "/register" })
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Sign up");
		mv.addObject("userClickSignUp", true);
		return mv;
	}

	@RequestMapping(value = { "/Account", "/account" })
	public ModelAndView account() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "My Account");
		mv.addObject("userClickSignUp", true);
		return mv;
	}

	@RequestMapping(value = "/products")
	public ModelAndView userproducts() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@GetMapping("/allproducts")
	@ResponseBody
	public List<Product> allProducts() {

		return productDAO.list();
	}

	@RequestMapping(value = "showproduct/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("showproduct");
		mv.addObject("prd", productDAO.getProduct(id));
		return mv;
	}

	@RequestMapping("/catprod/{id}")
	public ModelAndView productsBasedOnCat(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("products", productDAO.products(id));
		mv.addObject("catpro", true);
		return mv;

	}

	@RequestMapping("category/{id}")
	public @ResponseBody List<Product> catProducts(@PathVariable("id") Integer id) {
		return productDAO.products(id);

	}
}
