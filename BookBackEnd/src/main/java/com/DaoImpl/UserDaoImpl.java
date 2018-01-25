package com.DaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.model.User;




public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
//@Transactional
	public void insertUser(User user)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		//session.persist(user);
	session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	
	public User findUserByEmail(String email)
	{
		System.out.println("USERMAILID");
		Session session= sessionFactory.openSession();
		User u= null;
		try {
		session.beginTransaction();
		u=session.get(User.class, email);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{e.printStackTrace();}
		return u;
	
	
	}
	
}
