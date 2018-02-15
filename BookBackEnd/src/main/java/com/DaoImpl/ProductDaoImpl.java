package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	/*public Product getProduct(int pid) {
		return sessionFactory.getCurrentSession().get(Product.class, pid);
	}*/

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
	public Product get(int pid) {

		return sessionFactory.openSession().get(Product.class, pid);
	}
	public void updateProduct(Product prod)
	{
		/*Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(prod);
		
		session.update(prod);
		System.out.println("update method in daoimpl");
		session.getTransaction().commit();*/
		
		Session session= sessionFactory.openSession();
		Transaction trans= session.beginTransaction();
		session.update(prod);
		trans.commit();
	}
	

	
	public void deleteProduct(int pid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Product p=session.get(Product.class, pid);
	session.delete(p);
		session.getTransaction().commit();
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
