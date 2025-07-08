package org.training.transactions.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.training.transactions.model.TransactionStatus;
import org.training.transactions.model.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "account_id")
    private String accountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "amount")
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "comments")
    private String comments;
    
    
    
    public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(Long transactionId, String referenceId, String accountId, TransactionType transactionType,
			BigDecimal amount, LocalDateTime transactionDate, TransactionStatus status, String comments) {
		super();
		this.transactionId = transactionId;
		this.referenceId = referenceId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.status = status;
		this.comments = comments;
	}
	
	
	 private Transaction(Builder builder) {
	        this.referenceId = builder.referenceId;
	        this.accountId = builder.accountId;
	        this.transactionType = builder.transactionType;
	        this.amount = builder.amount;
	        this.status = builder.status;
	        this.comments = builder.comments;
	    }



	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
	public static class Builder {
        private String referenceId;
        private String accountId;
        private TransactionType transactionType;
        private BigDecimal amount;
        private TransactionStatus status;
        private String comments;

        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder transactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder status(TransactionStatus status) {
            this.status = status;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
    
    
}
