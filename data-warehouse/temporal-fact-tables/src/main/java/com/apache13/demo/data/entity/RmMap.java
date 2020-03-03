package com.apache13.demo.data.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RmMap {
	@Id
	private Integer id;

	@ManyToMany
	private Set<Rm> rms;

	@ManyToMany
	private Set<Customer> customers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Rm> getRms() {
		return rms;
	}

	public void setRms(Set<Rm> rms) {
		this.rms = rms;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
