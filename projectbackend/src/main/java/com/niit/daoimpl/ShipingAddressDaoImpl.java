package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ShipingAddressDao;
import com.niit.model.BillingAddress;
import com.niit.model.ShipingAddress;
import com.niit.model.User;

@Repository("shipingAddressDao")
@EnableTransactionManagement
public class ShipingAddressDaoImpl implements ShipingAddressDao {
	@Autowired
	SessionFactory sessionFactory;
	public ShipingAddressDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(ShipingAddress shipingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipingAddress);
		return true;
	}

	@Transactional
	public boolean delete(ShipingAddress shipingAddress) {
		sessionFactory.getCurrentSession().delete(shipingAddress);
		return true;
	}

	@Transactional
	public ShipingAddress get(String id) {
		String q1="from ShipingAddress where Ship_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<ShipingAddress>list =(List<ShipingAddress>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<ShipingAddress> list() {
		
		List<ShipingAddress> shipingAddress=(List<ShipingAddress>)
				sessionFactory.getCurrentSession().createCriteria(ShipingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return shipingAddress;
	}

	@Transactional
	public User getUseremail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<ShipingAddress> getaddbyuser(String u_id) {
		String q1 ="from ShipingAddress where User_id='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShipingAddress> list = (List<ShipingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
		}

}
