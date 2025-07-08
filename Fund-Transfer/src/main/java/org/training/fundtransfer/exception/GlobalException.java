package org.training.fundtransfer.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class GlobalException extends RuntimeException{

    private String errorCode;

    private String message;
    
    
    

    public GlobalException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public GlobalException(String message) {
        this.message = message;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
    
}
