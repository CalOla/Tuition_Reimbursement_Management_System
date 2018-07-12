package com.calebo.rev.project01.pojos;


public class Employee
{
	private int employeeId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phoneNumber;
	private String dob;
	private String address;
	private String position;
	private String supervisor;
	private String department;
	private double balance;
	private String departmentHead;
//	private ReimbursementForm[] form;
//	private int formLength = 0;

	public Employee()
	{
		super();
		firstname = "";
		lastname = "";
		email = "";
		password = "";
		phoneNumber = "";
		dob = "";
		address = "";
		position = "";
		supervisor = "";
		department = "";
		balance = 0.0;
		employeeId = 0;
	}
	

	public Employee(String firstname, String lastname, String email, String password, String phoneNumber, String dob,
			String address, String position, String supervisor, String department, double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.address = address;
		this.position = position;
		this.supervisor = supervisor;
		this.department = department;
		this.balance = balance;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public void login(String email, String password)
	{
		setEmail(email);
		setPassword(password);
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getDepartmentHead() {
		return departmentHead;
	}


	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	
//	public ReimbursementForm getForm(int i) {
//		return form[i];
//	}
//	
//	public ReimbursementForm[] getAllForms() {
//		
//		return form;
//	}

//	public void setForm(ReimbursementForm fm) {
//		form[formLength] = fm;
//		formLength++;
//	}  
//	
//	public int getFormLength()
//	{
//		return formLength;
//	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", address=" + address + ", position="
				+ position + ", supervisor=" + supervisor + ", department=" + department + ", balance=" + balance + "]";
	}
}
