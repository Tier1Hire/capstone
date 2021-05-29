package com.codeup.tier1hire.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//import javax.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private Date createAt;

    @Column
    private boolean isAdmin;

    @Column
    private boolean isVerified;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
//    @VaildPassword
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private Date dateOfBirth;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "varchar(200) default 'N/A'")
    private String alias;

    // # and street name
    @Column
    private String address1;

    // city, state, zip
    @Column
    private String address2;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private List<Education> educationHistory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private List<EmploymentDetail> employmentHistory;

    public User() {
    }

    public User(long userId, Date createAt, boolean isAdmin, boolean isVerified, String username, String password, String firstName, String lastName, String email, Date dateOfBirth, String phoneNumber, String alias, String address1, String address2, List<Education> educationHistory, List<EmploymentDetail> employmentHistory) {
        this.userId = userId;
        this.createAt = createAt;
        this.isAdmin = isAdmin;
        this.isVerified = isVerified;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.alias = alias;
        this.address1 = address1;
        this.address2 = address2;
        this.educationHistory = educationHistory;
        this.employmentHistory = employmentHistory;
    }

    public User(User copy) {
        this.userId = copy.userId; // This line is SUPER important! Many things won't work if it's absent
        this.createAt = copy.createAt;
        this.isAdmin = copy.isAdmin;
        this.isVerified = copy.isVerified;
        this.username = copy.username;
        this.password = copy.password;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.dateOfBirth = copy.dateOfBirth;
        this.phoneNumber = copy.phoneNumber;
        this.alias = copy.alias;
        this.address1 = copy.address1;
        this.address2 = copy.address2;
        this.educationHistory = copy.educationHistory;
        this.employmentHistory = copy.employmentHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", createAt=" + createAt +
                ", isAdmin=" + isAdmin +
                ", isVerified=" + isVerified +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", alias='" + alias + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", education=" + educationHistory +
                ", employment=" + employmentHistory +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public List<Education> getEducationHistory() {
        return educationHistory;
    }

    public void setEducationHistory(List<Education> education) {
        this.educationHistory = education;
    }

    public List<EmploymentDetail> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<EmploymentDetail> employment) {
        this.employmentHistory = employment;
    }
}
