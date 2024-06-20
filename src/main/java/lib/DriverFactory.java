package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum Browser {
        CHROME,
        FIREFOX
    }

    public static WebDriver createBrowser(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case CHROME:
            default:
                return createChromeBrowser();
        }
    }

    private static WebDriver createChromeBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }

    private static WebDriver createFireFoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}
