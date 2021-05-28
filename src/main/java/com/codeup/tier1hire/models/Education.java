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

    public Education(long educationId, User user, String school, String degree, String country, String region, String city, String major, Date startDate, Date endDate, Date graduated, Date graduationDate, boolean presentlyEnrolled) {
        this.educationId = educationId;
        this.user = user;
        this.school = school;
        this.degree = degree;
        this.country = country;
        this.region = region;
        this.city = city;
        this.major = major;
        this.startDate = startDate;
        this.endDate = endDate;
        this.graduated = graduated;
        this.graduationDate = graduationDate;
        this.presentlyEnrolled = presentlyEnrolled;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", user=" + user +
                ", school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", major='" + major + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", graduated=" + graduated +
                ", graduationDate=" + graduationDate +
                ", presentlyEnrolled=" + presentlyEnrolled +
                '}';
    }
}
