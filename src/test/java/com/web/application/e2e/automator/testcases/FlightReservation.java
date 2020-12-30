package com.web.application.e2e.automator.testcases;

import com.google.common.util.concurrent.Uninterruptibles;
import com.web.application.e2e.automator.ApplicationTests;
import com.web.application.e2e.automator.datajpa.entity.Flightdetails;

import io.testproject.sdk.drivers.ReportingDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class FlightReservation extends ApplicationTests {

    @Test(dataProvider = "FlightReservation")
    public void flightReservation(Flightdetails fd) {
        ReservationBusinessFlow.homepage(p -> {
            p.goTo(appUrl1);
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Navigate To Flight Application", "Navigated to Flight Application Successfully", true);
            System.out.println("Page Title: " + p.getPageHeader());
            ((ReportingDriver) browser).report().step("Page Header", "Grabbed Page Header Successfully", true);
            p.startRegistration();
        }).registration(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Open Registration Page", "Registration Page Opened Successfully", true);
            System.out.println("Page Header: " + p.getPageHeader());
            System.out.println("Page Description: " + p.getPageDescription());
            p.getContactInformation().hasItLoaded();
            p.getContactInformation().fillContactInformations(fd.getFirstName(), fd.getLastName(), fd.getPhone(), fd.getEmail());
            ((ReportingDriver) browser).report().step("Contact Informations", "Contact Informations Filled Successfully", true);
            p.getMailingInformation().hasItLoaded();
            p.getMailingInformation().fillMailingInformations(fd.getAddress(), fd.getCity(), fd.getState(), fd.getPostalCode(),
                    fd.getCountry());
            ((ReportingDriver) browser).report().step("Mailing Informations", "Mailing Informations Filled Successfully", true);
            p.getUserInformation().hasItLoaded();
            p.getUserInformation().fillUserInformations(fd.getUserName(), fd.getPassword(), fd.getConfirmPassword());
            ((ReportingDriver) browser).report().step("User Informations", "User Informations Filled Successfully", true);
            p.goToRegistrationConfirmationPage();
        }).confirmation(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Open Registration Confirmation Page", "Registration Confirmation Page Opened Successfully", true);
            System.out.println(p.getPageHeader());
            p.goToFlightDetailsPage();
        }).flightdetails(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Open Flight Details Page", "Flight Details Page Opened Successfully", true);
            System.out.println("Page Header: " + p.getPageHeader());
            System.out.println("Page Description: " + p.getPageDescription());
            p.getFlightDetails().hasItLoaded();
            p.getFlightDetails().chooseTripType(fd.getTripType());
            p.getFlightDetails().selectNoOfPassengers(fd.getPassengers());
            p.getFlightDetails().departingDetails(fd.getDepartingPlace(), fd.getDepartingMonth(), fd.getArrivingDate());
            p.getFlightDetails().arrivingDetails(fd.getArrivingPlace(), fd.getArrivingMonth(), fd.getArrivingDate());
            p.getPreferences().selectAirline(fd.getAirline());
            ((ReportingDriver) browser).report().step("Flight Details Page", "Flight Details Filled Successfully", true);
            p.goToSelectFlightsPage();
        }).selectflights(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Select Class", "Choosing Flight Service Class", true);
            p.goToBillingAddressPage();
        }).billingaddress(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            p.fillInBillingAddress(fd.getAddress(), fd.getAddress(), fd.getCity(), fd.getState(), fd.getPostalCode());
            ((ReportingDriver) browser).report().step("Billing Address", "Filling in Billing Address Details", true);
            p.goToItineraryPage();
        }).flightitinerary(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Flight Itinerary", "Flight Itinerary Confirmation", true);
            p.getConfirmationMessages();
            //p.shutDown();
        });
    }

    @DataProvider(name = "FlightReservation")
    public java.lang.Object[] getContactInformations() {
        return flightdetailsRepository.findAll().stream().collect(Collectors.toList()).toArray();
    }
    
    @AfterMethod
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        ((ReportingDriver) browser).report().test("Flight Reservation Business Flow", true).submit();
    }

}