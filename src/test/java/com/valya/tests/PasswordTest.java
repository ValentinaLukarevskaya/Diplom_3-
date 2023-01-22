package com.valya.tests;

import com.codeborne.selenide.Condition;
import com.valya.utils.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.valya.pageobject.RegistrationPage.*;

@DisplayName("Тестирование некорректного пароля")
@RunWith(Parameterized.class)
public class PasswordTest extends BaseTest {
    private final String pass;
    private final boolean expected;

    public PasswordTest(String pass, boolean expected) {
        this.pass = pass;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверяемый пароль: {0}, отображение ошибки: {1}")
    public static Object[][] testPassword() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(0), false},
                {RandomStringUtils.randomAlphabetic(1), true},
                {RandomStringUtils.randomAlphabetic(5), true},
                {RandomStringUtils.randomAlphabetic(6), false}};
    }

    @Test
    @DisplayName("Тестирование поля 'Пароль'")
    @Description("При регистрации с коротким паролем, выводится сообщение 'Некорректный пароль'")
    public void registrationWithShortPasswordTest() {
        registrationPage
                .openRegistrationPage()
                .setNameField(user.getName())
                .setEmailField(user.getEmail())
                .setPasswordField(pass)
                .clickRegistrationButton();

        Boolean actual = registrationPage.errorMessageOfPassword.exists();
        Assert.assertEquals(expected, actual);
    }
}

