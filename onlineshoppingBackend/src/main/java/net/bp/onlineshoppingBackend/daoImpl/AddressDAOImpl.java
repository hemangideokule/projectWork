package net.bp.onlineshoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bp.onlineshoppingBackend.dao.AddressDAO;
import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.User;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Address> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Address", Address.class).getResultList();
	}
	
	public Address get(int id) {
		
		return sessionFactory.getCurrentSession().get(Address.class, Integer.valueOf(id));
	}

	public boolean add(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().save(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().update(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().delete(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Address getAddressByUser(User user) {
		
		return (Address)sessionFactory.getCurrentSession().createQuery("from Address where user=:user").setParameter("user",user).getResultList().get(0);
	}
}
