package com.sumit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sumit.model.MainQuestion;
import com.sumit.model.TestSet;

public interface QuestionRepository extends  JpaRepository<MainQuestion, Integer> {
@Query("SELECT q FROM MainQuestion q JOIN  q.questiontests t WHERE t IN (?1)")



	List<MainQuestion> FindQuestionInTest(TestSet t);



}
