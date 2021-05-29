package com.codeup.tier1hire.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date startDate;

    @Column
    @DateTimeFormat(pattern = "dd/mm/yyyy")
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

    public EmploymentDetail(long employmentId, User user, String employer, String address1, String address2, Date startDate, Date endDate, String positions, String supervisor, String reasonForLeaving, boolean okToCall, String phoneNumber) {
        this.employmentId = employmentId;
        this.user = user;
        this.employer = employer;
        this.address1 = address1;
        this.address2 = address2;
        this.startDate = startDate;
        this.endDate = endDate;
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
                ", employer='" + employer + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", positions='" + positions + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", reasonForLeaving='" + reasonForLeaving + '\'' +
                ", okToCall=" + okToCall +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
