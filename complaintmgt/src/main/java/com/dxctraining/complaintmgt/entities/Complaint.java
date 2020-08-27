package com.dxctraining.complaintmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	private int consumerId;
	
	public Complaint() {
		
	}
	
	public Complaint(String description, int consumerId) {
		this.description = description;
		this.consumerId = consumerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Complaint that = (Complaint)obj;
		boolean isEquals = this.id == that.id;
		return isEquals;
	}
	public int hashCode() {
		return id;
	}

}
