package org.training.user.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.user.service.model.Status;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class UserUpdateStatus {

    private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}
