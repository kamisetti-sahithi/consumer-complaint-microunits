package com.dxctraining.consumermgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.consumermgt.dao.IConsumerDao;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.ConsumerNotFoundException;
import com.dxctraining.consumermgt.exceptions.InvalidConsumerArgumentException;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {
	
	@Autowired
	private IConsumerDao dao;

	@Override
	public Consumer addConsumer(Consumer consumer) {
		validateConsumer(consumer);
		consumer = dao.addConsumer(consumer);
		return consumer;
	}

	public void validateConsumer(Consumer consumer) {
		if(consumer == null) {
			throw new ConsumerNotFoundException("consumer should not be null");
		}
		
	}

	@Override
	public Consumer findConsumerById(int id) {
		validateId(id);
		Consumer consumer = dao.findConsumerById(id);
		return consumer;
	}

	
		
	}

	
	


