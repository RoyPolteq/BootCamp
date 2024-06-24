package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver createDriver (Browser browser) {

        switch (browser) {

            case CHROME:
            default: //geeft aan dat deze optie de default is
                return createChromeDriver();

            case FIREFOX:
                return createFirefoxDriver();

            case EDGE:
                return createEdgeDriver();

            case SAFARI:
                return createSafariDriver();
        }

    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver createSafariDriver() {
        return new SafariDriver();
    }








}
