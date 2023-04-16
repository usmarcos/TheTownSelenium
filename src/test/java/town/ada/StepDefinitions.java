package town.ada;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    @Given("an example scenario")
    public void anExampleScenario() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://thetown.com.br/pt/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("INFORMAÇÕES")).click();
        this.timeView(1000L);
        String page = driver.getCurrentUrl();
        Assertions.assertTrue(page.contains("/informacoes"));
        this.timeView(1000L);
        driver.close();
        System.out.println("an example scenario");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
        System.out.println("all step definitions are implemented");
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
        System.out.println("Teste");
    }

    private void timeView(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
