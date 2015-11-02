package com.example.domain;

public class JsonResponse {
	private String status = null;
	private Object result = null;
	private Object data=null;
	
	public Object getData() {
		return data;
	}
	public void setdata(String data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
