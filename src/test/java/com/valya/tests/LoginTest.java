package com.valya.tests;

import com.valya.utils.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Вход")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке «Войти» в аккаунт» на главной")
    @Description("ОР: Перенаправление на главную страницу")
    public void loginFromMainPage() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет»")
    @Description("ОР: Перенаправление на главную страницу")
    public void loginFromPersonalAccount() {
        mainPage
                .openMainPage()
                .clickLoginInAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти» в форме регистрации»")
    @Description("ОР: Перенаправление на главную страницу")
    public void logInFromRegistrationPage() {
        registrationPage
                .openRegistrationPage()
                .clickLogInButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти» в форме регистрации в форме восстановления пароля перенаправляет на главную страницу")
    @Description("ОР: Перенаправление на главную страницу")
    public void logInFromForgotPasswordPage() {
        forgotPasswordPage
                .openForgotPasswordPage()
                .clickLogInButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.placeOrderButtonAvailable();
    }
}