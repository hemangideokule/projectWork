package com.Dao;

import java.util.List;

import com.model.Product;


public interface ProductDao {
	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByProdId(int pid);
	boolean update(Product product);

	Product get(int pid);
	/*Product getProduct(int id);*/
}
