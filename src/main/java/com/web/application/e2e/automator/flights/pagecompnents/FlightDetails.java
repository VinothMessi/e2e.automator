package com.web.application.e2e.automator.flights.pagecompnents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class FlightDetails extends BasePage {

    @FindBy(xpath = "//b[text()='Type:']//parent::font/parent::td/following-sibling::td//font")
    private List<WebElement> tripTypes;

    @FindBy(xpath = "//input[@value='roundtrip']")
    private WebElement roundtrip;

    @FindBy(xpath = "//input[@value='oneway']")
    private WebElement oneway;

    @FindBy(name = "passCount")
    private WebElement passengers;

    @FindBy(name = "fromPort")
    private WebElement departingFrom;

    @FindBy(name = "fromMonth")
    private WebElement departingFromMonth;

    @FindBy(name = "fromDay")
    private WebElement departingFromDay;

    @FindBy(name = "toPort")
    private WebElement arrivingIn;

    @FindBy(name = "toMonth")
    private WebElement arrivingInMonth;

    @FindBy(name = "toDay")
    private WebElement arrivingInDay;

    public void chooseTripType(String tripType) {
        tripTypes.stream()
                .forEach(e -> e.findElement(By.xpath("//input[@value='" + tripType + "']")).click());
    }

    public void selectNoOfPassengers(String nOfPassengers) {
        please(SELECT_THE_VALUE, nOfPassengers, this.passengers);
    }

    public void departingDetails(String place, String month, String date) {
        please(SELECT_THE_VALUE, place, this.departingFrom);
        please(SELECT_THE_VALUE, month, this.departingFromMonth);
        please(SELECT_THE_VALUE, date, this.departingFromDay);
    }

    public void arrivingDetails(String place, String month, String date) {
        please(SELECT_THE_VALUE, place, this.arrivingIn);
        please(SELECT_THE_VALUE, month, this.arrivingInMonth);
        please(SELECT_THE_VALUE, date, this.arrivingInDay);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.roundtrip) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.oneway) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.passengers) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.departingFrom) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.departingFromMonth) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.departingFromDay) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.arrivingIn) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.arrivingInMonth) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.arrivingInDay);
    }

}