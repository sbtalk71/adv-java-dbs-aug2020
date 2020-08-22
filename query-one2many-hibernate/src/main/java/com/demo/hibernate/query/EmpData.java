package com.demo.hibernate.query;

public class EmpData {

	private int empId;
	private String empName;
	private String city;
	private double salary;

	public EmpData(int empId, String empName, String city, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.salary = salary;
	}

	public EmpData(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public EmpData(int empId, String empName, String city) {
		this.empId = empId;
		this.empName = empName;
		this.city = city;

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
