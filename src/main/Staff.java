package main;


public class Staff {
	private String code;
	private String name;
	private String gender;
	private String position;
	private Integer salary;
	
	public Staff(String code, String name, String gender, String position, Integer salary) {
		this.setCode(code);
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.salary = salary;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getPosition() {
		return position;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}

