package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Id
	private int sid ;
	private String supplierName;
	/*@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private Set<Product> product= new HashSet<Product>(0);*/
}
