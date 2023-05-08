import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

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
}
