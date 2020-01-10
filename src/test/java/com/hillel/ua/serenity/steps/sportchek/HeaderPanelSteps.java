package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class HeaderPanelSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public HeaderPanelSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    @Step
    public void openBurgerMenu() {
        sportchekMainPage.getHeaderPanel().clickBurgerMenuButton();
    }
}
