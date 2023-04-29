package town.ada.setpsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_9Definitions {
    private WebDriver driver = getDriver();
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
        waitLoad(3000L);
        driver.findElement(By.partialLinkText(noticias)).click();
    }

    @Then("devo ser redirecionado para a pagina de noticias {string}")
    public void devo_ser_redirecionado_para_noticias(String url) {
        String linkUrl = driver.getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
