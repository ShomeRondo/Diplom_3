import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;


public class ProfileTest extends BaseTest{

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    public void checkProfilePage(){
        accessToken = userMethods.createUser(user).extract().path("accessToken").toString();
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
        accessToken = userMethods.createUser(user).extract().path("accessToken").toString();
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
        accessToken = userMethods.createUser(user).extract().path("accessToken").toString();
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
        accessToken = userMethods.createUser(user).extract().path("accessToken").toString();
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
}
