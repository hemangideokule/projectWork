package com.DaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		/*Session session= sessionFactory.openSession();
		Transaction trans= session.beginTransaction();
		session.saveOrUpdate(user);
		trans.commit();*/
		
	}
	
	public User findUserByEmail(String userEmail)
	{
		/*System.out.println("USERMAILID");
		Session session= sessionFactory.openSession();
		User u= null;
		try {*/
/*
			Session session= sessionFactory.openSession();*/
		/*	Transaction trans= session.beginTransaction();
			session.get(User.class, email);
			trans.commit();*/
		/*session.beginTransaction();
		u=session.get(User.class, email);
		session.getTransaction().commit();*/
		/*}
		catch(HibernateException e)
		{e.printStackTrace();}
		return u*/;
Session session=sessionFactory.openSession();
		
		User user=session.get(User.class,userEmail);
		System.out.println("email in userImpl="+userEmail);
		return user;
	
	}
	public User getUserByUserName(String email) {
		
		return	(User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email").setParameter("email", email).getSingleResult();
						
			}
	
}
