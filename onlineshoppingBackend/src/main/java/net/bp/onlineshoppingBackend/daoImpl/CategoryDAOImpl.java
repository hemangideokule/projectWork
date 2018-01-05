package net.bp.onlineshoppingBackend.daoImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bp.onlineshoppingBackend.dao.CategoryDAO;
import net.bp.onlineshoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Category", Category.class).getResultList();
	}

	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	public boolean add(Category category) {
		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().save(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {

		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		Category cat=	(Category) sessionFactory.getCurrentSession().load(Category.class, new Integer(id));
		if (cat!=null)
		{
			sessionFactory.getCurrentSession().delete(cat);
		}
		
	}

	public Map<Integer, String> getAll() {
		List categories=sessionFactory.getCurrentSession().createQuery("FROM Category", Category.class).getResultList();
		Iterator<Category> it=categories.iterator();
		Map<Integer,String> cats=new HashMap<Integer, String>();
		while(it.hasNext())
		{
			Category c=it.next();
			cats.put(c.getId(), c.getName());
			
		}
			return cats;
	}

	
}
