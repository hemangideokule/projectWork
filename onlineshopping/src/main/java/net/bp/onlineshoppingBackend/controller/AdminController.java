package net.bp.onlineshoppingBackend.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.bp.onlineshoppingBackend.dao.CategoryDAO;
import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dto.Category;
import net.bp.onlineshoppingBackend.dto.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	HttpServletRequest request;

	// called on path /admin
	@RequestMapping(method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("userClickAdmin", true);

		return "index";

	}

	@RequestMapping(value = "/displayproduct", method = RequestMethod.GET)
	public String newProducts(ModelMap model) {
		Category category = new Category();
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("userClickProduct", true);

		return "index";
	}

	// accessing categories list
	@GetMapping(value = { "/all/category" })
	@ResponseBody
	public List<Category> showAll() {
		return categoryDAO.list();
	}

	// Adding new category
	@RequestMapping(value = "/add/category", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
		try {
			System.out.println("inside save");
			if (result.hasErrors()) {
				System.out.println("entered errors");
				model.addAttribute("category", category);
				model.addAttribute("userClickAdmin", true);
				return "index";
			} else {
				System.out.println("else part");

					String realPath = request.getRealPath("/assets/images/");
					File folderToUpload = new File(realPath);

					if (!folderToUpload.exists()) {
						folderToUpload.mkdirs();
					}
					MultipartFile file = category.getFile();
					// creating the file name categoryname.jpg
					String fileToUpload = realPath + category.getName() + ".jpg";

					File destination = new File(fileToUpload);

					System.out.println("file path is:" + destination.toString());
					// transfering multipart data to destination
					file.transferTo(destination);
					// set the i,ageurl field od category model
					category.setImageUrl(destination.getName());

					if  (category.getId() == 0) {
						categoryDAO.add(category);
						model.addAttribute("success", "Category Added");
					
				} else {
					 	categoryDAO.update(category);
						model.addAttribute("success", "category added");
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin";
	}
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "Done";
	}
	
	// get category
	@GetMapping(value = { "/show/category/{id}" })
	public ModelAndView getCategoryById(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("category", categoryDAO.get(id));
		mv.addObject("userClickAdmin", true);
		return mv;
	}

	// delete category
	@RequestMapping(value = { "/delete/{id}/category" })
	public String deleteCategoryById(@PathVariable Integer id) {
		categoryDAO.delete(id);

		return "redirect:/admin";
	}

	// - Product
	@GetMapping("/allproducts")
	@ResponseBody
	public List<Product> allproduct() {

		return productDAO.list();
	}

	@RequestMapping(value={"/admin/Products"})
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("categories",categoryDAO.getAll());
		model.addAttribute("product", product);
		model.addAttribute("userClickProduct", true);

		return "index";
	}

	@RequestMapping(value = "/add/product", method = RequestMethod.POST)
	public String submitForm(@Valid Product product, BindingResult result, ModelMap model,@RequestParam(name="category")String catid) {
		
		product.setCategory(categoryDAO.get(Integer.parseInt(catid)));
		System.out.println("getting category form product"+product.getCategory());
				
		try {
			System.out.println("inside save");
			/*if (result.hasErrors()) {
				System.out.println("entering into errors");
				model.addAttribute("product", product);
				model.addAttribute("userClickProduct", true);
				return "index";
			} else {*/
				
					String realPath = request.getRealPath("/assets/images/");
					File folderToUpload = new File(realPath);

					if (!folderToUpload.exists()) {
						folderToUpload.mkdirs();
					}
					MultipartFile file = product.getFile();
					// creating the file name categoryname.jpg
					String fileToUpload = realPath + product.getName() + ".jpg";

					File destination = new File(fileToUpload);

					System.out.println("file path is:" + destination.toString());
					// transfering multipart data to destination
					file.transferTo(destination);
					// set the imageurl field of category model
					product.setImageUrl(destination.getName());
					
				
					if (product.getId() == 0) {
						productDAO.add(product);
						System.out.println("inside add product");
						model.addAttribute("success", "product added");

					}else{
						productDAO.update(product);
						model.addAttribute("success", "product added");
					}
				
			//}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/product";
	}

	@GetMapping("/admin/displayproducts")
	@ResponseBody
	public List<Product> allproducts() {
		return productDAO.list();
	}

	@RequestMapping(value={"/delete/{id}"})
	public String deleteProduct(@PathVariable Integer id) {
		productDAO.delete(id);
		return "redirect:/product";
	}

	@GetMapping(value = {"/showproduct/{id}"})
	public ModelAndView getProductsById(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("product", productDAO.getProduct(id));
		mv.addObject("categories",categoryDAO.getAll());
		mv.addObject("userClickProduct", true);
		return mv;
	}
}