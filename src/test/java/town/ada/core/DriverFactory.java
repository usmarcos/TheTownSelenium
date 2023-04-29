package town.ada.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver == null) {
            System.setProperty("webdriver.edge.driver", "src/driver/msedgedriver.exe");
            driver = new EdgeDriver();

            driver.manage().window().maximize();
            driver.get("https://thetown.com.br/pt/");
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
