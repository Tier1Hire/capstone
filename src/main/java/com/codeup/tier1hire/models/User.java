package com.codeup.tier1hire.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//import javax.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private Date createAt;

    @Column
    private boolean isHr;

    @Column
    private String company;

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

    @Column
    private String countryCode;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String region;

    @Column(columnDefinition = "varchar(100) default 'N/A'")
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonManagedReference
    private List<Education> education;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonManagedReference
    private List<EmploymentDetail> employment;



    public User(User copy) {
        this.userId = copy.userId; // This line is SUPER important! Many things won't work if it's absent
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.dateOfBirth = copy.dateOfBirth;
        this.phoneNumber = copy.phoneNumber;
        this.alias = copy.alias;
        this.countryCode = copy.countryCode;
        this.address = copy.address;
        this.city = copy.city;
        this.region = copy.region;
        this.postalCode = copy.postalCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", createAt=" + createAt +
                ", isHr=" + isHr +
                ", company='" + company + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", alias='" + alias + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean getIsHr() {
        return isHr;
    }

    public void setHr(boolean hr) {
        isHr = hr;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
