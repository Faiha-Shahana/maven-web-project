package first.webapp;


public class User {
	protected String employee_name;
	 protected String employee_phone;
	 protected String employee_pay;
	 protected String salary_status;
	 
	 public  User(String name, String phone, String pay, String salary) {
	 	super();
	 	this.employee_name=name;
	 	this.employee_phone= phone;
	 	this.employee_pay= pay;
	 	this.salary_status= salary;
}	 	
	 	
	 	
	 
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}
	public String getEmplyee_pay() {
		return employee_pay;
	}
	public void setEmplyee_pay(String emplyee_pay) {
		this.employee_pay = emplyee_pay;
	}
	public String getSalary_status() {
		return salary_status;
	}
	public void setSalary_status(String salary_status) {
		this.salary_status = salary_status;
	}
	 

}