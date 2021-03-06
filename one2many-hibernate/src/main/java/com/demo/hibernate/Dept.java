package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MYDEPT")
public class Dept {
	@Id
	@Column(name="DNO")
	private int deptNo;
	
	@Column(name="DNAME")
	private String deptName;
	
	private String manager;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dept",fetch = FetchType.EAGER)
	//@JoinColumn(name="DNO")
	private Set<Emp> empList=new HashSet<>();

	public Dept() {
		
	}

	public Dept(int deptNo, String deptName, String manager) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.manager = manager;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Set<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(Set<Emp> empList) {
		this.empList = empList;
	}

}
