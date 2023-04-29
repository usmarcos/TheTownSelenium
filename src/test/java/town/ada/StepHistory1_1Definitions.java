package town.ada;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static town.ada.StepDefinitions.getDriver;

/*
 *You're not allowed to extend classes that define Step Definitions or hooks.
 *class town.ada.StepHistory1_1Definitions extends class town.ada.StepDefinitions
 */
public class StepHistory1_1Definitions {
    private WebDriver driver = getDriver();
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
}
