package town.ada.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://thetown.com.br/pt/");
        }
        return driver;
    }

    public static void killDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
