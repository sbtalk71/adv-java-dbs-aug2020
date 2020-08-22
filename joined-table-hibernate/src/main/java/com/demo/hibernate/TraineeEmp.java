package com.demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEE1")
public class TraineeEmp extends Employee {
	protected String performance;

	public TraineeEmp() {

	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
