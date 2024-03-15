package com.jbk.oes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.oes.modal.Question;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;


@Repository
public class QuestionDAO 
{

	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public List<Question> getAllQuestions(String subject)
	{
		Session session=factory.openSession();
			
		Query query=session.createQuery("from Question where subject=:subject");
		
		query.setParameter("subject",subject);
		
		return query.list();
		
	}
	
	
	

}
