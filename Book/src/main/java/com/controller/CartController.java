package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Orders;
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
			
/*		   
		List<Product> prod= productDaoImpl.findByProdId(pid);*/
		mv.addObject("prod",prod);
          mv.setViewName("productDetails");
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

	    
	    @RequestMapping(value="/checkout" , method=RequestMethod.GET)
	
		 public ModelAndView checkout( HttpServletRequest req)
		{ 
	    
            ModelAndView mv= new ModelAndView();
			Principal principal=req.getUserPrincipal();
			String userEmail= principal.getName();
			User u=userDaoImpl.findUserByEmail(userEmail);
			 List<Cart> cart=cartDaoImpl.findByCartId(userEmail);
			 mv.addObject("user",u);
			 mv.addObject("cart",cart);
			 
		return mv;
	
		}

	    @RequestMapping(value="/orderProcess" , method=RequestMethod.GET)
		
			 public ModelAndView orderProcess( HttpServletRequest req)
			{ 
		    
	            ModelAndView mv= new ModelAndView();
				Principal principal=req.getUserPrincipal();
				Orders ord=new Orders();
				String userEmail= principal.getName();
				User u=userDaoImpl.findUserByEmail(userEmail);
				 Double total= Double.parseDouble(req.getParameter("total"));
				 String payment =req.getParameter(userEmail);
				 ord.setUser(u);
				 ord.setPayment(payment);
				 ord.setTotal(total);
				 ordersDaoImpl.insertOrder(ord);
                 mv.addObject("orderDetails",u);
                 mv.setViewName("ack");
				 return mv;
		
			}








}
