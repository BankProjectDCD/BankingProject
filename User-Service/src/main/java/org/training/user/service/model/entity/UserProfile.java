package org.training.user.service.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userprofileid")
    private Integer userProfileId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "martialstatus")
    private String martialStatus;

    @Column(name = "nationality")
    private String nationality;
    
    
    // Static builder method
    public static UserProfileBuilder builder() {
        return new UserProfileBuilder();
    }

    // Builder class
    public static class UserProfileBuilder {
        private Integer userProfileId;
        private String firstName;
        private String lastName;
        private String gender;
        private String address;
        private String occupation;
        private String martialStatus;
        private String nationality;

        public UserProfileBuilder userProfileId(Integer userProfileId) {
            this.userProfileId = userProfileId;
            return this;
        }

        public UserProfileBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserProfileBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserProfileBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserProfileBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserProfileBuilder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public UserProfileBuilder martialStatus(String martialStatus) {
            this.martialStatus = martialStatus;
            return this;
        }

        public UserProfileBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public UserProfile build() {
            UserProfile userProfile = new UserProfile();
            userProfile.setUserProfileId(userProfileId);
            userProfile.setFirstName(firstName);
            userProfile.setLastName(lastName);
            userProfile.setGender(gender);
            userProfile.setAddress(address);
            userProfile.setOccupation(occupation);
            userProfile.setMartialStatus(martialStatus);
            userProfile.setNationality(nationality);
            return userProfile;
        }
    }

	public Integer getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
    
}
