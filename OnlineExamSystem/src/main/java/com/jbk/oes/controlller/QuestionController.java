package com.jbk.oes.controlller;

import java.util.Collection;

import java.util.HashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.oes.modal.Answer;
import com.jbk.oes.modal.Question;
import com.jbk.oes.services.QuestionService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController 
{

	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("getFirstQuestion/{subject}")
	public Question getFirstQuestion(@PathVariable String subject)
	{
		
		List<Question> list=questionService.getAllQuestions(subject);
		
		System.out.println(list);
		
		HttpSession httpsession=LoginController.httpsession;
		
		httpsession.setAttribute("allquestions",list);
				
		return list.get(0);
	}
	
	// 0 1 2
	@SuppressWarnings("unchecked")
	@GetMapping("nextQuestion")
	public  Question nextQuestion()
	{
		HttpSession httpsession=LoginController.httpsession;
		
		List<Question> list=(List<Question>) httpsession.getAttribute("allquestions");
		
		//index=index+1;
				
		Question question;
		
		if((int)httpsession.getAttribute("questionIndex")<list.size()-1)
		{

			httpsession.setAttribute("questionIndex",(int)httpsession.getAttribute("questionIndex") + 1);//2
			
			question=list.get((int)httpsession.getAttribute("questionIndex"));
					
		}
		else
			question=list.get(list.size()-1);// show last question
				
		return question;
		
	}

	
		// 0 1 2
		@SuppressWarnings("unchecked")
		@GetMapping("previousQuestion")
		public  Question previousQuestion()
		{
			HttpSession httpsession=LoginController.httpsession;
			
			List<Question> list=(List<Question>) httpsession.getAttribute("allquestions");
				
			Question question;
			
			if((int)httpsession.getAttribute("questionIndex")>0)
			{

				httpsession.setAttribute("questionIndex",(int)httpsession.getAttribute("questionIndex") - 1);//2
				
				question=list.get((int)httpsession.getAttribute("questionIndex"));
						
			}
			else
				question=list.get(0);// show first question
					
			return question;
			
		}
		
		// {"qno":1,"qtext":"why","submittedAnswer":"A","originalAnswer":"A"}
		
		@SuppressWarnings("unchecked")
		@PostMapping("saveAnswer")
		public void saveAnswer(@RequestBody Answer answer)
		{
			System.out.println(answer);
			
			HttpSession httpsession=LoginController.httpsession;
			
			// add/update user response in HashMap
			
			if(answer.getSubmittedAnswer()!=null)
			{
				HashMap<Integer,Answer>   hashMap =  (HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
				hashMap.put(answer.getQno(),answer);
				System.out.println(hashMap);
			}
		
		}
		
		
		@SuppressWarnings("unchecked")
		@GetMapping("endexam")
		public ResponseEntity<Integer>  endexam()
		{	

			HttpSession httpsession=LoginController.httpsession;
		
			HashMap<Integer,Answer>  hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			
			// Collection   values()

			Collection<Answer>   collection=hashMap.values();
			
			System.out.println(" values() gives object of class whose name is " + collection.getClass().getName());
			
			
			// Collection collection=new ArrayList();
			
			// reference of interface can refer to object of implementation class
			
			
			for (Answer ans : collection) 
			{
				if(ans.getSubmittedAnswer().equals(ans.getOriginalAnswer()))
				{
					httpsession.setAttribute("score",(int)httpsession.getAttribute("score")+1);//2
					
					// httpsession.setAttribute("score",10);
					
				}
			}
			

			Integer score=(Integer)httpsession.getAttribute("score");
			
			System.out.println("Total Score at Server " + score);

			ResponseEntity<Integer> responseEntity=new ResponseEntity<Integer>(score,HttpStatus.OK);

			return responseEntity;
			
		}
		
		@GetMapping("getAllAnswers")
		public Collection<Answer> getAllAnswers() {
			
			HttpSession httpSession = LoginController.httpsession;
			
			@SuppressWarnings("unchecked")
			HashMap<Integer, Answer> hashmap = (HashMap<Integer, Answer>) httpSession.getAttribute("submittedDetails");
			
			Collection<Answer> collection = hashmap.values();
			
			return collection;
		}
		
		
}
