package com.jbk.oes.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.oes.modal.User;

@Repository
public class UserDAO {
	@Autowired
	SessionFactory factory;

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<User> getAllUsers() {

		Session session = factory.openSession();

		Query query = session.createQuery("from User");

		return query.list();

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public User getUser(String username) {

		Session session = factory.openSession();

		Query<User> query = session.createQuery("from User where username=:username");

		query.setParameter("username", username);

		return query.list().get(0);

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void deleteUser(String username) {

		Session session = factory.openSession();

		Query<User> query = session.createQuery("delete from User where username=:username");

		query.setParameter("username", username);

		Transaction tx = session.beginTransaction();

		query.executeUpdate();

		tx.commit();

	}

	@SuppressWarnings("deprecation")
	public void saveUser(User user) {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(user);

		tx.commit();

	}

}
