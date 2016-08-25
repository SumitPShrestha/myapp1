package com.sumit.api;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sumit.model.TestSet;


@Component
public interface ITestApi {
	

	public List<TestSet> listOfAllTest();
	public TestSet findTestbyId(int id);
	public void create(TestSet test);
	

	
	
	int countNumberOfDatas();

	


}