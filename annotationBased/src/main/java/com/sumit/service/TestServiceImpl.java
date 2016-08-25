package com.sumit.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumit.api.QuestionApi;
import com.sumit.api.TestApi;
import com.sumit.model.MainQuestion;
import com.sumit.model.Options;
import com.sumit.model.QuestionAnswer;
import com.sumit.model.QuestionDTO;
import com.sumit.model.TestSet;
import com.sumit.repository.QuestionRepository;
import com.sumit.repository.TestRipository;
//import com.sumit.api.UserInfoApi;
//import com.sumit.model.UserInfo;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestApi testApi;
	@Autowired
	QuestionApi questionApi;

	@Resource
	TestRipository testRipo;
	
	@Resource
	QuestionRepository questionRipo;


	@Override
	public void save(TestSet test) {
		testApi.create(test);

	}

	@Override
	public List<TestSet> listOfAllTest() {

		return testApi.listOfAllTest();
	}

	@Override
	public TestSet findTestbyId(int id) {

		return testApi.findTestbyId(id);
	}

	@Override
	@Transactional
	
	public void delete(int id) {
		TestSet testToDelet = testApi.findTestbyId(id);
		
		testRipo.delete(testToDelet);
	}

	@Override
	public int countNumberOfDatas() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Transactional
	@Override
	public TestSet update(MainQuestion question, QuestionDTO listOfQuestionId,
			TestSet test,int id) {
		List<MainQuestion> questionsInThisTest = new ArrayList<MainQuestion>() ;
		
		test =testApi.findTestbyId(id);
		questionsInThisTest.addAll(questionApi.findQuestionByTEst(id));
		for (int i : listOfQuestionId.getListOfTestQuestion()) {
			MainQuestion questionInTest = questionApi.findQuestionById(i); 
			questionsInThisTest.add(questionInTest);
			
		}
		
			
		
		test.setQuestionInTest(questionsInThisTest);
		testApi.create(test);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Override
	@Transactional
	public TestSet update(TestSet test,QuestionOptions questionOptions,Options options,QuestionAnswer answerS) {
		MainQuestion savedQuestion = questionRipo.save(question);
		int count = 0;
			for (String value : questionOptions.getListOfOptions()) {
				count++;

				options.setName(value);
				options.setQuestion(savedQuestion);
				Options savedOption = optionRipo.save(options);

				for (String ansValue : questionOpt.getListOfAnswer()) {

					if (count == Integer.parseInt(ansValue)) {

						QuestionAnswer questionAnswers = new QuestionAnswer();

						questionAnswers.setOptionId(savedOption.getid());
						questionAnswers.setQuestion(savedQuestion);
						ansRipo.save(questionAnswers);
						
					}
		}
		
		//test.setName(name);
		test.setQuestionInTest(questionInTest);
		testRipo.save(test);
		return null;
	}	
*/


	


	
}
