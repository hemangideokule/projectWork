package net.bp.onlineshoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dto.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Cart get(int id) {

		return sessionFactory.getCurrentSession().get(Cart.class, Integer.valueOf(id));
	}

	public List<Cart> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Cart", Cart.class).getResultList();
	}

	public boolean add(Cart cart) {
		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().save(cart);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		try {

			sessionFactory.getCurrentSession().update(cart);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		Cart cat = (Cart) sessionFactory.getCurrentSession().load(Cart.class, new Integer(id));
		if (cat != null) {
			sessionFactory.getCurrentSession().delete(cat);
		}
	}
}