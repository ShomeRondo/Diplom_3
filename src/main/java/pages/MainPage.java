package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.MAIN_PAGE_URL;
import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

public class MainPage {
    private final WebDriver driver;

    //кнопка "Войти в аккаунт"
    private final By loginButtonOnMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка "Личный кабинет"
    private final By profileButtonOnMainPage = By.xpath("//p[text()='Личный Кабинет']");
    //кнопка "Булки"
    private final By bunsButtonOnMainPage =  By.xpath(".//span[text() = 'Булки']");
    //кнопка "Соусы"
    private final By sauseButtonOnMainPage = By.xpath(".//span[text() = 'Соусы']");
    //кнопка "Начинки"
    private final By fillingsButtonOnMainPage = By.xpath(".//h2[text() = 'Начинки']");

    //Текст заголовок "Булки"
    private final By bunsText = By.xpath(".//h2[text()='Булки']");

    //Текст заголовок "Соусы"
    private final By saucesText = By.xpath(".//h2[text()='Соусы']");

    //Текст заголовок "Начинки"
    private final By fillingsText = By.xpath(".//h2[text()='Начинки']");

    //кнопка "Оформить заказ"
    private final By btnOrder = By.xpath(".//button[text()='Оформить заказ']");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage mainPageOpen(){
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    //клик по кнопке "Войти в аккаунт"
    public LoginPage clickBtnLoginOnMainPage(){
        driver.findElement(loginButtonOnMainPage).click();
        return new LoginPage(driver);
    }

    //клик по кнопке "Личный кабинет"
    public LoginPage clickBtnProfileOnMainPage(){
        driver.findElement(profileButtonOnMainPage).click();
        return new LoginPage(driver);
    }

    //клик по кнопке "Личный кабинет" после авторизации
    public void clickBtnProfileAfterAuthorisation(){
        driver.findElement(profileButtonOnMainPage).click();
    }

    //клик по разделу "Булки"
    public MainPage clickBunsBtnOnMainPage(){
        driver.findElement(bunsButtonOnMainPage).click();
        return this;
    }

    //клик по разделу "Соусы"
    public MainPage clickSauseBtnOnMainPage(){
        driver.findElement(sauseButtonOnMainPage).click();
        return this;
    }

    //клик по разделу "Начинки"
    public MainPage clickFillingBtn(){
        driver.findElement(fillingsButtonOnMainPage).click();
        return this;
    }

    //проверка кнопки "Оформить заказ"
    public MainPage checkOrderBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(btnOrder));
        driver.findElement(btnOrder).isEnabled();
        return this;
    }

    //проверка заголовка "Булки"
    public MainPage checkHeaderBuns(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsText));
        driver.findElement(bunsText).isDisplayed();
        return this;
    }
    //проверка заголовка "Соусы"

    public MainPage checkHeaderSauces(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesText));
        driver.findElement(saucesText).isDisplayed();
        return this;
    }

    //проверка заголовка "Начинки"
    public MainPage checkHeaderFillings(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsText));
        driver.findElement(fillingsText).isDisplayed();
        return this;
    }
}
