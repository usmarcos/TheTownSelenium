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

public class StepHistory1_12Definitions {

    @Dado("que na pagina {string} quero acessar o link de apoio institucional")
    public void quero_acessar_pagina_apoio_institucional(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        //Aceitando os termos dos cookies
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        getDriver().findElement(By.linkText("INFORMAÇÕES")).click();
    }

    @Quando("descer até apoio institucional e clicar no incone do estado de SP")
    public void clicar_no_icone_estado_sp() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scrollBy(0,3200)", "");
        waitLoad(3000L);
        getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/a")).click();
    }

    @Entao("devo ser redirecionado para {string}")
    public void devo_ser_redirecionado_para_pagina_estado_sp(String url) {
        waitLoad(2000L);
        String window = null;
        for(String w : getDriver().getWindowHandles()) {
            window = w;
        }
        String newUrl = getDriver().switchTo().window(window).getCurrentUrl();
        Assertions.assertTrue(url.equals(newUrl));
    }
}
