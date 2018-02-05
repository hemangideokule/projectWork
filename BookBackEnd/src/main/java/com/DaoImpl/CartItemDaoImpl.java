package com.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*import org.springframework.transaction.annotation.Transactional;*/

import com.Dao.CartItemDao;
import com.model.CartItem;


/*@Transactional*/
@Repository/*("CartItemDaoImpl")*/
public class CartItemDaoImpl implements CartItemDao

{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}

	public CartItem get(int id) {
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
	}
	
	public List<CartItem> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM CartItem", CartItem.class).getResultList();
	}
	
	public boolean add(CartItem cartItem) {
		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().save(cartItem);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateCartItem(CartItem cartItem) {
		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().update(cartItem);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void delete(int id) {
		
		
		Query q=sessionFactory.getCurrentSession().createQuery("Delete from CartItem where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		

	}

	public CartItem getCartByUserId(int userId) {
		return (CartItem) sessionFactory.getCurrentSession().createQuery("from CartItem where userid =: userId").setParameter("user", userId).getSingleResult();
	}

	public CartItem getCartByUserIdAndProduct(int userId, int pid) {

		return (CartItem) sessionFactory.getCurrentSession().createQuery("FROM CartItem  WHERE userid=:userId and pid=:pid").getResultList();
	}

	public void delete(int cartid, int pid) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("delete CartItem where cart_id=:cartid and product_id=:proid");
		q.setParameter("cartid", cartid);
		q.setParameter("proid", pid);
		q.executeUpdate();
	}

	public CartItem getCartItemByCartIdAndProductId(int cartid, int pid) {
		// TODO Auto-generated method stub
		try{
		Query q=sessionFactory.getCurrentSession().createQuery("From CartItem where cartId=:cartid and pid=:proid");
		q.setParameter("cartid", cartid);
		q.setParameter("proid", pid);
		
		return (CartItem)q.getSingleResult();
		}catch(Exception e)
		{
			return null;
		}
	}

	public boolean deleteAllCartItems(int cartid) {
		// TODO Auto-generated method stub
		try{
			Query q=sessionFactory.getCurrentSession().createQuery("delete From CartItem where cart_id=:cartid");
			q.setParameter("cartid", cartid);
			
		int i=	q.executeUpdate();
		System.out.println("number of rows effected"+i);
			
			return true;
			}catch(Exception e)
			{
				System.out.println(e);
				return false;
			}
		
	}
	
}
