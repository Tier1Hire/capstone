package com.codeup.tier1hire.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long educationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    // Searchable
    @Column
    private String school;

    @Column
    private String degree;

    @Column
    private String streetAddress;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipcode;

    @Column
    private String major;

    @Column
    private Date startDate;

    // display "current" when no value
    @Column
    private Date endDate;

    @Column
    private boolean graduated;

    public Education(long educationId, User user, String school, String degree, String streetAddress, String city, String state, String zipcode, String major, Date startDate, Date endDate, boolean graduated) {
        this.educationId = educationId;
        this.user = user;
        this.school = school;
        this.degree = degree;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.major = major;
        this.startDate = startDate;
        this.endDate = endDate;
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", user=" + user +
                ", school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", major='" + major + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", graduated=" + graduated +
                '}';
    }

    public long getEducationId() {
        return educationId;
    }

    public void setEducationId(long educationId) {
        this.educationId = educationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }
}
