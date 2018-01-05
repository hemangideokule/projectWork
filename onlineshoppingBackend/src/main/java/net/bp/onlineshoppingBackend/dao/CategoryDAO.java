package net.bp.onlineshoppingBackend.dao;

import java.util.List;
import java.util.Map;

import net.bp.onlineshoppingBackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);

	List<Category> list();

	boolean add(Category category);

	boolean update(Category category);

	void delete(int id);
	Map<Integer,String> getAll();


}
