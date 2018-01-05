package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.Orders;


public interface OrderDAO {

	Orders get(int id);
	List<Orders> list();
	boolean add(Orders order);
	boolean update(Orders order);
	void delete(int id);
}
