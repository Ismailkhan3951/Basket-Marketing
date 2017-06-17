package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.PaymentDao;
import com.niit.model.Payment;
import com.niit.model.Payment;
@Repository("paymentDao")
@EnableTransactionManagement
@Transactional
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	SessionFactory sessionFactory;
	public PaymentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean saveorupdate(Payment payment) {
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
		return true;
	}

	
	public boolean delete(Payment payment) {
	  sessionFactory.getCurrentSession().delete(payment);
		return true;
	}

	
	public Payment get(String id) {
		String q1="from Payment where Payment_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Payment>list =(List<Payment>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	
	public List<Payment> list() {
		List<Payment> payment=(List<Payment>)
				sessionFactory.getCurrentSession().createCriteria(Payment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return payment;
	}




}
