package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDao;
import com.niit.model.Order;
@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	
	public boolean delete(Order order) {
	  sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	
	public Order get(String id) {
		String q1="from Order where Order_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Order>list =(List<Order>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	
	public List<Order> list() {
		List<Order> order=(List<Order>)
				sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}


}
