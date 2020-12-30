package com.web.application.e2e.automator.browser.config;

import com.web.application.e2e.automator.annotations.Browser;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
@Profile("opensdk")
public class TestProjectDriver {

	@Value("${dev.token}")
	private String devToken;

	@Value("${agent.url}")
	private String agentUrl;

	@Value("${project.name}")
	private String projectName;

	@Value("${job.name}")
	private String jobName;

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "chrome")
	public WebDriver chrome() throws MalformedURLException {
		return new DriverBuilder<RemoteWebDriver>(new ChromeOptions()).withToken(this.devToken)
				.withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
				.build(RemoteWebDriver.class);
	}

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "firefox")
	public WebDriver firefox() throws MalformedURLException {
		return new DriverBuilder<RemoteWebDriver>(new FirefoxOptions()).withToken(this.devToken)
				.withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
				.build(RemoteWebDriver.class);
	}

	@Browser
	@ConditionalOnProperty(name = "browser.name", havingValue = "edge")
	public WebDriver edge() throws MalformedURLException {
		return new DriverBuilder<RemoteWebDriver>(new EdgeOptions()).withToken(this.devToken)
				.withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
				.build(RemoteWebDriver.class);
	}

}