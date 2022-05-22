import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws Throwable {
        String basePath = System.getProperty("user.dir");

        //cл. 4 строки берут названия браузера из файла data.properties
//        prop = new Properties();
//        FileInputStream fis = new FileInputStream(basePath + "\\src\\main\\resources\\data.properties");
//        prop.load(fis);
//        String browserName = prop.getProperty("browser");

        //сл. строка берет названия браузера из команды maven-a
        String browserName = System.getProperty("browser");

        System.out.println(browserName);

        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", basePath + "\\src\\main\\resources\\chromedriver.exe");

            //С помощью класса ChromeOptions мы добавляем опцию безголовочного режима если названия браузера содержить слова headless
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")) {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
        }
        else if (browserName.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", basePath + "\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //firefox code
        } else if (browserName.equals("IE")) {
            //	IE code
        } else {
            System.setProperty("webdriver.chrome.driver", basePath + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }
}
