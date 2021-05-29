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

    // # and street name
    @Column
    private String address1;

    // city, state, zip
    @Column
    private String address2;

    @Column
    private String major;

    @Column
    private Date startDate;

    // display "current" when no value
    @Column
    private Date endDate;

    @Column
    private boolean graduated;

    public Education(long educationId, User user, String school, String degree, String address1, String address2, String major, Date startDate, Date endDate, boolean graduated) {
        this.educationId = educationId;
        this.user = user;
        this.school = school;
        this.degree = degree;
        this.address1 = address1;
        this.address2 = address2;
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
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
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
