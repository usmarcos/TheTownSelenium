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

    @Dado("estou em {string} da página do The Town")
    public void estou_em_informacoes_do_the_town(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("clicar no link {string} SAIBA MAIS")
    public void clicar_no_link_faq_saiba_mais(String faq) {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scrollBy(0,2900)", "");
        waitLoad(3000L);
        getDriver().findElement(By.partialLinkText(faq)).click();
    }

    @Entao("devo ir para a página {string}")
    public void devo_ir_para_a_pagina_faq(String url) {
        String linkUrl = getDriver().getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
