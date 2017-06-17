package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemsDao;

import com.niit.model.CartItems;

@Repository(value="cartItemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(CartItems cartitems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		return true;
	}
	public boolean delete(CartItems cartitems) {
		sessionFactory.getCurrentSession().delete(cartitems);
		return true;
	}
	public CartItems get(String id) {
		String q1="from CartItems where CartItems_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems>list =(List<CartItems>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
		
	}
	public List<CartItems> list() {
		List<CartItems> cartitems=(List<CartItems>)
				sessionFactory.getCurrentSession().createCriteria(CartItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartitems;
		
	}
	
	public List<CartItems> getlist(String cart_Id) {
		String Sql= "From CartItems where Cart_Id='"+  cart_Id+"'";
		Query q1= sessionFactory.getCurrentSession().createQuery(Sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Items is not found");
			return null;
		}
		else
		{
			return list;
		}
	}
	public CartItems getlistall(String CartId, String pro) {
		String sql= "from CartItems where Cart_Id='" +CartId+ "'and P_id ='" +pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Items is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	public List<CartItems> getlistbyproId(String P_id) {
		String Sq= "From CartItems  where P_Id='"+P_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list;
		}
	
	}
}
