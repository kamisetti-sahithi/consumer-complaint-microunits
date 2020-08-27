package com.dxctraining.complaintmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.entities.Complaint;

@Component
public class ComplaintUtil {
	public ComplaintDto complaintDto(Complaint complaint, int consumerId, String consumerName) {
		ComplaintDto CompDto = new ComplaintDto(complaint.getId(),complaint.getDescription(),complaint.getConsumerId(),consumerName);
		CompDto.setConsumerId(consumerId);
		CompDto.setConsumerName(consumerName);
		CompDto.setDescription(complaint.getDescription());
		return CompDto;
	}

}
