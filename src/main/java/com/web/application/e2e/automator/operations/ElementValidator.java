package com.web.application.e2e.automator.operations;

import org.openqa.selenium.WebElement;

import java.util.function.Predicate;

public interface ElementValidator {
    Predicate<WebElement> WE_CAN_SEE = WebElement::isDisplayed;
    Predicate<WebElement> WE_CAN_CLICK = WebElement::isEnabled;
    Predicate<WebElement> WE_CAN_SELECT = WebElement::isSelected;
}