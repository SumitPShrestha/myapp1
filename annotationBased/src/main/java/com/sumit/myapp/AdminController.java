package com.sumit.myapp;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.model.MainQuestion;
import com.sumit.model.Options;
import com.sumit.model.QuestionAnswer;
import com.sumit.model.QuestionDTO;
import com.sumit.model.TestSet;
import com.sumit.repository.AnsRepository;
import com.sumit.repository.OptionsRepository;
import com.sumit.repository.QuestionRepository;
import com.sumit.repository.TestRipository;
import com.sumit.service.AnsService;
import com.sumit.service.OptionService;
import com.sumit.service.QuestionService;
import com.sumit.service.TestService;

//import com.sumit.service.UserInfoService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {
	@Resource
	QuestionRepository questionRipo;
	@Resource
	OptionsRepository optionRipo;
	@Resource
	AnsRepository ansRipo;
	@Resource
	TestRipository testRipo;
	@Autowired
	TestService testService;
	@Autowired
	QuestionService questionService;
	@Autowired
	OptionService optionService;
	@Autowired
	AnsService ansService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal principal) {
		ModelAndView mav = new ModelAndView("admin");
		//<MainQuestion> allQuestions = questionRipo.findAll();
		String adminName = principal.getName();
		mav.addObject("name", adminName);

		/*
		 * List<MainQuestion> listOfQuestions= questionRipo.findAll();
		 * mav.addObject("allQuestions", allQuestions);
		 * */



		return mav;
	}

	@RequestMapping(value = "/setQuestion", method = RequestMethod.GET)
	public ModelAndView setQuestionPage() {
		ModelAndView mav = new ModelAndView("Question");
		//<MainQuestion> allQuestions = questionRipo.findAll();
		/*
		 * List<MainQuestion> listOfQuestions= questionRipo.findAll();
		 * mav.addObject("allQuestions", allQuestions);
		 * */



		return mav;
	}
