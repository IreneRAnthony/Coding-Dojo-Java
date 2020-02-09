package com.Irene.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.dojooverflow.models.Question;
import com.Irene.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}
	
	public Question createQuestion(Question b) {
		return questionRepository.save(b);
	}
	
	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}
	
	public Question findQuestion(Long id) {
		Optional <Question> optionalQuestion = questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public Question updateQuestion(Question question) {
		questionRepository.save(question);
		return null;
	}
	
}
