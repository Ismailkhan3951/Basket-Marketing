package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.model.Cart;


@Repository("cartDao")
@EnableTransactionManagement
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	public boolean saveorupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	public boolean delete(Cart cart) {
	  sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	public Cart get(String id) {
		String q1="from Cart where Cart_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Cart>list =(List<Cart>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	public List<Cart> list() {
		List<Cart> cart=(List<Cart>)
				sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cart;
	}


}
