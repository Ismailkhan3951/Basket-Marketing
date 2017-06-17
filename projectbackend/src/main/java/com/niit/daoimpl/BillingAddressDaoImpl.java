
package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.BillingAddressDao;
import com.niit.model.BillingAddress;
@Repository("billingAddressDao")
@EnableTransactionManagement
@Transactional
public class BillingAddressDaoImpl implements BillingAddressDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public BillingAddressDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}

	public boolean saveorupdate(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
		return true;
	}

	public boolean delete(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().delete(billingAddress);

		return true;
	}

	public BillingAddress get(String id) {
		String q1="from BillingAddress where Bill_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<BillingAddress>list =(List<BillingAddress>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	public List<BillingAddress> list() {
		List<BillingAddress> billingAddress=(List<BillingAddress>)
				sessionFactory.getCurrentSession().createCriteria(BillingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return billingAddress;
	}

	
	public BillingAddress getbillingaddress(String Bill_id) {
		String q1 ="from  BillingAddress where Bill_id='"+Bill_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List< BillingAddress> list = (List< BillingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}

	


