package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.Cart;

public interface CartDAO {

	Cart get(int id);
	List<Cart> list();
	boolean add(Cart cart);
	boolean update(Cart cart);
	void delete(int id);
}
