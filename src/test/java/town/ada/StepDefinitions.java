package town.ada;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //WebDriverManager.chromedriver().browserVersion("112.0.5615.49").setup();
        driver = new ChromeDriver();
        */
    }

    @Given("an example scenario")
    public void anExampleScenario() {
        driver.get("https://thetown.com.br/pt/");
        driver.manage().window().maximize();
        System.out.println("an example scenario");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
        driver.findElement(By.linkText("INFORMAÇÕES")).click();
        System.out.println("all step definitions are implemented");
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
        String page = driver.getCurrentUrl();
        Assertions.assertTrue(page.contains("/informacoes"));
        driver.quit();
        System.out.println("Teste");
    }
}
