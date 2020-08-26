package com.dxctraining.consumermgt.util;
import  com.dxctraining.consumermgt.dto;
@Component
public class ConsumerUtil {


    public ConsumerDto consumerDto(Consumer consumer){
    	ConsumerDto consumerDto=new ConsumerDto(consumer.getId(),consumer.getName());
        return consumerDto;

    }

}
