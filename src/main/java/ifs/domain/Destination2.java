package ifs.domain;

public class Destination2 {
	private String startdate;
	private String enddate;

	public Destination2(String startdate, String enddate) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
