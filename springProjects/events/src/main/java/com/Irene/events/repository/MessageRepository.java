package com.Irene.events.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Irene.events.model.Message;

@Repository
public interface MessageRepository extends CrudRepository <Message, Long> {
	List<Message> findAll();
}
