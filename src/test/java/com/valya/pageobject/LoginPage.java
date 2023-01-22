package com.valya.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement
            emailField = $("input[name='name']"),
            passwordField = $("input[name='Пароль']"),
            logInButton = $x("//*[contains(text(),'Войти')]"),
            logInLabel = $x("//*[contains(text(),'Вход')]");

    @Step("Ввод значения в поле 'Email'")
    public LoginPage setEmailField(String email) {
        emailField.setValue(email);

        return this;
    }

    @Step("Ввод значения в поле 'Пароль'")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);

        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickLogInButton() {
        logInButton.click();

        return this;
    }

    @Step("Логин пользователя")
    public LoginPage loginUser(String email, String password){
        setEmailField(email);
        setPasswordField(password);
        clickLogInButton();

        return this;
    }

    @Step("Отображение лого 'Вход'")
    public LoginPage logInLabelIsVisible() {
        logInLabel.shouldBe(visible);

        return this;
    }
}
