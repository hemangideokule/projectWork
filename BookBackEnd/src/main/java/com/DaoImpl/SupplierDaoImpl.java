package com.DaoImpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;




@Repository
@Service

public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertSupplier(Supplier supplier)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		//session.persist(user);
	session.saveOrUpdate(supplier);
		session.getTransaction().commit();
	}
	public List<Supplier> retrieve()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Supplier> li= session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return li;

	}
	
	public Supplier findBySuppId(int sid)
	{
		Session session= sessionFactory.openSession();
		Supplier s=null;
		try
		{
		session.beginTransaction();
		s=session.get(Supplier.class, sid);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			
		}
		return s;
	}
	
	public void deleteSat(int sid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	Supplier p=session.get(Supplier.class, sid);
	session.delete(p);
		session.getTransaction().commit();
	}
	
	public void updateSupplier(Supplier supp)
	{
		Session session= sessionFactory.openSession();
		Transaction trans= session.beginTransaction();
		session.update(supp);
		trans.commit();
		
		/*session.saveOrUpdate(prod);
		*/
		
		System.out.println("update method in suuplierdaoimpl");
	
	}
	
}
