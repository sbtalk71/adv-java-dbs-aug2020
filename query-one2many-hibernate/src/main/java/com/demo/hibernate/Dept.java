package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MYDEPT")
@NamedQueries({
		@NamedQuery(name = "hql-join", query = "select e.empName,e.salary,d.deptName,d.manager from Dept d inner join d.empList e"), })

@NamedNativeQueries({
		@NamedNativeQuery(name = "sql-join", query = "select e.name,e.salary,d.dname,d.manager from MYEMP e inner join MYDEPT d on e.DNO=d.DNO") })
public class Dept {
	@Id
	@Column(name = "DNO")
	private int deptNo;

	@Column(name = "DNAME")
	private String deptName;

	private String manager;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dept", fetch = FetchType.EAGER)
	// @JoinColumn(name="DNO")
	private Set<Emp> empList = new HashSet<>();

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
