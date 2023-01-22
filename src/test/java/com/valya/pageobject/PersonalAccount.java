package com.valya.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccount {
    private SelenideElement
            messageOfEditData = $x("//p[text()='В этом разделе вы можете изменить свои персональные данные']"),
            exitButton = $x("//*[contains(text(),'Выход')]");

    @Step("Клик по кнопке 'Выход'")
    public PersonalAccount clickExitButton() {
        exitButton.click();

        return this;
    }

    @Step("Отображение текста 'В этом разделе вы можете изменить свои персональные данные'")
    public PersonalAccount messageOfEditDataAvailable() {
        messageOfEditData.shouldBe(visible);

        return this;
    }
}
