package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.User;

public interface UserDAO {

	User get(int id);

	List<User> list();

	boolean add(User user);

	boolean update(User user);

	void delete(int id);

	public User getUserByUserName(String name);
}
