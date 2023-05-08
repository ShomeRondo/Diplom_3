package pages;

import io.qameta.allure.Step;
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
    private final By bunsButtonOnMainPage =  By.xpath(".//span[text()='Булки']//parent::div");
    //кнопка "Соусы"
    private final By sauseButtonOnMainPage = By.xpath(".//span[text()='Соусы']//parent::div");
    //кнопка "Начинки"
    private final By fillingsButtonOnMainPage = By.xpath(".//span[text()='Начинки']//parent::div");


    //кнопка "Оформить заказ"
    private final By btnOrder = By.xpath(".//button[text()='Оформить заказ']");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    @Step("Открытие главной страницы сайта")
    public MainPage mainPageOpen(){
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    @Step("клик по кнопке Войти в аккаунт")
    public LoginPage clickBtnLoginOnMainPage(){
        driver.findElement(loginButtonOnMainPage).click();
        return new LoginPage(driver);
    }

    @Step("клик по кнопке Личный кабинет")
    public LoginPage clickBtnProfileOnMainPage(){
        driver.findElement(profileButtonOnMainPage).click();
        return new LoginPage(driver);
    }

    @Step("клик по кнопке Личный кабинет после авторизации")
    public void clickBtnProfileAfterAuthorisation(){
        driver.findElement(profileButtonOnMainPage).click();
    }

    @Step("клик по разделу Булки")
    public MainPage clickBunsBtnOnMainPage(){
        driver.findElement(bunsButtonOnMainPage).click();
        return this;
    }

    @Step("клик по разделу Соусы")
    public MainPage clickSauseBtnOnMainPage(){
        driver.findElement(sauseButtonOnMainPage).click();
        return this;
    }

    @Step("клик по разделу Начинки")
    public MainPage clickFillingBtn(){
        driver.findElement(fillingsButtonOnMainPage).click();
        return this;
    }

    @Step("проверка кнопки Оформить заказ")
    public MainPage checkOrderBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(btnOrder));
        driver.findElement(btnOrder).isEnabled();
        return this;
    }

   @Step("проверка атрибута для кнопки Булки после выбора")
    public String checkAtrubuteForBuns(){
        return driver.findElement(bunsButtonOnMainPage).getAttribute("class");
   }

    @Step("проверка атрибута для кнопки Соусы после выбора")
    public String checkAtrubuteForSauce(){
        return driver.findElement(sauseButtonOnMainPage).getAttribute("class");
    }

    @Step("проверка атрибута для кнопки Начинки после выбора")
    public String checkAtrubuteForFilling(){
        return driver.findElement(fillingsButtonOnMainPage).getAttribute("class");
    }
}
