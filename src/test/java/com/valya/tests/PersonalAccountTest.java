package com.valya.tests;

import com.valya.utils.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static config.ConfigSingle.config;
import static config.EndPoints.USER_ACCOUNT_PAGE;

@DisplayName("Переход по клику на «Личный кабинет»/Переход из личного кабинета в конструктор/Выход из аккаунта")
public class PersonalAccountTest extends BaseTest {
    @Test
    @DisplayName("Переход в «Личный кабинет» с авторизацией")
    public void transitionToThePersonalAccountWithAuthorization() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        webdriver().shouldHave(url(config.getBaseUriProperties() + USER_ACCOUNT_PAGE));
        personalAccount.messageOfEditDataAvailable();
    }

    @Test
    @DisplayName("Переход в «Личный кабинет» без авторизации")
    public void transitionToThePersonalAccountWithoutAuthorization() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.logInLabelIsVisible();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу, при клике на конструктор")
    public void transitionToTheMainPageWhenClickOnTheConstructor() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalAccountButton()
                .clickConstructorButton()
                .placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу, при клике на Stellar Burger")
    public void transitionToTheMainPageWhenClickOnTheStellarBurger() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalAccountButton()
                .clickLogoOfStellarButton()
                .placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void exitFromPersonalAccount() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        personalAccount.clickExitButton();
        loginPage.logInLabelIsVisible();
    }
}
