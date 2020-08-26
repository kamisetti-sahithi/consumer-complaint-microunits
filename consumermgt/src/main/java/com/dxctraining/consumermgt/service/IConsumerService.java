package com.dxctraining.consumermgt.service;

import java.util.List;

import com.dxctraining.consumermgt.entities.Consumer;

public interface IConsumerService {
	Consumer addConsumer(Consumer consumer);
	Consumer findConsumerById(int id);
	

}
