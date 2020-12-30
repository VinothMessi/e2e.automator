package com.web.application.e2e.automator.datajpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flightdetails {

    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private String userName;
    private String password;
    private String confirmPassword;

    private String tripType;
    private String passengers;
    private String departingPlace;
    private String departingMonth;
    private String departingDate;
    private String arrivingPlace;
    private String arrivingMonth;
    private String arrivingDate;
    private String airline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getDepartingPlace() {
        return departingPlace;
    }

    public void setDepartingPlace(String departingPlace) {
        this.departingPlace = departingPlace;
    }

    public String getDepartingMonth() { return departingMonth; }

    public void setDepartingMonth(String departingMonth) {
        this.departingMonth = departingMonth;
    }

    public String getDepartingDate() {
        return departingDate;
    }

    public void setDepartingDate(String departingDate) {
        this.departingDate = departingDate;
    }

    public String getArrivingPlace() {
        return arrivingPlace;
    }

    public void setArrivingPlace(String arrivingPlace) {
        this.arrivingPlace = arrivingPlace;
    }

    public String getArrivingMonth() {
        return arrivingMonth;
    }

    public void setArrivingMonth(String arrivingMonth) {
        this.arrivingMonth = arrivingMonth;
    }

    public String getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(String arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) { this.airline = airline; }

}