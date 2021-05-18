package com.codeup.tier1hire.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long userId;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Date graduated;

    @Column(nullable = false)
    private Date graduationDate;

    @Column(nullable = false)
    private Date presentlyEnrolled;

    public Education(long id, long userId, String school, String degree, String country, String region, String city, String major, Date startDate, Date endDate, Date graduated, Date graduationDate, Date presentlyEnrolled) {
        this.id = id;
        this.userId = userId;
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
                "id=" + id +
                ", userId=" + userId +
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
