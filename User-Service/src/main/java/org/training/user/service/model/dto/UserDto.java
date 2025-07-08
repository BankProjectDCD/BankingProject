package org.training.user.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.user.service.model.Status;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class UserDto {

    private Long userId;

    private String emailId;

    private String password;

    private String identificationNumber;

    private String authId;

    private Status status;

    private UserProfileDto userProfileDto;
    
    
    // Static builder method
    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private Long userId;
        private String emailId;
        private String password;
        private String identificationNumber;
        private String authId;
        private Status status;
        private UserProfileDto userProfileDto;

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder emailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder identificationNumber(String identificationNumber) {
            this.identificationNumber = identificationNumber;
            return this;
        }

        public Builder authId(String authId) {
            this.authId = authId;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder userProfileDto(UserProfileDto userProfileDto) {
            this.userProfileDto = userProfileDto;
            return this;
        }

//        public UserDto build() {
//            return new UserDto(this);
//        }
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserProfileDto getUserProfileDto() {
		return userProfileDto;
	}

	public void setUserProfileDto(UserProfileDto userProfileDto) {
		this.userProfileDto = userProfileDto;
	}
   
}
