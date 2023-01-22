package com.valya.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.valya.config.ConfigSingle.config;
import static com.valya.config.EndPoints.REGISTER;

public class RegistrationPage {

    private SelenideElement
            nameField = $x("//fieldset[1]//input"),
            emailField = $x("//fieldset[2]//input"),
            passwordField = $x("//fieldset[3]//input"),
            registrationButton = $x("//button[contains(text(),'Зарегистрироваться')]"),
            logInButton = $x("//*[contains(text(),'Войти')]");
    public SelenideElement errorMessageOfPassword = $x("//*[contains(text(),'Некорректный пароль')]");

    @Step("Открыть страницу регистрации")
    public RegistrationPage openRegistrationPage() {
        Selenide.open(config.getBaseUriProperties() + REGISTER);

        return this;
    }

    @Step("Ввод значения в поле 'Имя'")
    public RegistrationPage setNameField(String name) {
        nameField.setValue(name);

        return this;
    }

    @Step("Ввод значения в поле 'Email'")
    public RegistrationPage setEmailField(String email) {
        emailField.setValue(email);

        return this;
    }

    @Step("Ввод значения в поле 'Пароль'")
    public RegistrationPage setPasswordField(String password) {
        passwordField.setValue(password);

        return this;
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public RegistrationPage clickLogInButton() {
        logInButton.click();

        return this;
    }
}
