package com.Irene.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.dojooverflow.models.Answer;
import com.Irene.dojooverflow.models.Question;
import com.Irene.dojooverflow.models.Tag;
import com.Irene.dojooverflow.services.AnswerService;
import com.Irene.dojooverflow.services.QuestionService;
import com.Irene.dojooverflow.services.TagService;

@Controller
public class AnswerQuestionTagController {
	private final AnswerService answerService;
	private final QuestionService questionService;
	private final TagService tagService;
	
	public AnswerQuestionTagController(AnswerService answerService, QuestionService questionService, TagService tagService) {
		this.answerService = answerService;
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String allQuestions(@ModelAttribute("question") Question question, @ModelAttribute("tag") Tag tag, Model model) {
		List<Question> allQuestions = questionService.allQuestions();
		model.addAttribute("allQuestions", allQuestions);
		
		return "allQuestions.jsp";
	}
	
	@RequestMapping(value = "/questions/new", method = RequestMethod.GET)
	public String newQuestion(@ModelAttribute("question") Question question, @ModelAttribute("tag") Tag tag) {
		return "newQuestion.jsp";
	}
	
	@RequestMapping(value = "/questions/new", method = RequestMethod.POST)
	public String createQuestion(@ModelAttribute("question") Question question, BindingResult result) {
		
		if(result.hasErrors() || tagService.tagIsLowercase(question.getTagText()) == false) {
			return "newQuestion.jsp";
		} else {
			
			List<String> tagList = Arrays.asList(question.getTagText().split(","));
			List<Tag> tagObjList = new ArrayList<>();
			for (int i = 0; i < tagList.size(); i++) {
				Tag tagObj = tagService.findTagBySubject(tagList.get(i));
				if(tagObj == null) {
					tagObj = new Tag(tagList.get(i));
					tagService.createTag(tagObj);
				} 
				tagObjList.add(tagObj);
			}
			question.setTag(tagObjList);
			questionService.createQuestion(question);
			return "redirect:/questions/"+ question.getId();
		}
	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public String newAnswer(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		Question quest = questionService.findQuestion(id);
		model.addAttribute("quest", quest);
		List <Tag> questionTags = quest.getTag();
		model.addAttribute("allTags", questionTags);
		List <Answer> allAnswers = quest.getAnswers();
		model.addAttribute("allAnswers", allAnswers);
		return "answers.jsp";
	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
	public String createAnswer(@PathVariable("id") Long id, @ModelAttribute ("answer") Answer answer, BindingResult result) {
		Question question = questionService.findQuestion(id);
		if(result.hasErrors()) {
			return "answers.jsp";
		} else {
			answer.setQuestion(question);
			answerService.createAnswer(answer);
			return "redirect:/questions/{id}";
		}
	}
	
}
