package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.RESTORE_PASSWORD_URL;

public class RestorePage {
    private final WebDriver driver;


    //кнопка "Войти"
    private final By loginButton = By.xpath(".//a[text() = 'Войти']");


    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

    //клик по кнопке "Войти"
    public LoginPage clickLoginBtn(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
