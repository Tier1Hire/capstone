package com.codeup.tier1hire.models;


import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
//import javax.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private boolean isHr;

    @Column(nullable = false)
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

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String postalCode;

    public User(long id, Date createAt, boolean isHr, String company, String username, String password, String firstName, String lastName, String email, Date dateOfBirth, String phoneNumber, String alias, String countryCode, String address, String city, String region, String postalCode) {
        this.id = id;
        this.createAt = createAt;
        this.isHr = isHr;
        this.company = company;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.alias = alias;
        this.countryCode = countryCode;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
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
}
