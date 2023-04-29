package town.ada.setpsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_18Definitions {

    @Dado("que a partir da pagina home {string}, clico no link de {string}")
    public void clico_no_link_festival(String url, String link) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        //Aceitando os termos dos cookies
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        getDriver().findElement(By.linkText(link)).click();
    }

    @Quando("descer a pagina até o rodapé")
    public void descer_a_pagina_ate_rodape() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scrollBy(0,4500)", "");
        waitLoad(3000L);
    }

    @E("clicar em {string}")
    public void clicar_em_o_festival(String festival) {
        getDriver().findElement(By.linkText(festival)).click();
    }

    @Entao("devo ser direcionado para a página de festival {string}")
    public void devo_ser_direcionado_para_festival(String url) {
        String linkUrl = getDriver().getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
