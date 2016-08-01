package com.nikhil.beatme.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.beatme.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() {
//		logger.debug("")
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>)
			sessionFactory.getCurrentSession()
			.createCriteria(Category.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//		logger.debug("calling list");
		return listCategory;
	}
	
	@Transactional
	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	@Transactional
	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}
	
	@Transactional
	public Category get(String id) {
		String hql = "from Category where id = " + "'" + id + "'";
/*
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = (List<Category>) query.getResultList();
*/		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;		
	}
	
	
}
