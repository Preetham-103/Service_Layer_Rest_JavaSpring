package com.cts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp30")
@Data
public class Employee {

	@Id
	private int id;
	private String name;
	private String dept;
	private int age;
	private double salary;
}
