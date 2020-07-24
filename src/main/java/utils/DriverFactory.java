package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private String browser;
    private ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    protected static WebDriver driver;
    private Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    private DriverFactory(String browser) {
        this.browser = browser;
    }

    public DriverFactory() {
    }

    public static WebDriver getDriver() {
        Properties p = new Properties();
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverFactory driverFactory = new DriverFactory(p.getProperty("browser"));
        return driverFactory.createDriver();
    }

    //chrome driver supplier
    private final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
        threadLocalWebDriver.set(new ChromeDriver(getChrome_options()));
        return threadLocalWebDriver.get();
    };

    //firefox driver supplier
    private final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
        threadLocalWebDriver.set(new FirefoxDriver(getFirefox_options()));
        return threadLocalWebDriver.get();
    };

    private static ChromeOptions getChrome_options() {
        ChromeOptions chrome_options = new ChromeOptions();
//        chrome_options.addArguments("--headless");
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--disable-dev-shm-usage");
        return chrome_options;
    }

    private static FirefoxOptions getFirefox_options() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        return firefoxOptions;
    }

    //add more suppliers here

    //add all the drivers into a map
    {
        driverMap.put("chrome", chromeDriverSupplier);
        driverMap.put("firefox", firefoxDriverSupplier);
    }

    //return a new driver from the map
    public final WebDriver createDriver() {
        return driverMap.get(browser).get();
    }
}
