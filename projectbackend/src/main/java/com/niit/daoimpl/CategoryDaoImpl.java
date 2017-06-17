package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;
import com.niit.model.Supplier;
@Repository("categoryDao")
@EnableTransactionManagement
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveorupdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
		return true;
	}

	
	public boolean delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	
	public Category get(String id) {
		String q1="from Category where cat_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Category>list=(List <Category>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	
	public List<Category> list() {
		List<Category> category=(List<Category>)
				sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;
	}

	
	public Category getCategorybypro(String id) {
		String q1 = "from Product where Cat_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
	   }
	
	
	
	

}
