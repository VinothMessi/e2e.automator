package com.web.application.e2e.automator.browser.config;

import java.net.MalformedURLException;
import java.net.URL;

import com.web.application.e2e.automator.annotations.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Lazy
@Configuration
@Profile("remote")
public class RemoteDriverConfig {

    @Value("${hub.host}")
    private String hubHost;

    @Value("${hub.port}")
    private String hubPort;

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "chrome")
    public WebDriver remoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://" + this.hubHost + ":" + this.hubPort + "/wd/hub"), DesiredCapabilities.chrome());
    }

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "firefox")
    public WebDriver remoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://" + this.hubHost + ":" + this.hubPort + "/wd/hub"), DesiredCapabilities.firefox());
    }

}