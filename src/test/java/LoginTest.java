import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;


public class LoginTest extends BaseTest{
    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithBtnLoginOnMainPage(){
        userMethods.createUser(user);
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        accessToken = userMethods.loginUser(credential.from(user)).extract().path("accessToken").toString();

    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginWithBtnLoginOnProfilePage(){
        userMethods.createUser(user);
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnProfileOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        accessToken = userMethods.loginUser(credential.from(user)).extract().path("accessToken").toString();

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginWithBtnLoginOnRegistrationPage(){
        userMethods.createUser(user);
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnProfileOnMainPage()
                .clickSignUpBtnOnLoginPage()
                .clickLoginBtnOnRegPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        accessToken = userMethods.loginUser(credential.from(user)).extract().path("accessToken").toString();

    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginWithBtnLoginOnRestorePage(){
        userMethods.createUser(user);
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .clickRestoreBtnOnLoginPage()
                .clickLoginBtn()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        accessToken = userMethods.loginUser(credential.from(user)).extract().path("accessToken").toString();

    }
}
