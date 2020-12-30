package com.web.application.e2e.automator.visa.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

@Page
public class HomePage extends BasePage {

    @FindBy(className = "jotform-form")
    private WebElement panel;

    public void goTo(final String url) {
        just(MAXIMIZE_THE_BROWSER);
        just(NAVIGATE_TO, url);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE, panel));
        return verifyWhether(WE_CAN_SEE, panel) && verifyWhether(WE_CAN_CLICK, panel);
    }

    public String getPageTitle() {
        return fetch(PAGE_TITLE);
    }

}