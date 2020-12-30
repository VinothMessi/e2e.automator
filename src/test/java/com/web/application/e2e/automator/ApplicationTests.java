package com.web.application.e2e.automator;

import com.web.application.e2e.automator.annotations.Object;
import com.web.application.e2e.automator.datajpa.repository.FlightdetailsRepository;
import com.web.application.e2e.automator.datajpa.repository.UserRepository;
import com.web.application.e2e.automator.flights.workflow.FlightReservationBusinessFlow;
import com.web.application.e2e.automator.visa.workflow.VisaRegistrationBusinessFlow;
import io.testproject.sdk.drivers.ReportingDriver;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

@SpringBootTest
public class ApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver browser;

    @Value("${app.url1}")
    protected String appUrl1;

    @Value("${app.url2}")
    protected String appUrl2;

    @Object
    protected FlightReservationBusinessFlow ReservationBusinessFlow;

    @Object
    protected VisaRegistrationBusinessFlow visaRegistrationBusinessFlow;

    @Object
    protected FlightdetailsRepository flightdetailsRepository;

    @Object
    protected UserRepository userRepository;

    @BeforeMethod
    public void setUp() {
        ((ReportingDriver) browser).report().disableTestAutoReports(true);
        //((ReportingDriver) browser).report().disableCommandReports(true);
    }

}