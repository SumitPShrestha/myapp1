package com.sumit.api;

import java.util.List;

import com.sumit.model.MainQuestion;

public interface IQuestionApi {
	

	public List<MainQuestion> getAllQuestion();
	
	public MainQuestion findQuestionById(int id);
	
	public List<MainQuestion> findQuestionByTEst(int id);
	
	
	

	
	
	int countNumberOfDatas();

	


}