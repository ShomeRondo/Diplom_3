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
import pages.RegistrationPage;

import static driver.WebDriverCreator.createWebDriver;

public class RegistrationTest {
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
        userMethods = new UserMethods();
        user = new User(name, email, password);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationUser(){
    MainPage registrationPage = new MainPage(driver)
            .mainPageOpen()
            .clickBtnLoginOnMainPage()
            .clickSignUpBtnOnLoginPage()
            .fillTextBoxNameOnRegPage(name)
            .fillTextboxEmailOnRegPage(email)
            .fillTextboxPasswordOnRegPage(password)
            .clickBtnSignINOnRegPage()
            .checkHearderOnLoginPage()
            .fillTextboxEmailOnLoginPage(email)
            .fillTextboxPasswordOnLoginPage(password)
            .clickLoginButtonOnLoginPage();
        accessToken = userMethods.loginUser(credential.from(user)).extract().path("accessToken").toString();

    }

    @Test
    @DisplayName("Ошибка при регистрации, если пароль короче 6 символов")
    public void checkErrorForRegistrationWhithShortPassword(){
        password = "1";
        RegistrationPage registrationPage = new MainPage(driver)
                .mainPageOpen()
                .clickBtnLoginOnMainPage()
                .clickSignUpBtnOnLoginPage()
                .fillTextBoxNameOnRegPage(name)
                .fillTextboxEmailOnRegPage(email)
                .fillTextboxPasswordOnRegPage(password)
                .clickTextboxNameOnRegPage()
                .checkErrorMessageOnRegPage();
    }

    @After
    public void teardown() {
        driver.quit();
        if(accessToken!= null) userMethods.deleteUser(accessToken);
    }

}
