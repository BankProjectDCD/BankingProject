package com.example.bank.app.data.payload.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

public class TransactionResponse {
    private Long id;
    private String transactionId;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	private BigDecimal amount;
    private String transactionType;
    private String description;
    private LocalDateTime createdAt;

    public TransactionResponse(Long id, String transactionId, BigDecimal amount, 
                             String transactionType, String description, LocalDateTime createdAt) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.createdAt = createdAt;
    }
}