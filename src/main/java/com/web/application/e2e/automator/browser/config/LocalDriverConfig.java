package com.web.application.e2e.automator.browser.config;

import com.web.application.e2e.automator.annotations.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("local")
public class LocalDriverConfig {

	@Value("${chrome.version}")
	private String chVersion;

	@Value("${firefox.version}")
	private String ffVersion;

	@Value("${edge.version}")
	private String edgeVersion;

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "chrome")
	public WebDriver chrome() {
		WebDriverManager.chromedriver().browserVersion(this.chVersion).setup();
		return new ChromeDriver();
	}

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "firefox")
	public WebDriver firefox() {
		WebDriverManager.firefoxdriver().browserVersion(this.ffVersion).setup();
		return new FirefoxDriver();
	}

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "edge")
	public WebDriver edge() {
		WebDriverManager.edgedriver().browserVersion(this.edgeVersion).setup();
		return new EdgeDriver();
	}

}