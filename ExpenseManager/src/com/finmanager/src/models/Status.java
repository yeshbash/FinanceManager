package com.finmanager.src.models;

import java.util.List;

public class Status {

	public String statusCode;
	public String statusMessage;
	public List<AdditionalStatus> additionalStatus;
	
	public Status(){};
	public Status(String statusCode, String statusMessage,
			List<AdditionalStatus> additionalStatus) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.additionalStatus = additionalStatus;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<AdditionalStatus> getAdditionalStatus() {
		return additionalStatus;
	}
	public void setAdditionalStatus(List<AdditionalStatus> additionalStatus) {
		this.additionalStatus = additionalStatus;
	}
}
