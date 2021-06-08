package com.codeup.tier1hire.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public Education(long id, User user, String school, String degree, String streetAddress, String city, String state, String zipcode, String major, Date startDate, Date endDate, boolean graduated) {
        this.id = id;
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
                "id=" + id +
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

    public void updateContents(Education updateEducation) {
        this.id = updateEducation.id;
        this.school = updateEducation.school;
        this.degree = updateEducation.degree;
        this.streetAddress = updateEducation.streetAddress;
        this.city = updateEducation.city;
        this.state = updateEducation.state;
        this.zipcode = updateEducation.zipcode;
        this.major = updateEducation.major;
        this.startDate = updateEducation.startDate;
        this.endDate = updateEducation.endDate;
        this.graduated = updateEducation.graduated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFormattedStartDate() {

        DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(this.startDate);
    }

    public String getFormattedEndDate() {

        DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(this.endDate);
    }
}
