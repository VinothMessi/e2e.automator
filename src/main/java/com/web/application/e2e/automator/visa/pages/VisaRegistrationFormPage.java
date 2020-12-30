package com.web.application.e2e.automator.visa.pages;

import com.web.application.e2e.automator.annotations.Object;
import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import com.web.application.e2e.automator.visa.pagecomponents.BirthDetails;
import com.web.application.e2e.automator.visa.pagecomponents.ContactDetails;
import com.web.application.e2e.automator.visa.pagecomponents.CountryDetails;
import com.web.application.e2e.automator.visa.pagecomponents.UserDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class VisaRegistrationFormPage extends BasePage {

	@Object
	private UserDetails userDetails;

	@Object
	private CountryDetails countryDetails;

	@Object
	private BirthDetails birthDetails;

	@Object
	private ContactDetails contactDetails;

	@FindBy(id = "header_1")
	private WebElement pageHeader;

	@FindBy(id = "subHeader_1")
	private WebElement subHeader;

	@FindBy(id = "input_45")
	private WebElement comments;

	@FindBy(id = "submitBtn")
	private WebElement submitButton;

	@Override
	public boolean hasItLoaded() {
		await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), pageHeader));
		return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), subHeader);
	}

	public String getPageHeader() {
		return fetch(TEXT_FROM, pageHeader);
	}

	public String getPageSubHeader() {
		return fetch(TEXT_FROM, subHeader);
	}

	public void addComments(String comMents) {
		please(TYPE, comMents, comments);
	}

	public void submitForm() {
		just(CLICK_ON, submitButton);
	}

	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public CountryDetails getCountryDetails() {
		return this.countryDetails;
	}

	public BirthDetails getBirthDetails() {
		return this.birthDetails;
	}

	public ContactDetails getContactDetails() {
		return this.contactDetails;
	}

}