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
}
