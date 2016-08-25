package com.sumit.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

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
import com.sumit.repository.AnsRepository;
import com.sumit.repository.OptionsRepository;
import com.sumit.repository.QuestionRepository;
import com.sumit.repository.TestRipository;
//import com.sumit.api.UserInfoApi;
//import com.sumit.model.UserInfo;

@Service
public class QuestionServiceImpl implements QuestionService {
	 @Autowired
	QuestionApi questionApi;

	@Resource
	TestRipository testRipo;
	
	@Resource
	QuestionRepository questionRipo;
	
	@Resource
	OptionsRepository optionRipo;
	
	@Resource
	AnsRepository ansRipo;

	@Override
	public List<MainQuestion> getAllQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MainQuestion findQuestionById(int id) {
		// TODO Auto-generated method stub
		return questionRipo.findOne(id);
	}

	@Override
	public List<MainQuestion> findQuestionByTEst(int id) {
		
		return questionApi.findQuestionByTEst(id);
	}

	 
 

	@Override
	public int countNumberOfDatas() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override
	public void save_Question_Option_Answer(MainQuestion question,
			Options options, QuestionAnswer answer,
			QuestionDTO listOfOptions) {

		MainQuestion savedQuestion = questionRipo.save(question);
		int count = 0;
		for (String value : listOfOptions.getListOfOptions()) {
			count++;

			options.setName(value);
			options.setQuestion(savedQuestion);
			Options savedOption = optionRipo.save(options);

			for (String ansValue : listOfOptions.getListOfAnswer()) {

				if (count == Integer.parseInt(ansValue)) {

					QuestionAnswer questionAnswers = new QuestionAnswer();

					questionAnswers.setOptionId(savedOption.getid());
					questionAnswers.setQuestion(savedQuestion);
					ansRipo.save(questionAnswers);
					
				}

			}
			

		}
		
	}

	

	
	

}
