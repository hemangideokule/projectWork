package com.Dao;


import com.model.User;

public interface UserDao {
	public void insertUser(User user);
	public void updateUser(User user);
	public User getUserByUserName(String email);
}
