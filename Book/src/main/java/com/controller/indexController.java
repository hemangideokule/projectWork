package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.User;

@Controller
public class indexController {
	
	@Autowired
	public UserDaoImpl userDaoImpl;
	  @Autowired 
		ProductDaoImpl productDaoImpl;

		@Autowired 
		SupplierDaoImpl supplierDaoImpl;
		
		@Autowired 
		CategoryDaoImpl categoryDaoImpl;
	
@RequestMapping("/")
public String index()
{
return "index";		
}
	@RequestMapping(value="/goToRegister" , method=RequestMethod.GET)
	 public ModelAndView goToRegister()
	{
		ModelAndView mv= new ModelAndView();
	//	return "register";
		mv.addObject("user", new User());
		mv.setViewName("register");
		return mv;
	}
	@RequestMapping(value="/saveRegister" , method=RequestMethod.POST)
	 public ModelAndView saveRegister(@ModelAttribute("user")User user)
	{
		ModelAndView mav= new ModelAndView();
	
			user.setRole("ROLE_USER");
			userDaoImpl.insertUser(user);
			mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value="/productCustList" )
	 public ModelAndView getCustTable(@RequestParam("cid") int cid)
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("prodList", productDaoImpl.getProdByCatId(cid));
		mv.setViewName("ProductCustList");
		return mv;
	}
	  @ModelAttribute
		public void getData(Model m)
		{
			m.addAttribute("catList", categoryDaoImpl.retrieve());
			m.addAttribute("prodList", productDaoImpl.retrieve());
		}
	
}
