package com.web.application.e2e.automator.testcases;

import com.google.common.util.concurrent.Uninterruptibles;
import com.web.application.e2e.automator.ApplicationTests;
import com.web.application.e2e.automator.datajpa.entity.User;

import io.testproject.sdk.drivers.ReportingDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class VisaRegistration extends ApplicationTests {

    @Test(dataProvider = "VisaRegistration")
    public void visaRegistration(User fd) {
        this.visaRegistrationBusinessFlow.visaHomePage(p -> {
            p.goTo(appUrl2);
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Navigate To Visa Application", "Navigated to Visa Application Successfully", true);
            System.out.println("Page Title :" + p.getPageTitle());
        }).visaRegistration(p -> {
            p.hasItLoaded();
            ((ReportingDriver) browser).report().step("Visa Registration", "Visa Registration Page Opened Successfully", true);
            System.out.println("Page Header :" + p.getPageHeader());
            System.out.println("Page Sub Header :" + p.getPageSubHeader());
            p.getUserDetails().fillUserDetails(fd.getFirstName(), fd.getLastName());
            p.getCountryDetails().fillCountryDetails(fd.getFromCountry(), fd.getToCountry());
            p.getBirthDetails().fillBirthDetails(fd.getMonth(), fd.getDay(), fd.getYear());
            p.getContactDetails().fillContactDetails(fd.getEmail(), fd.getAreaCode(),
                    fd.getPhone());
            p.addComments(fd.getComments());
            p.submitForm();
            ((ReportingDriver) browser).report().step("Form Submission", "Visa Form Submission Done Successfully", true);
        }).visaConfirmation(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            ((ReportingDriver) browser).report().step("Visa Confirmation", "Visa Confirmation Page Opened Successfully", true);
            System.out.println("Confirmation Message :" + p.getConfirmationMessage());
            System.out.println("Request Number :" + p.getRequestNumber());
        });
    }

    @DataProvider(name = "VisaRegistration")
    public java.lang.Object[] getContactInformations() {
        return this.userRepository.findAll().stream().collect(Collectors.toList()).toArray();
    }
    
    @AfterMethod
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        ((ReportingDriver) browser).report().test("Visa Registration Business Flow", true).submit();
    }

}