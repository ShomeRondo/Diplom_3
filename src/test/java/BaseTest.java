import config.BaseURI;
import io.restassured.RestAssured;
import model.User;
import model.UserCredential;
import model.UserMethods;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static extentions.WebDriverCreator.createWebDriver;

public class BaseTest {
    WebDriver driver;
     User user;
     UserMethods userMethods;
     UserCredential credential;
     String accessToken;

     String name ="Джорно";
     String email = "jjovvanno@yandex.ru";
     String password = "123test";

    @Before
    public void setup() {
        driver = createWebDriver();
        RestAssured.baseURI = BaseURI.BASE_URI;
        user = new User(name, email, password);
        userMethods = new UserMethods();
    }

    @After
    public void teardown() {
        driver.quit();
        if(accessToken!=null) userMethods.deleteUser(accessToken);
    }
}
