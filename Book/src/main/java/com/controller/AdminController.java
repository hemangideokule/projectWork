package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;



@Controller
public class AdminController {

	@RequestMapping("/adding")
	public String adding()
	{
		
		return "adding";
	}

	
	@Autowired 
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired 
	CategoryDaoImpl categoryDaoImpl;
	
    @Autowired 
	ProductDaoImpl productDaoImpl;
    
    @ModelAttribute
	public void loadingDataInPage(Model m)
	{
		m.addAttribute("catList", categoryDaoImpl.retrieve());
		m.addAttribute("satList", supplierDaoImpl.retrieve());
		m.addAttribute("prodList", productDaoImpl.retrieve());
		
	}

	@RequestMapping(value="/categoryList", method=RequestMethod.GET)
	public ModelAndView categoryList()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("catList", categoryDaoImpl.retrieve());
		mv.setViewName("categoryAdminList");
		return mv;
		
	}
	@RequestMapping(value="/supplierList", method=RequestMethod.GET)
	public ModelAndView supplierList()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("satList", supplierDaoImpl.retrieve());
		mv.setViewName("supplierAdminList");
		return mv;
		
	}
	
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	public ModelAndView productList()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("prodList", productDaoImpl.retrieve());
		mv.setViewName("productAdminList");
		return mv;
		
	}
	
	@RequestMapping(value="/saveSupp" , method=RequestMethod.POST)
	@Transactional
	 public ModelAndView saveSuppData(@RequestParam("sid") int sid, @RequestParam("sname") String sname )
	{
		ModelAndView mv= new ModelAndView();
			Supplier ss= new Supplier();
		    ss.setSid(sid);
			ss.setSupplierName(sname);
			supplierDaoImpl.insertSupplier(ss);
			mv.setViewName("adding");
			return mv;
	}
	
	@RequestMapping(value="/saveCat" , method=RequestMethod.POST)
	@Transactional
	 public ModelAndView saveCatData(@RequestParam("cid") int cid, @RequestParam("cname") String cname )
	{
		ModelAndView mv= new ModelAndView();
			Category cc= new Category();
		 cc.setCid(cid);
		 cc.setCname(cname);
		 	categoryDaoImpl.insertCategory(cc);
			mv.setViewName("adding");
			return mv;
	}
	
	@RequestMapping(value="/saveProduct" , method=RequestMethod.POST)
	
		public String saveProd(HttpServletRequest request, @RequestParam("file") MultipartFile file)
		{
		Product prod=new Product();
		prod.setPname(request.getParameter("pName"));
	
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
        prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));	
        prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
      
        String filepath= request.getSession().getServletContext().getRealPath("/");
        String filename= file.getOriginalFilename();
        prod.setImgName(filename);
      productDaoImpl.insertProduct(prod);
      System.out.println("File path"+filepath);
      try 
      {
    	  byte imagebyte[]= file.getBytes();
    	  BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
    	  fos.write(imagebyte);
    	  fos.close();
      }
      
    	 catch(IOException e)
      {
    		 
    		 e.printStackTrace();
      }
    
      return "adding";
      
	}
	
	@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid)
	{
	  productDaoImpl.deleteProduct(pid);
	  return "redirect:/productList?del";
		
	}
	@RequestMapping("/updateProd")
    public ModelAndView updateProduct(@RequestParam("pid") int pid)
	{
		System.out.println("update prod");
		ModelAndView mv= new ModelAndView();
			Product p= productDaoImpl.findByProdId(pid);
	mv.addObject("prod",p);
	mv.addObject("catList",categoryDaoImpl.retrieve());
	mv.addObject("satList",supplierDaoImpl.retrieve());
	mv.setViewName("UpdateProduct");
	return mv;
	}
	
	
	@RequestMapping(value="/productUpdate" , method=RequestMethod.POST)
	public String updateProd(HttpServletRequest request, @RequestParam("file") MultipartFile file)
	{
		String pid= request.getParameter("pid");
	Product prod=new Product();
	prod.setPid(Integer.parseInt(pid));
	prod.setPname(request.getParameter("pName"));
	prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
	prod.setDescription(request.getParameter("pDescription"));
	prod.setStock(Integer.parseInt(request.getParameter("pStock")));
	String cat= request.getParameter("pCategory");
	String sat= request.getParameter("pSupplier");
	
    prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(cat)));	
    prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(sat)));
  
    String filepath= request.getSession().getServletContext().getRealPath("/");
    String filename= file.getOriginalFilename();
    prod.setImgName(filename);
  productDaoImpl.updateProduct(prod);
  System.out.println("File path"+filepath);
  try 
  {
	  byte imagebyte[]= file.getBytes();
	  BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
	  fos.write(imagebyte);
	  fos.close();
  }
  
	 catch(IOException e)
  {
		 
		 e.printStackTrace();
  }

  return "redirect:/productList?updateProduct";
  
}
	
	
	
	
	
	
}
