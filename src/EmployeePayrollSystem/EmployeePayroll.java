package EmployeePayrollSystem;

import java.util.ArrayList;

abstract class EmployeePayroll {
	private String name;
	private int id;
	//constructor
	public EmployeePayroll(String name,int id) {
		this.name=name;
		this.id=id;
	}
	//encapsulation
	public String getname() {
		return name;
	}
	public int getid() {
		return id;
	}
	
	public abstract double calculatesalary();
	//polymorphism
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ",salary="+calculatesalary()+"]";
	}
}
	

class Fulltimeemployee extends EmployeePayroll{
		private double monthlysalary;
		
		public Fulltimeemployee(String name,int id,double monthlysalary) {
			super(name,id);
			this.monthlysalary=monthlysalary;
			
		}
		public double calculatesalary() {
			return monthlysalary;
	}
	
}
		
class Parttimeemployee extends EmployeePayroll{
		private int hoursworked;
		
		private double hourlyrate;
		
		public Parttimeemployee(String name,int id,int hoursworked,double hourlyrate) {
			super(name,id);
			this.hoursworked=hoursworked;
			this.hourlyrate=hourlyrate;
			
		}

		@Override
		public double calculatesalary() {
			return  hoursworked*hourlyrate;
		}
	}


	class payrollsystem{
		private ArrayList<EmployeePayroll> employeeList;
		public payrollsystem() {
			employeeList=new ArrayList<>();
		}
		public void addemployee(EmployeePayroll employee) {
			employeeList.add(employee);
		}
		public void removeemployee( int id) {
			EmployeePayroll employeetoremove=null;
			for(EmployeePayroll employee:employeeList) {
				if(employee.getid()==id) {
					employeetoremove=employee;
					break;
					
				}
			}
			if(employeetoremove!=null) {
				employeeList.remove(employeetoremove);
			}
		}
	public void displayemployee() {
		for(EmployeePayroll employee:employeeList) {
			System.out.println(employee);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		payrollsystem  payrollsystem=new payrollsystem();
		Fulltimeemployee emp1 =new Fulltimeemployee("vikas",1,70000);
		Parttimeemployee emp2=new Parttimeemployee("alex",2,40,100);
		payrollsystem.addemployee(emp1);
		payrollsystem.addemployee(emp2);
		System.out.println("Initial Employee Details: ");
		payrollsystem.displayemployee();
		System.out.println("Removing employee");
		payrollsystem.removeemployee(2);
		System.out.println("Remaining Employees Details");
		payrollsystem.displayemployee();
		
	}
	

}
