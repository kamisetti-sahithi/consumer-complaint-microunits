package com.dxctraining.consumermgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.ConsumerNotFoundException;

@Repository
public class ConsumerDaoImpl implements IConsumerDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Consumer addConsumer(Consumer consumer) {
		entityManager.persist(consumer);
		return consumer;
	}

	@Override
	public Consumer findConsumerById(int id) {
		Consumer consumer = entityManager.find(Consumer.class, id);
		if(consumer == null) {
			throw new ConsumerNotFoundException("consumer is null");
		}
		return consumer;
	}

	

}
