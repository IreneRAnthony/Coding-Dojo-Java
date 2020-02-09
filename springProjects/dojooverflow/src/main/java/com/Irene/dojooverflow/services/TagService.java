package com.Irene.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.dojooverflow.models.Tag;
import com.Irene.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public List<Tag> allTags(){
		return tagRepository.findAll();
	}
	
	public Tag createTag(Tag b) {
		return tagRepository.save(b);
	}
	
	public void deleteTag(Long id) {
		tagRepository.deleteById(id);
	}
	
	public Tag findTag(Long id) {
		Optional <Tag> optionalTag = tagRepository.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
	public Tag updateTag(Tag tag) {
		tagRepository.save(tag);
		return null;
	}
	
	public Boolean tagExists(Long id) {
		if(tagRepository.findById(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findBySubject(subject);
	}
	
	public Boolean tagIsLowercase(String checkTag) {
		boolean hasUpperCase = !checkTag.equals(checkTag.toLowerCase());
		if(hasUpperCase) {
			return false;
		} else {
			return true;
		}
		}
	
}
