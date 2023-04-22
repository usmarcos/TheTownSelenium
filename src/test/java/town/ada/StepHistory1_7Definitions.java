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

public class StepHistory1_7Definitions {
    private WebDriver driver;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }

    @Dado("que entrei na página de informaçoes do The Town {string}")
    public void entrei_na_pagina_de_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @When("descer, na página, até sessão de DÚVIDAS MAIS FREQUENTES e clicar no link {string}")
    public void clicar_no_link_line_up(String link) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2900)", "");
        this.waitLoad(3000L);
        driver.findElement(By.partialLinkText(link)).click();
    }

    @Then("devo ser direcionado para {string}")
    public void devo_ser_redirecionado_para(String url) {
        String linkUrl = driver.getCurrentUrl();
        this.waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }

    @After
    public void stop() {
        driver.quit();
    }

    private void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
