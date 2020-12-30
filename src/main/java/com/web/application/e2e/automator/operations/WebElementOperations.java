package com.web.application.e2e.automator.operations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.function.*;

public interface WebElementOperations {
    Consumer<WebElement> CLICK_ON = WebElement::click;
    Consumer<WebElement> CLEAR_OUT = WebElement::clear;
    Consumer<WebElement> SUBMIT = WebElement::submit;

    Function<WebElement, String> TEXT_FROM = WebElement::getText;
    Function<WebElement, String> TAGE_NAME_FROM = WebElement::getTagName;
    Function<WebElement, Select> DROP_DOWN = (ele) -> new Select(ele);

    BiFunction<WebElement, String, String> FETCH_VALUE_OF = WebElement::getAttribute;

    BiConsumer<WebElement, String> TYPE = WebElement::sendKeys;
    BiConsumer<WebElement, String> SELECT_THE_TEXT = (ele, s) -> DROP_DOWN.apply(ele).selectByVisibleText(s);
    BiConsumer<WebElement, String> SELECT_THE_VALUE = (ele, s) -> DROP_DOWN.apply(ele).selectByValue(s);
    BiConsumer<WebElement, String> SELECT_THE_INDEX = (ele, s) -> DROP_DOWN.apply(ele).selectByIndex(Integer.parseInt(s));
}