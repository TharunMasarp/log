package com.app.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.beans.UserRegistration;
import com.app.entites.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String saveUser(UserRegistration userRegistration) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userRegistration, userEntity);
		Session session = sessionFactory.getCurrentSession();
		session.save(userEntity);
		return userEntity.getUserId()+" details saved successfully!";
	}

	@Override
	public List<UserRegistration> authenticateUser(String userId, String password) {
	/*	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		Criterion cr1 = Restrictions.gt("userId", userId);
		Criterion cr2 = Restrictions.gt("password", password);
		criteria.add(Restrictions.and(cr1, cr2));
		List<UserRegistration> loggedUser = criteria.list();
		return loggedUser;*/
		String sqlQuery = "from UserEntity where userid=:userid and password=:password";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(sqlQuery);
		query.setParameter("userid", userId);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<UserRegistration> loggedUser = query.list();
		return loggedUser;
	}

	@Override
	public List<UserRegistration> getAllRegitered() {
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		@SuppressWarnings("unchecked")
		List<UserRegistration> getAllUsers = criteria.list();
		return getAllUsers;
	}

}
