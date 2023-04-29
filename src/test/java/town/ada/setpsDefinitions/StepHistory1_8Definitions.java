package town.ada.setpsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_8Definitions {
    private WebDriver driver = getDriver();
    @Dado("estou em {string} da página do The Town")
    public void estou_em_informacoes_do_the_town(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("clicar no link {string} SAIBA MAIS")
    public void clicar_no_link_faq_saiba_mais(String faq) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2900)", "");
        waitLoad(3000L);
        driver.findElement(By.partialLinkText(faq)).click();
    }

    @Entao("devo ir para a página {string}")
    public void devo_ir_para_a_pagina_faq(String url) {
        String linkUrl = driver.getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
