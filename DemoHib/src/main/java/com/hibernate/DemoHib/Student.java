package com.hibernate.DemoHib;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	
	@Id
	private String usn;
	private String name;
	private int sem;
	
	
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + ", sem=" + sem + "]";
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}

}
