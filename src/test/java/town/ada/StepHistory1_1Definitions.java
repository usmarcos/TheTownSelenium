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

/*
 *You're not allowed to extend classes that define Step Definitions or hooks.
 *class town.ada.StepHistory1_1Definitions extends class town.ada.StepDefinitions
 */
public class StepHistory1_1Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
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
        Assertions.assertTrue(page.equals(informations));
    }

    @After
    public void stop() {
        //driver.quit();
    }

    private void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
