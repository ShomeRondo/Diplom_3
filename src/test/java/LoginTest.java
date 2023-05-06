import config.BaseURI;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.User;
import model.UserCredential;
import model.UserMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static driver.WebDriverCreator.createWebDriver;

public class LoginTest {
    private WebDriver driver;
    private User user;
    private UserMethods userMethods;
    private UserCredential credential;
    private String accessToken;

    private String name ="Джорно";
    private String email = "jjovanno@yandex.ru";
    private String password = "123test";

    @Before
    public void setup() {
        driver = createWebDriver();
        RestAssured.baseURI = BaseURI.baseURI;
        user = new User(name, email, password);
        userMethods = new UserMethods();
        accessToken = userMethods.createUser(user).extract().path("accessToken").toString();
    }


    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithBtnLoginOnMainPage(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginWithBtnLoginOnProfilePage(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnProfileOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginWithBtnLoginOnRegistrationPage(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnProfileOnMainPage()
                .clickSignUpBtnOnLoginPage()
                .clickLoginBtnOnRegPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginWithBtnLoginOnRestorePage(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .clickRestoreBtnOnLoginPage()
                .clickLoginBtn()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
    }


    @After
    public void teardown() {
        driver.quit();
        if(accessToken!= null) userMethods.deleteUser(accessToken);
    }
}
