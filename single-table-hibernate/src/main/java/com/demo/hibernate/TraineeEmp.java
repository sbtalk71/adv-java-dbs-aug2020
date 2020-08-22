package com.demo.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "T")
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
