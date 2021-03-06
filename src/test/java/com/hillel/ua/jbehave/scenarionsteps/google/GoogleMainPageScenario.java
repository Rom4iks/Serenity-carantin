package com.hillel.ua.jbehave.scenarionsteps.google;

import com.hillel.ua.serenity.steps.google.GoogleMainPageSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class GoogleMainPageScenario {

    @Steps
    private GoogleMainPageSteps googleMainPageSteps;

    @Given("user opened following url: '$url'")
    public void openGoogleMainPage(final String url) {
        googleMainPageSteps.openPageByUrl(url);
    }

    @When("user retrieved site title")
    public void retrieveSiteTitle() {
        final String actualTitle = googleMainPageSteps.getCurrentTitle();
        Serenity.setSessionVariable("actual_title").to(actualTitle);
    }

    @Then("retrieved title value should be: '$expectedTitle'")
    public void verifySiteTitle(final String expectedTitle) {
        final String savedTitle = Serenity.sessionVariableCalled("actual_title");
        Assert.assertEquals("There is incorrect title displayed!", expectedTitle, savedTitle);
    }
}
