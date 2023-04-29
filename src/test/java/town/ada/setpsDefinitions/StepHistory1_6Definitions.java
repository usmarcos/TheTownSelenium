package town.ada.setpsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_6Definitions {

    @Dado("que entrei na página de informações {string}")
    public void entrei_na_pagina_de_informacoes(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e clicar no botão {string}")
    public void clicar_no_botao_ver_todas_as_duvidas(String botao) {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        //jse.executeScript("scrollBy(0,4400)", "");
        /*Aguardar o carregamento da página, caso contrário retorna erro pois o botão de dropdown não aparece e não
         * fica clicável*/
        WebElement element = getDriver().findElement(By.partialLinkText(botao));
        jse.executeScript("arguments[0].scrollIntoView();", element);
        waitLoad(3000L);
        jse.executeScript("arguments[0].click();", element);
    }

    @Entao("devo ser direcionado para a página {string}")
    public void devo_ser_direcionado_para_faq(String url) {
        waitLoad(3000L);
        String page = getDriver().getCurrentUrl();
        Assertions.assertEquals(page, url);
    }
}
