package Pojos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EmployeesExpectedPojo {

	private String status;
	private Data data;
	private String message;

	public EmployeesExpectedPojo() {
	}

	public EmployeesExpectedPojo(String status, Data data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("status", status).append("data", data).append("message", message)
				.toString();
	}

}
