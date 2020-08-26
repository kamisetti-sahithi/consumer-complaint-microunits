package com.dxctraining.consumermgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.consumermgt.dto.ConsumerDto;
import com.dxctraining.consumermgt.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.service.IConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerRestController {
	
	@Autowired
	private IConsumerService service;
	@Autowired
	private ConsumerUtil util;

	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ConsumerDto addConsumer(@RequestBody CreateConsumerRequest requestData) {
		Consumer consumer = new Consumer(requestData.getName());
		service.addConsumer(consumer);
		ConsumerDto response =util.consumerDto(consumer);
		return response;
	}

	private ConsumerDto consumerDto(Consumer consumer) {
		ConsumerDto dto = new ConsumerDto();
		dto.setId(consumer.getId());
		dto.setName(consumer.getName());
		return dto;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ConsumerDto findConsumerById(@PathVariable("id")int id) {
		Consumer consumer = service.findConsumerById(id);
		onsumerDto response =util.consumerDto(consumer);
		return response;
	}
	
	

}
