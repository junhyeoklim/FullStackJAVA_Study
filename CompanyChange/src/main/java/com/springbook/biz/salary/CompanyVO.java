package com.springbook.biz.salary;

public class CompanyVO {

	private int s_id;
	private String s_name;
	private int s_birth;
	private String s_gender;
	private int s_salary;	
	private String s_department;
	private String s_rank;
	private String s_mail;
	private String s_phoneNumber;
	private String date;
	private String updateTime;
	
	public int getS_birth() {
		return s_birth;
	}
	public void setS_birth(int s_birth) {
		this.s_birth = s_birth;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getS_salary() {
		return s_salary;
	}
	public void setS_salary(int s_salary) {
		this.s_salary = s_salary;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_department() {
		return s_department;
	}
	public void setS_department(String s_department) {
		this.s_department = s_department;
	}
	public String getS_rank() {
		return s_rank;
	}
	public void setS_rank(String s_rank) {
		this.s_rank = s_rank;
	}
	public String getS_mail() {
		return s_mail;
	}
	public void setS_mail(String s_mail) {
		this.s_mail = s_mail;
	}
	public String getS_phoneNumber() {
		return s_phoneNumber;
	}
	public void setS_phoneNumber(String s_phoneNumber) {
		this.s_phoneNumber = s_phoneNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
