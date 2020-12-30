package com.web.application.e2e.automator.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface BrowserOperations {
    Consumer<WebDriver> MAXIMIZE_THE_BROWSER = d -> d.manage().window().maximize();
    Consumer<WebDriver> CLOSE_CURRENT_BROWSER = WebDriver::close;
    Consumer<WebDriver> CLOSE_ALL_BROWSERS = WebDriver::quit;

    BiConsumer<WebDriver, String> NAVIGATE_TO = WebDriver::get;

    Function<WebDriver, String> PAGE_TITLE = WebDriver::getTitle;
    Function<WebDriver, String> CURRENT_URL = WebDriver::getCurrentUrl;
    Function<WebDriver, String> PAGE_SOURCE = WebDriver::getPageSource;

    BiFunction<WebDriver, By, WebElement> IDENTIFY = WebDriver::findElement;
}