package org.training.user.service.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.training.user.service.model.Status;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Data
@Table(name = "users_detail")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "emailid")
    private String emailId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "authid")
    private String authId;

    @Column(name = "identificationnumber")
    private String identificationNumber;

    @CreationTimestamp
    @Column(name = "creationon")
    private LocalDate creationOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userprofileid", referencedColumnName = "userProfileId")
    private UserProfile userProfile;
    
    
    // Static builder method
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    // Builder class
    public static class UserBuilder {
        private Long userId;
        private String emailId;
        private String contactNo;
        private String authId;
        private String identificationNumber;
        private LocalDate creationOn;
        private Status status;
        private UserProfile userProfile;

        public UserBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder emailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public UserBuilder contactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public UserBuilder authId(String authId) {
            this.authId = authId;
            return this;
        }

        public UserBuilder identificationNumber(String identificationNumber) {
            this.identificationNumber = identificationNumber;
            return this;
        }

        public UserBuilder creationOn(LocalDate creationOn) {
            this.creationOn = creationOn;
            return this;
        }

        public UserBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public UserBuilder userProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUserId(userId);
            user.setEmailId(emailId);
            user.setContactNo(contactNo);
            user.setAuthId(authId);
            user.setIdentificationNumber(identificationNumber);
            user.setCreationOn(creationOn);
            user.setStatus(status);
            user.setUserProfile(userProfile);
            return user;
        }
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public LocalDate getCreationOn() {
		return creationOn;
	}

	public void setCreationOn(LocalDate creationOn) {
		this.creationOn = creationOn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
    
}