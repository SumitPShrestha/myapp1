package com.sumit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestSet implements Serializable {

	public TestSet() {

	}

	@Id
	@GeneratedValue
	private int id;
	private String name;


	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "test_question", joinColumns = { @JoinColumn(name = "test_id") }, inverseJoinColumns = { @JoinColumn(name = "mainquestion_id") })
	public List<MainQuestion> questionInTest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public List<MainQuestion> getQuestionInTest() {
		return questionInTest;
	}

	public void setQuestionInTest(List<MainQuestion> questionInTest) {
		this.questionInTest = questionInTest;
	}

}
