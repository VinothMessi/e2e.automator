package com.web.application.e2e.automator.visa.workflow;

import com.web.application.e2e.automator.annotations.Object;
import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.visa.pages.*;

import java.util.function.Consumer;

@Page
public class VisaRegistrationBusinessFlow {

    @Object
    private HomePage homePage;

    @Object
    private VisaRegistrationFormPage visaRegistrationFormPage;

    @Object
    private VisaConfirmationPage visaConfirmationPage;

    public VisaRegistrationBusinessFlow visaHomePage(Consumer<HomePage> c) {
        c.accept(this.homePage);
        return this;
    }

    public VisaRegistrationBusinessFlow visaRegistration(Consumer<VisaRegistrationFormPage> c) {
        c.accept(this.visaRegistrationFormPage);
        return this;
    }

    public VisaRegistrationBusinessFlow visaConfirmation(Consumer<VisaConfirmationPage> c) {
        c.accept(this.visaConfirmationPage);
        return this;
    }

}