package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_1Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //WebDriverManager.chromedriver().browserVersion("112.0.5615.49").setup();
        driver = new ChromeDriver();
    }

    @Dado("que estou na página do the town {string}")
    public void i_am_in_the_town_page(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Quando("clicar no link {string}")
    public void i_click_in_informations_link(String informations) {
        driver.findElement(By.linkText(informations.toUpperCase())).click();
    }

    @Entao("devo ser redirecionado para a pagina de {string}")
    public void i_must_be_redirect_to_informations_page(String informations) {
        String page = driver.getCurrentUrl();
        Assertions.assertTrue(page.contains(informations));
    }

    @After
    public void stop() {
        driver.quit();
    }
}
