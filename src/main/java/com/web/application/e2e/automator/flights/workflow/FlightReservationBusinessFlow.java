package com.web.application.e2e.automator.flights.workflow;

import com.web.application.e2e.automator.annotations.Object;
import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.flights.pages.*;

import java.util.function.Consumer;

@Page
public class FlightReservationBusinessFlow {

    @Object
    private FlightHomePage flightBookingForm;

    @Object
    private UserRegistrationFromPage userRegistration;

    @Object
    protected RegistrationConfirmationPage registrationConfirmationPage;

    @Object
    protected FlightDetailsPage flightDetailsPage;

    @Object
    protected SelectFlightPage selectFlightPage;

    @Object
    protected BillingAddressPage billingAddressPage;

    @Object
    protected FlightItineraryPage flightItineraryPage;

    public FlightReservationBusinessFlow homepage(Consumer<FlightHomePage> c) {
        c.accept(this.flightBookingForm);
        return this;
    }

    public FlightReservationBusinessFlow registration(Consumer<UserRegistrationFromPage> c) {
        c.accept(this.userRegistration);
        return this;
    }

    public FlightReservationBusinessFlow confirmation(Consumer<RegistrationConfirmationPage> c) {
        c.accept(this.registrationConfirmationPage);
        return this;
    }

    public FlightReservationBusinessFlow flightdetails(Consumer<FlightDetailsPage> c) {
        c.accept(this.flightDetailsPage);
        return this;
    }

    public FlightReservationBusinessFlow selectflights(Consumer<SelectFlightPage> c) {
        c.accept(this.selectFlightPage);
        return this;
    }

    public FlightReservationBusinessFlow billingaddress(Consumer<BillingAddressPage> c) {
        c.accept(this.billingAddressPage);
        return this;
    }

    public FlightReservationBusinessFlow flightitinerary(Consumer<FlightItineraryPage> c) {
        c.accept(this.flightItineraryPage);
        return this;
    }

}