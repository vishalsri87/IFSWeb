package ifs.domain;

public class Destination1 {
	private String empId;
	private String dob;

	public Destination1(String empId, String dob) {
		super();
		this.empId = empId;
		this.dob = dob;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
