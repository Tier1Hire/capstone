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
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

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

    public Education(long id, User user, String school, String degree, String country, String region, String city, String major, Date startDate, Date endDate, Date graduated, Date graduationDate, Date presentlyEnrolled) {
        this.id = id;
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
                "id=" + id +
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
