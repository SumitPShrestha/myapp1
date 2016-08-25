package com.sumit.service;

import java.util.List;

import com.sumit.model.MainQuestion;
import com.sumit.model.Options;
import com.sumit.model.QuestionAnswer;
import com.sumit.model.QuestionDTO;
import com.sumit.model.TestSet;

public interface TestService {
	public void save(TestSet test);

	public List<TestSet> listOfAllTest();

	public TestSet findTestbyId(int id);

	public TestSet update(MainQuestion question, QuestionDTO listOfQuestionId,TestSet test ,int id);

	public void delete(int id);

	

	int countNumberOfDatas();

}
