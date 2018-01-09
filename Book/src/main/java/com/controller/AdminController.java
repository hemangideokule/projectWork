package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.Category;
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
	
	
}
