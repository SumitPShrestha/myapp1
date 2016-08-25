 package com.sumit.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mainquestion")
public class MainQuestion implements Serializable {

	public MainQuestion() {

	}
	@Id
	@GeneratedValue
	private int id;

	private String name;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "optionQuestion")
	private List<Options> options;

	/*{
		options = new ArrayList<Options>();
	}*/

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "answerQuestion")
	@Fetch(value = FetchMode.SELECT)
	private List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();

	@ManyToMany(mappedBy="questionInTest")
	private List<TestSet> questiontests;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}
	public List<TestSet> getQuestiontests() {
		return questiontests;
	}

	public void setQuestiontests(List<TestSet> questiontests) {
		this.questiontests = questiontests;
	}


}
