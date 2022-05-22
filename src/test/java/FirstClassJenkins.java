import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClassJenkins extends base {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws Throwable {
        driver = initializeDriver();
    }

    @Test
    public void login(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("123456");
        driver.findElement(By.id("pass")).sendKeys("654321");
        driver.findElement(By.name("login")).click();

//        String errorText = driver.findElement(By.name("login")).getText();
//        Assert.assertEquals(errorText, "No valid credential");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
