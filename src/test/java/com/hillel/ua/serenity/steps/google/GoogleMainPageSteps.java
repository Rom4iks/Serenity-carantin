package com.hillel.ua.serenity.steps.google;

import com.hillel.ua.page_object.pages.GoogleMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class GoogleMainPageSteps extends ScenarioSteps {

    private GoogleMainPage googleMainPage;

    public GoogleMainPageSteps(final Pages pages) {
        this.googleMainPage = pages.getPage(GoogleMainPage.class);
    }

    @Step
    public String getCurrentTitle() {
        return googleMainPage.getCurrentTitle();
    }

    @Step
    public void openPageByUrl(final String url) {
        googleMainPage.openUrl(url);
    }
}
