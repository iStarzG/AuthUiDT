package pages;

import com.codeborne.selenide.SelenideElement;
import config.AuthConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PagesDT {
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    private SelenideElement
            loginButton = $(".btn-solid"),
            emailInput = $(byName("email")),
            passwordInput = $(byName("password")),
            acceptLoginButton = $(".btn-primary:nth-child(1)"),
            profileIcon = $(".inset-0");


    @Step("Открытие браузера на главной странице DT")
    public PagesDT openPage() {
        open("https://dropstab.com/");
        return this;
    }

    @Step("Нажатие на кнопку Login на главной странице")
    public PagesDT clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Ввод email в поле ввода Email")
    public PagesDT setEmail() {
        emailInput.setValue(authConfig.userEmail());
        return this;
    }

    @Step("Ввод пароля в поле ввода Password")
    public PagesDT setPassword() {
        passwordInput.setValue(authConfig.userPassword());
        return this;
    }

    @Step("Нажатие на кнопку Login в модальном окне авторизации")
    public PagesDT acceptLoginButtonClick() {
        acceptLoginButton.click();
        return this;
    }

    @Step("Проверка наличия иконки профиля на главной странице после авторизации")
    public PagesDT checkSuccessfulLogin() {
        profileIcon.should(appear);
        return this;
    }

    @Step("Проверка отсутствия иконки профиля на главной странице после авторизации")
    public PagesDT checkIconAbsent() {
        profileIcon.shouldNot(exist);
        return this;
    }
}
