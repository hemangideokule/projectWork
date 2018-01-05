package net.bp.onlineshoppingBackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.bp.onlineshoppingBackend.dao.CategoryDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dto.Category;
import net.bp.onlineshoppingBackend.dto.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	HttpServletRequest request;

	@RequestMapping(method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		Category category = new Category();
		model.addAttribute("product", product);
		model.addAttribute("categories",categoryDAO.getAll());

		model.addAttribute("userClickProduct", true);

		return "index";
	}

	@GetMapping("/allproducts")
	@ResponseBody
	public List<Product> allproducts() {

		return productDAO.list();
	}

	
	 @RequestMapping(value = "/allproduct") public ModelAndView showproducts()
	  { ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
	  "Product"); mv.addObject("userClickProduct", true); return mv; }
	 

	/*
	  @RequestMapping("product/{id}") public Product
	  getProduct(@PathVariable("id") int id) {
	return  productDAO.getProduct(id); }*/
	 
	

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productDAO.delete(id);
		return "redirect:/allproducts";
	}

	@RequestMapping(value = "showproduct/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("showproduct");
		mv.addObject("prd", productDAO.getProduct(id));
		return mv;
	}

}
