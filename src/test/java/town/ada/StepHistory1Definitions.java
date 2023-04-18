package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //WebDriverManager.chromedriver().browserVersion("112.0.5615.49").setup();
        driver = new ChromeDriver();
    }

    @Given("I am in the town page {string}")
    public void i_am_in_the_town_page(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("I click in {string} link")
    public void i_click_in_informations_link(String informations) {
        driver.findElement(By.linkText(informations.toUpperCase())).click();
    }

    @Then("I must redirect to {string} page")
    public void i_must_redirect_to_informations_page(String informations) {
        String page = driver.getCurrentUrl();
        Assertions.assertTrue(page.contains(informations));
    }

    @After
    public void stop() {
        driver.quit();
    }
}
