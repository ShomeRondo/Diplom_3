package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.REGISTER_PAGE_URL;

public class RegistrationPage {
    private final WebDriver driver;

    // поле "Имя"
    private final By textboxNameOnRegPage = By.xpath(".//label[text() = 'Имя']/parent::div/input");
    // поле "Email"
    private final By textboxEmailOnRegPage = By.xpath(".//label[text() = 'Email']/parent::div/input");
    //поле "Пароль"
    private final By textboxPasswordOnRegPage = By.xpath(".//input[@name = 'Пароль']");

    //кнопка "Зарегистрироваться"
    private final By signInButtonOnRegPage = By.xpath(".//button[text()='Зарегистрироваться']");
    //кнопка "Войти"
    private final By loginButtonOnRegPage = By.xpath(".//a[text()='Войти']");

    //текст ошибки при вводе невалидного пароля
    private final By errorMessageForPasswordOnRegPage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("ввод текста в поле Имя")
    public RegistrationPage fillTextBoxNameOnRegPage(String name){
        driver.findElement(textboxNameOnRegPage).click();
        driver.findElement(textboxNameOnRegPage).sendKeys(name);
        return this;
    }

    @Step("ввод текста в поле Email")
    public RegistrationPage fillTextboxEmailOnRegPage(String email){
        driver.findElement(textboxEmailOnRegPage).click();
        driver.findElement(textboxEmailOnRegPage).sendKeys(email);
        return this;
    }

    @Step("ввод текста в поле Пароль")
    public RegistrationPage fillTextboxPasswordOnRegPage(String password){
        driver.findElement(textboxPasswordOnRegPage).sendKeys(password);
        return this;
    }

    @Step("клик по кнопке Зарегистрироваться")
    public LoginPage clickBtnSignINOnRegPage(){
        driver.findElement(signInButtonOnRegPage).click();
        return new LoginPage(driver);
    }

    @Step("проверка текста ошибки для пароля меньше 6 символов")
    public RegistrationPage checkErrorMessageOnRegPage(){
        driver.findElement(errorMessageForPasswordOnRegPage).isDisplayed();
        return this;
    }

    @Step("клик по полю Имя")
    public RegistrationPage clickTextboxNameOnRegPage(){
        driver.findElement(textboxNameOnRegPage).click();
        return this;
    }

   @Step("Клик по кнопке Войти")
    public LoginPage clickLoginBtnOnRegPage(){
        driver.findElement(loginButtonOnRegPage).click();
        return new LoginPage(driver);
    }


}
