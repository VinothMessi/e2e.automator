package com.web.application.e2e.automator.flights.pagecompnents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class Preferences extends BasePage {

    @FindBy(xpath = "//b[contains(text(),'Service')]//parent::font/parent::td/following-sibling::td")
    private List<WebElement> serviceClasses;

    @FindBy(xpath = "//input[@value='Coach']")
    private WebElement economyClass;

    @FindBy(xpath = "//input[@value='Business']")
    private WebElement businessClass;

    @FindBy(xpath = "//input[@value='First']")
    private WebElement firstClass;

    @FindBy(name = "airline")
    private WebElement airline;

    public void chooseServiceClass(String serviceClass) {
        serviceClasses.stream()
                .forEach(e -> e.findElement(By.xpath("//input[@value='" + serviceClass + "']")).click());
    }

    public void selectAirline(String airLine) {
        please(SELECT_THE_TEXT, airLine, this.airline);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.economyClass) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.businessClass) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.firstClass) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.airline);
    }

}