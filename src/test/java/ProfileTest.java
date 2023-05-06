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
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static driver.WebDriverCreator.createWebDriver;

public class ProfileTest {
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
    @DisplayName("переход по клику на «Личный кабинет»")
    public void checkProfilePage(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnProfileAfterAuthorisation();
        ProfilePage profilePage = new ProfilePage(driver)
                .checkLogoutBtn();
    }

    @Test
    @DisplayName(" переход по клику на «Конструктор»")
    public void checkConstructorBtn(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnProfileAfterAuthorisation();
        MainPage profilePage = new ProfilePage(driver)
                .clickConstructorBtnOnMainPage()
                .checkOrderBtn();
    }

    @Test
    @DisplayName("переход по клику на логотип")
    public void checkLogoBtn(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnProfileAfterAuthorisation();
        MainPage profilePage = new ProfilePage(driver)
                .clickLogoOnMainPage()
                .checkOrderBtn();
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    public void checkLogoutFromProfile(){
        MainPage loginPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .fillTextboxEmailOnLoginPage(email)
                .fillTextboxPasswordOnLoginPage(password)
                .clickLoginButtonOnLoginPage()
                .checkOrderBtn();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnProfileAfterAuthorisation();
        LoginPage profilePage = new ProfilePage(driver)
                .checkLogoutBtn()
                .cliclLogoutBtn()
                .checkHearderOnLoginPage();
    }

    @After
    public void teardown() {
        driver.quit();
        if(accessToken!= null) userMethods.deleteUser(accessToken);
    }
}
