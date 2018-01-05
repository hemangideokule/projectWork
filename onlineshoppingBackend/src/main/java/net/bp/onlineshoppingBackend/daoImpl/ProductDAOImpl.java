package net.bp.onlineshoppingBackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bp.onlineshoppingBackend.dao.ProductDAO;
import net.bp.onlineshoppingBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	public Product get(int id) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	public boolean add(Product product) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().save(product);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		/*Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, new Integer(id));
		if (product != null) {
			sessionFactory.getCurrentSession().delete(product);
		}*/
		Query q=sessionFactory.getCurrentSession().createQuery("delete from Product where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		
	}

	public Product getProduct(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public List<Product> products(int cat_id) {
		Query q=sessionFactory.getCurrentSession().createQuery("From Product where CATEGORY_ID=:id");
		q.setParameter("id", cat_id);
		
		return q.getResultList();
	}

}
