package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

public class LoginPage {
    private final WebDriver driver;
    //поле "Email"
    private final By textboxEmailOnLoginPage = By.xpath(".//input[@name = 'name']");
    //поле "Пароль"
    private final By textboxPasswordOnLoginPage = By.xpath(".//input[@name = 'Пароль']");
    //кнопка "Войти"
    private final By loginButtonOnLoginPage = By.xpath(".//button[text() = 'Войти']");
    // Кнопка "Восстановить пароль"
    private final By restoreButtonOnLoginPage = By.xpath(".//a[text() = 'Восстановить пароль']");
    //кнопка "Зарегистрироваться
    private final By signInButtonOnLoginPage = By.xpath(".//a[text() = 'Зарегистрироваться']");

    //заголовок "Вход"
    private final By loginHeaderOnLoginPage = By.xpath(".//h2[text() = 'Вход']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("ввод в поле Email")
    public LoginPage fillTextboxEmailOnLoginPage(String email){
        driver.findElement(textboxEmailOnLoginPage).click();
        driver.findElement(textboxEmailOnLoginPage).sendKeys(email);
        return this;
    }

    @Step("ввод в поле Пароль")
    public LoginPage fillTextboxPasswordOnLoginPage(String password){
        driver.findElement(textboxPasswordOnLoginPage).click();
        driver.findElement(textboxPasswordOnLoginPage).sendKeys(password);
        return this;
    }

    @Step ("клик по кнопке Войти")
    public MainPage clickLoginButtonOnLoginPage(){
        driver.findElement(loginButtonOnLoginPage).click();
        return new MainPage(driver);
    }
    @Step("клик по кнопке Зарегистрироваться")
    public RegistrationPage clickSignUpBtnOnLoginPage(){
        driver.findElement(signInButtonOnLoginPage).click();
        return new RegistrationPage(driver);
    }

    @Step("клик по кнопке Восстановить пароль")
    public RestorePage clickRestoreBtnOnLoginPage(){
        driver.findElement(restoreButtonOnLoginPage).click();
        return new RestorePage(driver);
    }

    @Step ("Проверка видимости заголовка формы Вход")
    public LoginPage checkHearderOnLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginHeaderOnLoginPage));
        driver.findElement(loginHeaderOnLoginPage).isDisplayed();
        return this;
    }

}
