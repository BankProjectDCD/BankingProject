package org.training.fundtransfer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.training.fundtransfer.model.TransactionStatus;
import org.training.fundtransfer.model.TransferType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
public class FundTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundTransferId;

    private String transactionReference;

    private String fromAccount;

    private String toAccount;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @CreationTimestamp
    private LocalDateTime transferredOn;
    
    
    

	public FundTransfer(Long fundTransferId, String transactionReference, String fromAccount, String toAccount,
			BigDecimal amount, TransactionStatus status, TransferType transferType, LocalDateTime transferredOn) {
		super();
		this.fundTransferId = fundTransferId;
		this.transactionReference = transactionReference;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.status = status;
		this.transferType = transferType;
		this.transferredOn = transferredOn;
	}
	
	
	 private FundTransfer(Builder builder) {
	        this.transactionReference = builder.transactionReference;
	        this.fromAccount = builder.fromAccount;
	        this.toAccount = builder.toAccount;
	        this.amount = builder.amount;
	        this.status = builder.status;
	        this.transferType = builder.transferType;
	    }

	public Long getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(Long fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public LocalDateTime getTransferredOn() {
		return transferredOn;
	}

	public void setTransferredOn(LocalDateTime transferredOn) {
		this.transferredOn = transferredOn;
	}
    
    
	// Builder class
    public static class Builder {
        private String transactionReference;
        private String fromAccount;
        private String toAccount;
        private BigDecimal amount;
        private TransactionStatus status;
        private TransferType transferType;

        public Builder transactionReference(String transactionReference) {
            this.transactionReference = transactionReference;
            return this;
        }

        public Builder fromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
            return this;
        }

        public Builder toAccount(String toAccount) {
            this.toAccount = toAccount;
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

        public Builder transferType(TransferType transferType) {
            this.transferType = transferType;
            return this;
        }

        public FundTransfer build() {
            // Validation
            if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            if (fromAccount == null || fromAccount.isEmpty()) {
                throw new IllegalArgumentException("From account cannot be empty");
            }
            if (toAccount == null || toAccount.isEmpty()) {
                throw new IllegalArgumentException("To account cannot be empty");
            }
            
            return new FundTransfer(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    
    
}