/*
	@RequestMapping(value = "/setQuestion", method = RequestMethod.POST)
	public ModelAndView setQuestion(@Valid MainQuestion question,
			@Valid Options options, @Valid QuestionDTO listOfOptions,
			@Valid QuestionAnswer answer, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("Question");
		questionService.save_Question_Option_Answer(question, options, answer,
				listOfOptions);
		return mav;
	}*/
	@RequestMapping(value = "/setQuestion", method = RequestMethod.POST)
	@ResponseBody
	public  String setQuestion(@Valid MainQuestion question,
			@Valid Options options, @Valid QuestionDTO listOfOptions,
			@Valid QuestionAnswer answer) {

		questionService.save_Question_Option_Answer(question, options, answer,
				listOfOptions);
	return question.getName();
	}

	@RequestMapping(value = "/createTestAndQuestion", method = RequestMethod.GET)
	public ModelAndView createTestWithQuestion() {
		List<TestSet> tests = testRipo.findAll();
		ModelAndView mav = new ModelAndView("CreateTest");
		mav.addObject("tests", tests);
		List<MainQuestion> questionList = questionRipo.findAll();
		mav.addObject("questionList", questionList);
		return mav;
	}

	@RequestMapping(value = "/createTestAndQuestion", method = RequestMethod.POST)
	public ModelAndView createTestPage(@Valid TestSet test,
			@Valid QuestionDTO questionOpt) {
		// testSet.setQuestionInTest();

		ModelAndView mav = new ModelAndView("CreateTest");
		List<MainQuestion> questions = new ArrayList<MainQuestion>();
		TestSet populateTestWithQuestions = testRipo.save(test);
		int currentTestId = populateTestWithQuestions.getId();
		test = testRipo.findOne(currentTestId);
		for (int var : questionOpt.getListOfTestQuestion()) {
			MainQuestion question = questionRipo.findOne(var);
			questions.add(question);

		}

		test.setQuestionInTest(questions);

		List<MainQuestion> questionList = questionRipo.findAll();
		mav.addObject("questionList", questionList);
		return mav;
	}

	@RequestMapping(value = "/createTest", method = RequestMethod.GET)
	public ModelAndView createTestPage(@Valid TestSet test) {
		ModelAndView mav = new ModelAndView("CreateTest");
		@SuppressWarnings("unused")
		List<MainQuestion> listOfQuestions = questionService.getAllQuestion();
		String message = "ALL QUESTION TABLE";
		mav.addObject("message", message);
		mav.addObject("listofquestions", listOfQuestions);

		return mav;
	}

	@RequestMapping(value = "/createTest", method = RequestMethod.POST)
	public ModelAndView createTest(@Valid TestSet test) {
		ModelAndView mav = new ModelAndView("CreateTest");
		testRipo.save(test);
		List<TestSet> tests = testRipo.findAll();
		mav.addObject("tests", tests);

		List<MainQuestion> questionList = questionRipo.findAll();
		mav.addObject("questionList", questionList);

		return mav;

	}

	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
	public ModelAndView getQuestionsInTest(@Valid TestSet test,
			@PathVariable Integer id) {
		TestSet testForQuestion = testService.findTestbyId(id);
		ModelAndView mav = new ModelAndView("TestQuestion");

		List<MainQuestion> questionsInTest = questionService
				.findQuestionByTEst(id);

		mav.addObject("questionsInTestToSelect", questionsInTest);
		mav.addObject("t", testForQuestion);
		return mav;

	}

	@RequestMapping(value = "/updateTest/{id}", method = RequestMethod.GET)
	public ModelAndView updateTest(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("update-test");
		TestSet testToUpdate = testRipo.findOne(id);

		List<MainQuestion> listOfQuestions = questionRipo.findAll();
		List<MainQuestion> questionsInTest = questionService
				.findQuestionByTEst(id);
		mav.addObject("message", testToUpdate.getName());
		mav.addObject("testId", testToUpdate.getId());
		mav.addObject("listOfQuestions", listOfQuestions);
		mav.addObject("questionsintest", questionsInTest);
		return mav;
	}

	@RequestMapping(value = "/updateTest/{id}", method = RequestMethod.POST)
	public ModelAndView updateTest(@Valid TestSet test,
			@Valid QuestionDTO listOfQuestionId, @PathVariable Integer id,
			MainQuestion question) {
		ModelAndView mav = new ModelAndView("update-test");
		testService.update(question, listOfQuestionId, test, id);
		/*
		 * test = testService.findTestbyId(id); List<MainQuestion>
		 * questionsInTest = new ArrayList<MainQuestion>(); for (int i :
		 * listOfQuestionInTest.getListOfTestQuestion()) {
		 *
		 * MainQuestion questionInTest = questionService.findQuestionById(i);
		 * questionsInTest.add(questionInTest);
		 *
		 * } test.setQuestionInTest(questionsInTest); testRipo.save(test);
		 */

		mav.setViewName("TestQuestion");


		TestSet t = testRipo.findOne(id);
		List<MainQuestion> questionsInTestToSelect = questionRipo
				.FindQuestionInTest(t);
		mav.addObject("t", t);
		mav.addObject("questionsInTestToSelect", questionsInTestToSelect);

		return mav;
	}

	@RequestMapping(value = "/deleteTest/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTest(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("CreateTest");

		testService.delete(id);

		return mav;
	}

	@Transactional
	@RequestMapping(value = "/viewOptNAnsOf/{id}", method = RequestMethod.GET)
	public ModelAndView viewOptNAns(@PathVariable Integer id,
			@Valid MainQuestion question, Options option) {

		ModelAndView mav = new ModelAndView("QuestionOptionAnswer");

		MainQuestion questionIoprocess = questionService.findQuestionById(id);

		List<Options> options = optionService.findOptionsByQuestion(id);


		mav.addObject("a", ansService.getAnsName(id));
		mav.addObject("q", questionIoprocess);
		mav.addObject("o", options);

		return mav;
	}
}
