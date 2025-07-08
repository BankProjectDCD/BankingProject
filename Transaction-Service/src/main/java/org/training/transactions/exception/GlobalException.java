package org.training.transactions.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class GlobalException extends RuntimeException {

    private String errorCode;

    private String errorMessage;
    
    
    public GlobalException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public GlobalException(String message) {
        this.errorMessage = message;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}
    
    
}
