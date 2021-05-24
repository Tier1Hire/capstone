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
@Table(name = "employment_details")
public class EmploymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private String previousEmployment;

    @Column
    private String employer;

    @Column(nullable = false)
    private boolean previousEmployed;

    @Column(nullable = false)
    private String country;

    @Column
    private String region;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private boolean presentlyEmployed;

    @Column(nullable = false)
    private String positions;

    @Column(nullable = false)
    private String supervisor;

    @Column(nullable = false)
    private String reasonForLeaving;

    @Column(nullable = false)
    private boolean okToCall;

    @Column(nullable = false)
    private String phoneNumber;

    public EmploymentDetail(long id, long userId, String previousEmployment, String employer, boolean previousEmployed, String country, String region, String city, Date startDate, Date endDate, boolean presentlyEmployed, String positions, String supervisor, String reasonForLeaving, boolean okToCall, String phoneNumber) {
        this.id = id;
        this.userId = userId;
        this.previousEmployment = previousEmployment;
        this.employer = employer;
        this.previousEmployed = previousEmployed;
        this.country = country;
        this.region = region;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.presentlyEmployed = presentlyEmployed;
        this.positions = positions;
        this.supervisor = supervisor;
        this.reasonForLeaving = reasonForLeaving;
        this.okToCall = okToCall;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "EmploymentDetail{" +
                "id=" + id +
                ", userId=" + userId +
                ", previousEmployment='" + previousEmployment + '\'' +
                ", employer= '" + employer + '\'' +
                ", previousEmployed='" + previousEmployed + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", presentlyEmployed=" + presentlyEmployed +
                ", positions='" + positions + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", reasonForLeaving='" + reasonForLeaving + '\'' +
                ", okToCall=" + okToCall +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
