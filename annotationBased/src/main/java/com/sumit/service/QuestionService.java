package com.sumit.service;

import java.util.List;

import com.sumit.model.MainQuestion;
import com.sumit.model.Options;
import com.sumit.model.QuestionAnswer;
import com.sumit.model.QuestionDTO;
import com.sumit.model.TestSet;

public interface QuestionService {

	public List<MainQuestion> getAllQuestion();
	
	public MainQuestion findQuestionById(int id);
	
	public List<MainQuestion> findQuestionByTEst(int id);
	
	public void save_Question_Option_Answer(MainQuestion question , Options options , QuestionAnswer answer,QuestionDTO listOfOptions);
	

	int countNumberOfDatas();

}
