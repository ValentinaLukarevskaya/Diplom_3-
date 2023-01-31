package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ConfigSingle;
import config.EndPoints;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage {
    private SelenideElement logInButton = $x("//*[contains(text(), 'Войти')]");

    @Step("Открыть страницу забытого пароля")
    public ForgotPasswordPage openForgotPasswordPage() {
        Selenide.open(ConfigSingle.config.getBaseUriProperties() + EndPoints.FORGOT_PASSWORD_PAGE);

        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public ForgotPasswordPage clickLogInButton() {
        logInButton.click();

        return this;
    }
}
