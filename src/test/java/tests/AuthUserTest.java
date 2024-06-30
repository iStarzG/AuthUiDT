package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PagesDT;


public class AuthUserTest extends TestBase {
    PagesDT pages = new PagesDT();


    @Test
    @Owner("iStarzG")
    @DisplayName("Успешная авторизация пользователя с помощью модального окна Login")
    void successfulUserAuthorizationLoginModal() {
        pages.openPage()
                .clickLoginButton()
                .setEmail()
                .setPassword()
                .acceptLoginButtonClick()
                .checkSuccessfulLogin();
    }

    @Test
    @Owner("iStarzG")
    @DisplayName("Проверка отсутствия иконки профиля на главной странице с неавторизованным пользователем")
    void verifyProfileIconForUnauthorizedUser() {
        pages.openPage()
                .checkIconAbsent();
    }
}
