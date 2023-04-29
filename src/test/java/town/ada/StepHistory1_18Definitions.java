package town.ada;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.StepDefinitions.getDriver;
import static town.ada.StepDefinitions.waitLoad;

public class StepHistory1_18Definitions {
    private WebDriver driver = getDriver();

    @Dado("que a partir da pagina home {string}, clico no link de {string}")
    public void clico_no_link_festival(String url, String link) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        driver.findElement(By.linkText(link)).click();
    }

    @Quando("descer a pagina até o rodapé")
    public void descer_a_pagina_ate_rodape() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,4500)", "");
        waitLoad(3000L);
    }

    @E("clicar em {string}")
    public void clicar_em_o_festival(String festival) {
        driver.findElement(By.linkText(festival)).click();
    }

    @Entao("devo ser direcionado para a página de festival {string}")
    public void devo_ser_direcionado_para_festival(String url) {
        String linkUrl = driver.getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
