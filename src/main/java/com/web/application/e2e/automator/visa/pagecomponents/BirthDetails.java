package com.web.application.e2e.automator.visa.pagecomponents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class BirthDetails extends BasePage {

    @FindBy(id = "input_24_month")
    private WebElement birthDateMonth;

    @FindBy(id = "input_24_day")
    private WebElement birthDateDay;

    @FindBy(id = "input_24_year")
    private WebElement birthDateYear;

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), birthDateMonth);
    }

    public void fillBirthDetails(String bMon, String bDay, String bYear) {
        please(SELECT_THE_VALUE, bMon, birthDateMonth);
        please(SELECT_THE_VALUE, bDay, birthDateDay);
        please(SELECT_THE_VALUE, bYear, birthDateYear);
    }

}