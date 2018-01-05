package net.bp.onlineshoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Product;
import net.bp.onlineshoppingBackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public User get(int id) {
		
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
	}

	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM User",User.class).getResultList();
	}

	public boolean add(User user) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		try {

			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(id));
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	public User getUserByUserName(String email) {
		
	return	(User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email").setParameter("email", email).getSingleResult();
					
		}

}
