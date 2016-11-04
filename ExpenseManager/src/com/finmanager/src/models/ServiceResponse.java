package com.finmanager.src.models;

import org.bson.Document;

public class ServiceResponse {

	public Status status;
	public Document resposnePayload;
	
	public ServiceResponse(){}
	
	public ServiceResponse(Status status, Document resposnePayload) {
		super();
		this.status = status;
		this.resposnePayload = resposnePayload;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Document getResposnePayload() {
		return resposnePayload;
	}
	public void setResposnePayload(Document resposnePayload) {
		this.resposnePayload = resposnePayload;
	}
	
	
}
