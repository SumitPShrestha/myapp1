package com.sumit.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "optionss")
public class Options implements Serializable {

	public Options(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Options(int id, String name, MainQuestion question) {
		super();
		this.id = id;
		this.name = name;
		this.optionQuestion = question;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private int id;

	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mainquestion_id")
	private MainQuestion optionQuestion;

	public MainQuestion getQuestion() {
		return optionQuestion;
	}

	public void setQuestion(MainQuestion mainQuestion) {
		this.optionQuestion = mainQuestion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Options() {
	}

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String option) {
		this.name = option;
	}

}
