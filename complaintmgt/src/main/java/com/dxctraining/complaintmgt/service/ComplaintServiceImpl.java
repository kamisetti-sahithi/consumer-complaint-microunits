package com.dxctraining.complaintmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.complaintmgt.dao.IComplaintDao;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.ComplaintNotFoundException;
import com.dxctraining.complaintmgt.exceptions.InvalidComplaintArgumentException;

@Transactional
@Service
public class ComplaintServiceImpl implements IComplaintService {
	
	@Autowired
	private IComplaintDao CompDao;

	@Override
	public Complaint add(Complaint complaint) {
		validate(complaint);
		complaint =CompDao.add(complaint);
		return complaint;
	}

	private void validate(Complaint complaint) {
		if(complaint == null) {
			throw new ComplaintNotFoundException("Complaint not found");
		}
		
	}

	@Override
	public Complaint findComplaintById(int id) {
		validateId(id);
		Complaint complaint =CompDao.findComplaintById(id);
		return complaint;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidComplaintArgumentException("id should not be null");
		}
		
	}


	@Override
	public List<Complaint> complaintsByConsumer(int consumerId) {
		List<Complaint> list =CompDao.complaintsByConsumer(consumerId);
		return list;
	}

}
