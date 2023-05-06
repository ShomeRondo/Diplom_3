package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;

public class ProfilePage {
    private final WebDriver driver;

    //кнопка "Конструктор"
    private final By constructorButtonOnMainPage = By.xpath("//p[text() = 'Конструктор']");
    //логотип
    private final By logoOnMainPage = By.tagName("svg");
    //кнопка "Выход"
    private final By logoutButton = By.xpath(".//button[text()='Выход']");


    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    //клик по конструктору
    public MainPage clickConstructorBtnOnMainPage(){
        driver.findElement(constructorButtonOnMainPage).click();
        return new MainPage(driver);
    }

    //клик по логотипу
    public MainPage clickLogoOnMainPage(){
        driver.findElement(logoOnMainPage).click();
        return new MainPage(driver);
    }

    //проверка кнопки "Выход"
    public ProfilePage checkLogoutBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).isEnabled();
        return this;
    }

    //выход из личного кабинета
    public LoginPage cliclLogoutBtn(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

}
