package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Vampire")
public class Vampire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1504486512300380103L;

	public Vampire(int v_id, String name, int age, String firstAppearance) {
		super();
		this.v_id = v_id;
		this.name = name;
		this.age = age;
		this.firstAppearance = firstAppearance;
	}
	
	public Vampire(String name, int age, String firstAppearance) {
		super();
		this.name = name;
		this.age = age;
		this.firstAppearance = firstAppearance;
	}

	public Vampire() {
		super();

	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="vampireSequence")
	@SequenceGenerator(allocationSize=1,name="vampireSequence",sequenceName="SQ_VAMPIRE_PK")
	@Column(name="VAMPIRE_ID")
	public int v_id;
	
	@Column(name = "NAME")
	public String name;

	@Column(name = "AGE")
	public int age;

	@Column(name = "APPEARANCE")
	public String firstAppearance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstAppearance() {
		return firstAppearance;
	}

	public void setFirstAppearance(String firstAppearance) {
		this.firstAppearance = firstAppearance;
	}

	@Override
	public String toString() {
		return "Vampire [name=" + name + ", age=" + age + ", firstAppearance=" + firstAppearance + "]";
	}

}
