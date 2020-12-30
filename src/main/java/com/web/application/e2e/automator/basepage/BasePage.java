package com.web.application.e2e.automator.basepage;

import com.web.application.e2e.automator.operations.BrowserOperations;
import com.web.application.e2e.automator.operations.ElementValidator;
import com.web.application.e2e.automator.operations.WebElementOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class BasePage implements BrowserOperations, WebElementOperations, ElementValidator {

    @Autowired
    protected WebDriver browser;

    @PostConstruct
    private void init() {
        PageFactory.initElements(browser, this);
    }

    public abstract boolean hasItLoaded();

    protected void just(Consumer<WebDriver> c) {
        c.accept(browser);
    }

    protected void just(BiConsumer<WebDriver, String> c, String s) {
        c.accept(browser, s);
    }

    protected String fetch(Function<WebElement, String> f, WebElement ele) {
        return f.apply(ele);
    }

    protected String fetch(Function<WebDriver, String> f) {
        return f.apply(browser);
    }

    protected void just(Consumer<WebElement> c, WebElement ele) {
        c.accept(ele);
    }

    protected void please(BiConsumer<WebElement, String> c, String s, WebElement ele) {
        c.accept(ele, s);
    }

    protected boolean verifyWhether(Predicate<WebElement> p, WebElement ele) {
        return p.test(ele);
    }

}