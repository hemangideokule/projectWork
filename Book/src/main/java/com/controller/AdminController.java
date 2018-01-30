package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

import com.Dao.ProductDao;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;





@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired 
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired 
	CategoryDaoImpl categoryDaoImpl;
	
    @Autowired 
	ProductDaoImpl productDaoImpl;
	
    @Autowired
	ProductDao productDao;
    
	@RequestMapping("/adding")
	public String adding()
	{
		
		return "adding";
	}

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
	 public ModelAndView saveSuppData(@RequestParam("sid") int sid, @RequestParam("sname") String sname , @RequestParam("saddress") String saddress,@RequestParam("sphone") String  sphone)
	{
		ModelAndView mv= new ModelAndView();
			Supplier ss= new Supplier();
		    ss.setSid(sid);
			ss.setSupplierName(sname);
			ss.setAddress(saddress);
			ss.setPhone(sphone);
			supplierDaoImpl.insertSupplier(ss);
			mv.setViewName("modal");
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
			mv.setViewName("modal");
			return mv;
	}
	
	@RequestMapping(value="/saveProduct" , method=RequestMethod.POST)
	
		public String saveProd(HttpServletRequest request, @RequestParam("file") MultipartFile file)
		{
		Product prod=new Product();
		prod.setProdName(request.getParameter("pName"));
	
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
    
      return "modal";
      
	}
	
	@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid") int pid)
	{
	  productDaoImpl.deleteProduct(pid);
	  return "deleteModal";
		
	}
	
	@RequestMapping("/deleteCat/{cid}")
	public String deleteCat(@PathVariable("cid") int cid)
	{
	  categoryDaoImpl.deleteCat(cid);
	  return "deleteCatModal";
		
	}
	@RequestMapping("/deleteSat/{sid}")
	public String deleteSat(@PathVariable("sid") int sid)
	{
	  supplierDaoImpl.deleteSat(sid);
	  return "redirect:/admin/supplierList";
		
	}
	/*@RequestMapping(value="/updateProd")
    public ModelAndView updateProduct(@RequestParam("pid") int pid)
	{
	
		ModelAndView mav= new ModelAndView();
			Product p= productDaoImpl.findByProdId(pid);
	mav.addObject("prod",p);
	mav.addObject("catList",categoryDaoImpl.retrieve());
	mav.addObject("satList",supplierDaoImpl.retrieve());
	mav.setViewName("UpdateProduct");
	return mav;
	}*/
	@RequestMapping(value="/updateProd")
	public ModelAndView updateProduct(@RequestParam("pid") int pid)
	{
		System.out.println("hi");
		ModelAndView mv =new ModelAndView();
		Product p=productDaoImpl.findByProdId(pid);
		/*List<Product> prod= productDaoImpl.findByProdId(pid);*/
		mv.addObject("prod",p);
		mv.addObject("catList",categoryDaoImpl.retrieve());
		mv.addObject("satList", supplierDaoImpl.retrieve());
		System.out.println("hi2");
		mv.setViewName("UpdateProduct");
		System.out.println("hi3");
		return mv;

	}
	@RequestMapping(value="/updateSupp")
	public ModelAndView updateSupplier(@RequestParam("sid") int sid)
	{
		System.out.println("hi");
		ModelAndView mv =new ModelAndView();
		Supplier s=supplierDaoImpl.findBySuppId(sid);
		/*List<Product> prod= productDaoImpl.findByProdId(pid);*/
		mv.addObject("supp",s);
	
		mv.setViewName("UpdateSupplier");
		System.out.println("hi3");
		return mv;

	}
	@RequestMapping(value="/updateCat")
	public ModelAndView updateCategory(@RequestParam("cid") int cid)
	{
		System.out.println("hi");
		ModelAndView mv =new ModelAndView();
	Category c=categoryDaoImpl.findByCatId(cid);
		/*List<Product> prod= productDaoImpl.findByProdId(pid);*/
		mv.addObject("cat",c);
		mv.addObject("catList",categoryDaoImpl.retrieve());
	
		mv.setViewName("UpdateCategory");
		System.out.println("hi3");
		return mv;

	}
	
	/*@RequestMapping(value="/productUpdate" , method=RequestMethod.POST)
	public String updateProd(HttpServletRequest request, @RequestParam("file") MultipartFile file)
	{
		System.out.println("update url");
		int pid= request.getIntHeader("pid");
	Product prod=new Product();

	prod.setProdName(request.getParameter("pName"));
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
    productDaoImpl.update(prod);
  
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
  e.getMessage();
  }


	return "redirect:/productList?updateProd";
  return "updateModal";
  
}*/
	
	@RequestMapping(value="/supplierUpdate" , method=RequestMethod.POST)
	/*public String supplierUpdate(HttpServletRequest request)
	*/
	public String supplierUpdate(Supplier supplier, Model model)
	
	{
		model.addAttribute("satList",this.supplierDaoImpl.retrieve());
		 supplierDaoImpl.updateSupplier(supplier);
		 return "updateModal";
		 
		/*System.out.println("update url");
		int sid= request.getIntHeader("sid");
		
	Supplier supp=new Supplier();
	supp.setSupplierName(request.getParameter("supplierName"));
	supp.setAddress(request.getParameter("address"));
	supp.setPhone(request.getParameter("phone"));
*/
		 /*return "redirect:/productList?updateProd";*/
 
}
	
	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public String updateProduct(Product product,Model model)
	{
		productDaoImpl.updateProduct(product);
		model.addAttribute("prodList",this.productDaoImpl.retrieve());
		return "updateModal";
	}
		
	
	
	
	
	
	/*@RequestMapping(value="/categoryUpdate" , method=RequestMethod.POST)
	public String categoryUpdate(HttpServletRequest request)
	{
		System.out.println("update url");
		int cid= request.getIntHeader("cid");
	Category cat=new Category();
	cat.setCname(request.getParameter("cName"));


	categoryDaoImpl.updateCategory(cat);

 


	return "redirect:/productList?updateProd";
  return "updateModal";
  
}*/
	
	
	
	
	
	
	/* @RequestMapping(value="/prodDetails/${p.pid }")
	    public ModelAndView prodDetails(@PathVariable("pid") int pid)
		{
		ModelAndView mv= new ModelAndView();
			Product prod= productDaoImpl.findByProdId(pid);
			
		   
	Product prod= productDaoImpl.findByProdId(pid);
		mv.addObject("prod",prod);
       mv.setViewName("productDetails");
		return mv;
		}
	*/
	
	
	
}
