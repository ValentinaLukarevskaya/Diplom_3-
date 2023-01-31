package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ConfigSingle;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement
            loginInAccountButton = $x("//button[contains(text(),'Войти в аккаунт')]"),
            personalAccountButton = $x("//*[contains(text(),'Личный Кабинет')]"),
            logoOfStellarButton = $x("//nav/div/a[@href='/']"),
            constructorButton = $x("//*[contains(text(),'Конструктор')]"),
            bunsButton = $x("//span[contains(text(),'Булки')]"),
            saucesButton = $x("//span[contains(text(),'Соусы')]"),
            fillingsButton = $x("//span[contains(text(),'Начинки')]"),
            placeOrderButton = $x("//button[contains(text(),'Оформить заказ')]"),
            logoOfBunsButton = $x("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']"),
            logoOfSaucesButton = $x("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']"),
            logoOfFillingsButton = $x("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        Selenide.open(ConfigSingle.config.getBaseUriProperties());

        return this;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public MainPage clickLoginInAccountButton() {
        loginInAccountButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Личный Кабинет'")
    public MainPage clickPersonalAccountButton() {
        personalAccountButton.click();

        return this;
    }

    @Step("Клик на логотип 'Stellar Burgers'")
    public MainPage clickLogoOfStellarButton() {
        logoOfStellarButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickConstructorButton() {
        constructorButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Булки'")
    public MainPage clickBunsButton() {
        bunsButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Соусы'")
    public MainPage clickSaucesButton() {
        saucesButton.click();

        return this;
    }

    @Step("Клик по кнопке 'Начинки'")
    public MainPage clickFillingsButton() {
        fillingsButton.click();

        return this;
    }

    @Step("Отображение кнопки 'Оформить заказ'")
    public MainPage placeOrderButtonAvailable() {
        placeOrderButton.shouldBe(visible);

        return this;
    }

    @Step("Отображение лого 'Булки'")
    public MainPage logoOfBunsButtonVisible() {
        logoOfBunsButton.shouldBe(visible);

        return this;
    }

    @Step("Отображение лого 'Соусы'")
    public MainPage logoOfSaucesButtonVisible() {
        logoOfSaucesButton.shouldBe(visible);

        return this;
    }

    @Step("Отображение лого 'Начинки'")
    public MainPage logoOfFillingsButtonVisible() {
        logoOfFillingsButton.shouldBe(visible);

        return this;
    }
}
