package org.training.fundtransfer.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class FundTransferResponse {

    private String transactionId;

    private String message;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	 private FundTransferResponse(Builder builder) {
	        this.transactionId = builder.transactionId;
	        this.message = builder.message;
	    }
    
	// Builder class
    public static class Builder {
        private String transactionId;
        private String message;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public FundTransferResponse build() {
            // Add validation if needed
            if (transactionId == null || transactionId.isEmpty()) {
                throw new IllegalArgumentException("Transaction ID cannot be null or empty");
            }
            if (message == null || message.isEmpty()) {
                throw new IllegalArgumentException("Message cannot be null or empty");
            }
            return new FundTransferResponse(this);
        }
    }

    // Static builder method
    public static Builder builder() {
        return new Builder();
    }

    
}
