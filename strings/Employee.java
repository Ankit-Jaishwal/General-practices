package com.ankit.strings;

import java.util.Date;

public final class Employee {
	private final Date date;

	public Employee(Date date) {
		this.date = (Date) date.clone();
	}

	public Date getDate() {
		return (Date)date.clone();
	}
	
	
	public static void main(String[] args) {
		Date date = new Date();
		Employee employee = new Employee(date);
		employee.getDate().setMonth(2);
		System.out.println(employee.getDate());
	}

}