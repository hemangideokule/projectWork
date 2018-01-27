package com.DaoImpl;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;



@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertCategory(Category category)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		//session.persist(user);
	session.saveOrUpdate(category);
		session.getTransaction().commit();
	}
	public List<Category> retrieve()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Category> li= session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;

	}
	public Category findByCatId(int cid)
	{
		Session session= sessionFactory.openSession();
		Category c=null;
		try
		{
		session.beginTransaction();
		c=session.get(Category.class, cid);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			
		}
		return c;
	}
	
	
	public void deleteCat(int cid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	Category p=session.get(Category.class, cid);
	session.delete(p);
		session.getTransaction().commit();
	}
	public void updateCategory(Category cat)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		/*session.saveOrUpdate(prod);
		*/
		session.update(cat);
		System.out.println("update method in daoimpl");
		session.getTransaction().commit();
	}
}
