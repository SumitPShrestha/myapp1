package com.sumit.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sumit.model.TestSet;
import com.sumit.repository.TestRipository;

@Component
public class TestApi implements ITestApi{
	@Resource
	TestRipository testRipo ;
	
	
	@Override
	public List<TestSet> listOfAllTest() {
      List<TestSet> allTest = testRipo.findAll();
		
		return allTest;
	}

	@Override
	public TestSet findTestbyId(int id) {
		TestSet test = testRipo.findOne(id);
		return test;
	}

	

	@Override
	public int countNumberOfDatas() {
		
		return 0;
	}

	@Override
	public void create(TestSet test) {
		testRipo.save(test);
	}

	public TestSet delete(int id) {
		TestSet  deletedTest = testRipo.findOne(id);
		testRipo.delete(deletedTest);
		// TODO Auto-generateD method stub
		return null;
	}
	

}
