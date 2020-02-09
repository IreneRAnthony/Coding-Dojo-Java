package com.Irene.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.dojooverflow.models.Answer;
import com.Irene.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> allAnswers(){
		return answerRepository.findAll();
	}
	
	public Answer createAnswer(Answer b) {
		return answerRepository.save(b);
	}
	
	public Answer findAnswer(Long id) {
		Optional <Answer> optionalAnswer = answerRepository.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
	
	public void deleteAnswer(Long id) {
		answerRepository.deleteById(id);
	}
	
	public Answer updateAnswer(Answer answer) {
		answerRepository.save(answer);
		return null;
	}
	
}
