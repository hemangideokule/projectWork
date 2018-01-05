package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.Product;

public interface ProductDAO {

	Product get(int id);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	void delete(int id);

	Product getProduct(int id);
	
	List<Product> products(int cat_id);
	
}
