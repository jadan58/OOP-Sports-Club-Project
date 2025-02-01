package project;

public class Member {
	private String name;
	private int age;
	private String role;
	private int salary;
	
	public Member(String name,int age,String role,int salary) {
		this.name = name;
		this.age = age;
		this.role = role;
		this.salary = salary;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
		public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

		public String introduce() {
		return "Name: "+name+ "\n"
				+"Age: "+age+ "\n"
				+"Salary: "+salary+ "\n";
	}
	
	

}