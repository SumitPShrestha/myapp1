package com.sumit.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sumit.model.MainQuestion;
import com.sumit.model.TestSet;
import com.sumit.repository.QuestionRepository;
import com.sumit.repository.TestRipository;

@Component
public class QuestionApi implements IQuestionApi{
	@Resource
	QuestionRepository questionRipo ;
	
	@Resource
	TestRipository testripo;

	@Override
	public List<MainQuestion> getAllQuestion() {
		
		return questionRipo.findAll();
	}

	@Override
	public MainQuestion findQuestionById(int id) {
		MainQuestion question =questionRipo.findOne(id);
		return question ;
	}

	@Override
	public int countNumberOfDatas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MainQuestion> findQuestionByTEst(int id) {
		TestSet test = testripo.findOne(id);
		List<MainQuestion> questioninTest = questionRipo.FindQuestionInTest(test);
		return questioninTest;
	}
	
	
	
	

}
