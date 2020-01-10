package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class BurgerMenuSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public BurgerMenuSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    @Step
    public List<String> getMenuItems() {
        return sportchekMainPage.getHeaderPanel()
                .getBurgerMenuPanel()
                .getMenuItems();
    }
}
