package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Product;
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

@RequestMapping("/index")
public String home()
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
	 public ModelAndView saveRegister(@Valid @ModelAttribute("user")User user,BindingResult result )
	{
		ModelAndView mav= new ModelAndView();
	if(result.hasErrors())
	{
			
			mav.setViewName("index");
		return mav;
	}
	else
	{
		user.setRole("ROLE_USER");
		userDaoImpl.insertUser(user);
		mav.setViewName("index");
		return mav;
	}
	}
	@RequestMapping(value="/productCustList" )
	 public ModelAndView getCustTable(@RequestParam("cid") int cid)
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("prodList", productDaoImpl.getProdByCatId(cid));
		mv.setViewName("ProductCustList");
		return mv;
	}

	@RequestMapping("/onlyProductCustList")
	public String productCustomerList()
	{
	return "ProductCustList";		
	}
	  @ModelAttribute
		public void getData(Model m)
		{
			m.addAttribute("catList", categoryDaoImpl.retrieve());
			m.addAttribute("prodList", productDaoImpl.retrieve());
		}
	
	  @RequestMapping("/goToLogin")
	  public String goToLogin ()
	  {
	  return "login";		
	  }


	  @RequestMapping("/userLogged")
	  public String userLogged ()
	  {
	  return "redirect:/index";		
	  }
      

	  @RequestMapping("/error")
	  public String error ()
	  {
	  return "Error";		
	  }

	  @RequestMapping("/reLogin")
	  public String reLogin ()
	  {
	  return "redirect:/goToLogin";		
	  }

	@RequestMapping(value="/productList", method=RequestMethod.GET)
	public ModelAndView productList()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("prodList", productDaoImpl.retrieve());
		mv.setViewName("productAdminList");
		return mv;
	
	}
	 
	



}
