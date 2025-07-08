package org.training.user.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class GlobalException extends RuntimeException{

    private String message;

    private String errorCode;
    
    

    public GlobalException(String message, String errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public GlobalException(String message) {
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
    
    
}
