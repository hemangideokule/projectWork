package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.ProductDao;

import com.model.Product;



public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertProduct(Product product)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		//session.persist(user);
	session.saveOrUpdate(product);
		session.getTransaction().commit();
	}

	public List<Product> retrieve()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> li= session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;

	}
	public Product findByProdId(int pid)
	{
		Session session= sessionFactory.openSession();
		Product p=null;
		try
		{
		session.beginTransaction();
		p=session.get(Product.class, pid);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			
		}
		return p;
	}


/*	public List<Product>  findByProdId(int pid)
	{
		Session session= sessionFactory.openSession();
		List<Product> p=null;
		try
		{
		session.beginTransaction();
		p= session.createQuery("from Product where pid="+pid).list();
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			
		}
		return p;
	}*/
	
	
	public List<Product> getProdByCatId(int cid )
	{
		Session session= sessionFactory.openSession();
		List<Product> prod=null;
		try
		{
			session.beginTransaction();
			prod= session.createQuery("from Product where cid="+cid).list();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			
		}
		
		return prod;
	}

	public void updateProduct(Product p)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
	}
	
	
	public void deleteProduct(int pid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Product p=session.get(Product.class, pid);
	session.delete(p);
		session.getTransaction().commit();
	}

}
