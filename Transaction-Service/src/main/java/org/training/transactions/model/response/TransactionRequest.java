package org.training.transactions.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class TransactionRequest {

    private String referenceId;

    private String accountId;

    private String transactionType;

    private BigDecimal amount;

    private LocalDateTime localDateTime;

    private String transactionStatus;

    private String comments;

    
	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionRequest(String referenceId, String accountId, String transactionType, BigDecimal amount,
			LocalDateTime localDateTime, String transactionStatus, String comments) {
		super();
		this.referenceId = referenceId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.localDateTime = localDateTime;
		this.transactionStatus = transactionStatus;
		this.comments = comments;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
    
}
