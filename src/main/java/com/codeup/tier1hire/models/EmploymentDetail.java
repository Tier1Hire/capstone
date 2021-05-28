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
@Table(name = "employment_details")
public class EmploymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employmentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column
    private String employer;

    // # and street name
    @Column
    private String address1;

    // city, state, zip
    @Column
    private String address2;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String positions;

    @Column
    private String supervisor;

    @Column
    private String reasonForLeaving;

    @Column
    private boolean okToCall;

    @Column
    private String phoneNumber;

    public EmploymentDetail(long employmentId, User user, String previousEmployment, String employer, boolean previousEmployed, String country, String region, String city, Date startDate, Date endDate, boolean presentlyEmployed, String positions, String supervisor, String reasonForLeaving, boolean okToCall, String phoneNumber) {
        this.employmentId = employmentId;
        this.user = user;
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
                "employmentId=" + employmentId +
                ", user=" + user +
                ", previousEmployment='" + previousEmployment + '\'' +
                ", employer='" + employer + '\'' +
                ", previousEmployed=" + previousEmployed +
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
