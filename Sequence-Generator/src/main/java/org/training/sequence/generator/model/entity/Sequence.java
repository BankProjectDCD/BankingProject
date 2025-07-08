package org.training.sequence.generator.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "sequence")
public class Sequence {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence_id")
    private Long sequenceId;

    @Column(name = "account_number")
    private Long accountNumber;
    
    
    

    private Sequence(Builder builder) {
        this.sequenceId = builder.sequenceId;
        this.accountNumber = builder.accountNumber;
    }


	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(long sequenceId) {
		this.sequenceId = sequenceId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
    
	 public static class Builder {
	        private Long sequenceId;
	        private Long accountNumber;

	        public Builder() {
	            // Default constructor
	        }

	        public Builder withSequenceId(Long sequenceId) {
	            this.sequenceId = sequenceId;
	            return this;
	        }

	        public Builder withAccountNumber(Long accountNumber) {
	            this.accountNumber = accountNumber;
	            return this;
	        }

	        public Sequence build() {
	            // Add validation if needed
	            if(accountNumber <= 0) {
	                throw new IllegalArgumentException("Account number must be positive");
	            }
	            return new Sequence(this);
	        }
	    }

	    // Static method to get builder instance
	    public static Builder builder() {
	        return new Builder();
	    }
	}
    

