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
@Table(name = "employment_details")
public class EmploymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column
    private String employer;

    @Column
    private String streetAddress;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipcode;

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

    public EmploymentDetail(long id, User user, String employer, String streetAddress, String city, String state, String zipcode, Date startDate, Date endDate, String positions, String supervisor, String reasonForLeaving, boolean okToCall, String phoneNumber) {
        this.id = id;
        this.user = user;
        this.employer = employer;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
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
                "employmentId=" + id +
                ", user=" + user +
                ", employer='" + employer + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", positions='" + positions + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", reasonForLeaving='" + reasonForLeaving + '\'' +
                ", okToCall=" + okToCall +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void updateContents(EmploymentDetail updatedEmploymentDetail) {
        this.id = updatedEmploymentDetail.id;
        this.employer = updatedEmploymentDetail.employer;
        this.streetAddress = updatedEmploymentDetail.streetAddress;
        this.city = updatedEmploymentDetail.city;
        this.state = updatedEmploymentDetail.state;
        this.zipcode = updatedEmploymentDetail.zipcode;
        this.startDate = updatedEmploymentDetail.startDate;
        this.endDate = updatedEmploymentDetail.endDate;
        this.positions = updatedEmploymentDetail.positions;
        this.supervisor = updatedEmploymentDetail.supervisor;
        this.reasonForLeaving = updatedEmploymentDetail.reasonForLeaving;
        this.okToCall = updatedEmploymentDetail.okToCall;
        this.phoneNumber = updatedEmploymentDetail.phoneNumber;
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

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
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

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

    public boolean isOkToCall() {
        return okToCall;
    }

    public void setOkToCall(boolean okToCall) {
        this.okToCall = okToCall;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFormattedPhone() {

        String formattedNumber = this.phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        return formattedNumber;
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
