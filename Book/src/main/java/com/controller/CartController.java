package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.Dao.CartItemDao;
import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.CartItem;
import com.model.Orders;
import com.model.Product;

import com.model.User;



@Controller
@RequestMapping("/cart")
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
	
		
		private User user;
		CartItem cartItem = new CartItem();
		
		@RequestMapping(value = "/goToCart")
		public String userviewcart(Principal principal, Model model) {

			if (principal != null) {
				//user = UserDaoImpl.getUserByUserName(principal.getName());
				user = userDaoImpl.getUserByUserName(principal.getName());
				if (user.getRole().equals("ROLE_ADMIN"))
				/*	return "redirect:/admin/show/product";
				*/
					return "redirect:/admin/productList";
				

			}

			model.addAttribute("title", "View Cart");

			model.addAttribute("cartitemlist", (user.getCart()).getCartItem());

			model.addAttribute("userClickViewCart", true);
			return "index";
		}
		
		@RequestMapping(value="/prodDetails/{pid}")
	    public ModelAndView prodDet(@PathVariable("pid") int pid)
		{System.out.println("hi");
		ModelAndView mv= new ModelAndView();
			Product p= productDaoImpl.findByProdId(pid);
		/*List<Product> prod= productDaoImpl.findByProdId(pid);*/
		mv.addObject("prod",p);
		System.out.println("hi too");
          mv.setViewName("productDetails");
      	System.out.println("bye");
		return mv;
		}
	    
	    
	    @RequestMapping(value="/addToCart" , method=RequestMethod.POST)
	    public ModelAndView addToCart( HttpServletRequest request)
		{
	    	System.out.println("add to cart");
			ModelAndView mv= new ModelAndView();
			
			Principal principal=request.getUserPrincipal();
			String userEmail= principal.getName();
			System.out.println("usermail="+userEmail);
			   try
			   {
				   int pid=Integer.parseInt(request.getParameter("pid"));
				   System.out.println("pid="+pid);
				   Double price=Double.parseDouble(request.getParameter("pPrice"));
			/*	   int stock=Integer.parseInt(request.getParameter("stock"));*/
				   int qty=Integer.parseInt(request.getParameter("pQty"));
					String prodName=request.getParameter("pName");
					String imgName=request.getParameter("imgName");
					
					Cart cartExist = cartDaoImpl.getCartById(pid, userEmail);
					if(cartExist==null)
					{
						/*System.out.println("cart==null");
						Cart cm= new Cart();
						cm.setCartProductId(pid);
						System.out.println("pid="+pid);
						cm.setCartPrice(price);
						System.out.println("price="+price);
			         cm.setCartStock(qty);
						System.out.println("qty="+qty);
						cm.setCartStock(stock);
						System.out.println("stock="+stock);
						cm.setCartQuantity(qty);
						System.out.println("qty="+qty);
						cm.setCartImage(imgName);
						System.out.println("imgName="+imgName);
						cm.setCartProductName(prodName);
						System.out.println("name="+prodName);
						
						User u=userDaoImpl.findUserByEmail(userEmail);
						System.out.println("userMail="+userEmail);
						cm.setCartUserDetails(u);
						System.out.println("u="+u);
				        cartDaoImpl.insertCart(cm);
					}
					
					else if(cartExist!=null)
					{
						System.out.println("cart!=null");
						Cart cm= new Cart();
						cm.setCartId(cartExist.getCartId());
						cm.setCartProductId(pid);
						cm.setCartPrice(price);
			            cm.setCartQuantity(cartExist.getCartQuantity()+qty);
						cm.setCartImage(imgName);
						cm.setCartProductName(prodName);
						
						User u=userDaoImpl.findUserByEmail(userEmail);
						cm.setCartUserDetails(u);
				cartDaoImpl.updateCart(cm);*/
					}
					
			mv.addObject("cartInfo",cartDaoImpl.findCartById(userEmail));
			mv.setViewName("cart");
				   return mv;
			   }
			   
			   catch(Exception e)
			   {
				   e.printStackTrace();
				   mv.addObject("cartInfo",cartDaoImpl.findCartById(userEmail));
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
			System.out.println(userEmail+"user mail....");
			 List<Cart> cart=cartDaoImpl.findCartById(userEmail);
			 mv.addObject("user",u);
				System.out.println("u="+u);
			 
			 mv.addObject("cart",cart);
			 
		return mv;
	
		}

	   /* @RequestMapping(value="/orderProcess" , method=RequestMethod.POST)
		
			 public ModelAndView orderProcess( HttpServletRequest req)
			{ 
		    
	            ModelAndView mv= new ModelAndView("ack");
	        	Orders ord=new Orders();
				Principal principal=req.getUserPrincipal();
				String userEmail= principal.getName();
				
				List<Cart> cart=cartDaoImpl.findCartById(userEmail);	
				
				Double total= Double.parseDouble(req.getParameter("total"));
				 String payment =req.getParameter("payment");
				User users=userDaoImpl.findUserByEmail(userEmail);
				 ord.setUser(users);
				 ord.setPayment(payment);
				 ord.setTotal(total);
				 ordersDaoImpl.insertOrder(ord);
				 mv.addObject("user", userDaoImpl.findUserByEmail(userEmail));
                 mv.addObject("orderDetails",users);
                 mv.addObject("cart",cart);
				 return mv;
		
			}*/
	    @RequestMapping(value="/orderProcess" , method=RequestMethod.POST)
		 public ModelAndView orderProcess(HttpServletRequest req)
		{ 
	    
           ModelAndView mv= new ModelAndView("ack");
			Orders ord=new Orders();
			
			Principal principal=req.getUserPrincipal();
			String userEmail= principal.getName();
			List<Cart> cart= cartDaoImpl.findCartById(userEmail);
		
			 Double total= Double.parseDouble(req.getParameter("total"));
			/* String payment=req.getParameter("payment");*/
			User users=userDaoImpl.findUserByEmail(userEmail);
			 String payment =req.getParameter(userEmail);
			 
			 ord.setUser(users);
			 ord.setPayment(payment);
			 ord.setTotal(total);
			 ordersDaoImpl.insertOrder(ord);
     
            mv.addObject("u",userDaoImpl.findUserByEmail(userEmail));
            mv.addObject("orderDetails",users);
            mv.addObject("cart",cart);
            //mv.setViewName("ack");
			 return mv;
	
		}

@RequestMapping("/ack")
public String ack()
{
return "ack";	
}


/*@RequestMapping(value="/goToCart" , method=RequestMethod.GET)
public ModelAndView gotocart( HttpServletRequest req)
{ 
ModelAndView mv= new ModelAndView();
Principal principal=req.getUserPrincipal();
String userEmail= principal.getName();
mv.addObject("cartInfo", cartDaoImpl.findCartById(userEmail));
 mv.setViewName("cart");
 
return mv;

}*/

@RequestMapping(value="/deletePCart/{cartId}")
public ModelAndView deletecartItem(@PathVariable("cardId") int cartId,HttpServletRequest req)
{
	ModelAndView mv= new ModelAndView();
	Principal principal=req.getUserPrincipal();
	String userEmail= principal.getName();
	cartDaoImpl.deleteCart(cartId);
	mv.addObject("cardInfo",cartDaoImpl.findCartById(userEmail));
	mv.setViewName("cart");
return mv;	
	
}

/*@RequestMapping("/{pid}")		
public String addscart( @PathVariable("pid")int id,@RequestParam("quantity") int quantity,HttpSession session,Model model,Cart cart)
{		
		
	String username=(String)session.getAttribute("username");
	Product product1=productdao.findByProdId();
	cart.setUsername(username); 
	cart.setProquantity(quantity);
	Product product=productdao.getProduct(id);
cart.setProid(product.getId());
cart.setProname(product.getName());
cart.setProprize(product.getPrize());
cart.setCatid(product.getCatId());

cart.setSupid(product.getSupId());
cart.setOrdered(false);
model.addAttribute("cart",new Cart());
cartdao.insert(cart);
model.addAttribute("prolist",this.productdao.retreive());
return "allproductdisplay";
}*/

}
