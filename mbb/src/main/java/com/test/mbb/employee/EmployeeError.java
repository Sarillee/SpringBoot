package com.test.mbb.employee;

import org.springframework.web.bind.annotation.GetMapping;

public class EmployeeError 
{
	private String errorMsg;
	private int errorCode;
	
	
	public EmployeeError(String errorMsg, int errorCode) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}


	public EmployeeError(int errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = getErrorMessage(errorCode);
	}
	


	@Override
	public String toString() 
	{
		return "{\"ErrorCode\":" + errorCode + ",\"Message\":\""+ errorMsg + "\"}";
	}
	
	
	
	
	private String getErrorMessage(int code)
	{
		String value="";
		switch (code)
		{
			case 0:
			{
				value="Success";
				break;
			}
			case 101:
			{
				value="Fail, Email was taken";
				break;
			}
			case 102:
			{
				value="Fail, ID not Exists";
				break;
			}
		}
		return value;
	}


	/*@Override
	public String toString() {
		return "[errorMsg=" + errorMsg + ", errorCode=" + errorCode + "]";
	}*/
	

}
