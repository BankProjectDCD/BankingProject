package org.training.transactions.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.transactions.model.TransactionType;

import java.math.BigDecimal;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class TransactionDto {

    private String accountId;

    private String transactionType;

    private BigDecimal amount;

    private String description;
    
    

	public TransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDto(String accountId, String transactionType, BigDecimal amount, String description) {
		super();
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
}
