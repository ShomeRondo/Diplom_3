import config.BaseURI;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static driver.WebDriverCreator.createWebDriver;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = createWebDriver();
        RestAssured.baseURI = BaseURI.baseURI;
    }

    @Test
    @DisplayName("переход к разделу Булки")
    public void checkTransferToBuns(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickSauseBtnOnMainPage()
                .clickBunsBtnOnMainPage()
                .checkHeaderBuns();
    }

    @Test
    @DisplayName("переход к разделу Соусы")
    public void checkTransferToSauces(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickSauseBtnOnMainPage()
                .checkHeaderSauces();
    }

    @Test
    @DisplayName("переход к разделу Начинки")
    public void checkTransferToFillings(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickFillingBtn()
                .checkHeaderFillings();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
