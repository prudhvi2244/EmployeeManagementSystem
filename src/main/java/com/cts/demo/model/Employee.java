package com.cts.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	
	
	public Employee(String ename, String ecity) {
		super();
		this.ename = ename;
		this.ecity = ecity;
	}
	@Id
	@GeneratedValue
	private Integer eid;
	@Column
	private String ename;
	@Column
	private String ecity;

}
