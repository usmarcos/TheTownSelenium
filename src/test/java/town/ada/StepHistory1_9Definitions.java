package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_9Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
    }

    @Dado("que a partir da pagina de informações {string} quero acessar a pagina de noticias")
    public void quero_acessar_pagina_de_noticias(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @When("clicar no link de noticias {string} SAIBA MAIS")
    public void clicar_no_link_noticias(String noticias) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2900)", "");
        this.waitLoad(3000L);
        driver.findElement(By.partialLinkText(noticias)).click();
    }

    @Then("devo ser redirecionado para a pagina de noticias {string}")
    public void devo_ser_redirecionado_para_noticias(String url) {
        String linkUrl = driver.getCurrentUrl();
        this.waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
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
