package com.controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;

import com.model.Product;

import com.model.User;

@Controller
public class CartController {
	
	 @Autowired 
		SupplierDaoImpl supplierDaoImpl;
		
		@Autowired 
		CategoryDaoImpl categoryDaoImpl;
		
	    @Autowired 
		ProductDaoImpl productDaoImpl;
	    
	    @Autowired 
		CartDaoImpl cartDaoImpl;
		
		@Autowired 
		OrdersDaoImpl ordersDaoImpl;
		
	    @Autowired 
		UserDaoImpl userDaoImpl;
	    
	    @RequestMapping(value="/prodDetails/${p.pid }")
	    public ModelAndView prodDetails(@PathVariable("pid") int pid)
		{
		ModelAndView mv= new ModelAndView();
			Product prod= productDaoImpl.findByProdId(pid);
		   mv.addObject("prod",prod);
          mv.setViewName("ProdDetails");
		return mv;
		}
	    
	    
	    @RequestMapping(value="/addToCart" , method=RequestMethod.POST)
	
		 public ModelAndView addToCart( HttpServletRequest request)
		{
			ModelAndView mv= new ModelAndView();
			
			Principal principal=request.getUserPrincipal();
			String userEmail= principal.getName();
			   try
			   {
				   int pid=Integer.parseInt(request.getParameter("pid"));
				   Double price=Double.parseDouble(request.getParameter("pPrice"));
				   int qty=Integer.parseInt(request.getParameter("pQty"));
					String prodName=request.getParameter("pName");
					String imgName=request.getParameter("imgName");
					
					Cart cartExist = cartDaoImpl.getCartById(pid, userEmail);
					if(cartExist==null)
					{
						Cart cm= new Cart();
						cm.setCartPrice(price);
						cm.setCartProductId(pid);
						cm.setCartStock(qty);
						cm.setCartImage(imgName);
						cm.setCartProductName(prodName);;
						
						User u=userDaoImpl.findUserByEmail(userEmail);
						cm.setCartUserDetails(u);
				cartDaoImpl.insertCart(cm);
						
					}
					
					else if(cartExist!=null)
					{
						Cart cm= new Cart();
						cm.setCartId(cartExist.getCartId());
						cm.setCartProductId(pid);
						cm.setCartPrice(price);
						cm.setCartStock(cartExist.getCartStock()+qty);
						cm.setCartImage(imgName);
						cm.setCartProductName(prodName);
						
						User u=userDaoImpl.findUserByEmail(userEmail);
						cm.setCartUserDetails(u);
				cartDaoImpl.updateCart(cm);
					}
					
					
			mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
			mv.setViewName("cart");
				   return mv;
			   }
			   catch(Exception e)
			   {
				   
				   e.printStackTrace();
					mv.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
					mv.setViewName("cart");
						   return mv;
				   
			   }
		}

}
