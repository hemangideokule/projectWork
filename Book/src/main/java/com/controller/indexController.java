package com.controller;


import java.util.List;
import java.util.Set;

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

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CartItemDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.CartItem;
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
		
		@Autowired 
		CartDaoImpl cartDaoImpl;
		@Autowired 
		CartItemDaoImpl cartItemDaoImpl;
	
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

		System.out.println("result="+result);
	
			System.out.println("hasErrors");
			mav.setViewName("register");
		return mav;
	}
	else
	{
		System.out.println("noErrors");
	
		user.setRole("ROLE_USER");
		userDaoImpl.insertUser(user);
		System.out.println("user created");
	    com.model.Cart cart=new com.model.Cart();
	    CartItem cartitem=new CartItem();
	    
	    cart.setUser(user);
		user.setCart(cart);
		cartitem.setCart(cart);

		cartDaoImpl.insertCart(cart);
		System.out.println("cart object="+cart);
	
		userDaoImpl.insertUser(user);
		System.out.println("User object="+user);
		cartItemDaoImpl.insertCart(cartitem);
		System.out.println("cartItem object="+cartitem);

	
		
/*		cart.getCartId();*/
	
		System.out.println("else part of saveReg");
		
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
	@RequestMapping("/prodDetails/{pid}")
    public ModelAndView prodDet(@PathVariable("pid") int pid)
	{System.out.println("hi");
	ModelAndView mv= new ModelAndView();
		Product p= productDaoImpl.findByProdId(pid);
	
	mv.addObject("prod",p);
	System.out.println("hi too");
      mv.setViewName("productDetails");
  	System.out.println("bye");
	return mv;
	}

	



}
