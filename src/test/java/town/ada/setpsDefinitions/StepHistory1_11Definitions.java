package town.ada.setpsDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_11Definitions {

    @Dado("que estou na pagina {string}")
    public void clico_no_link_informacoes_na_home(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        //Aceitando os termos dos cookies
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @When("descer na página de informações e clicar na imagem da Heineken Patrocinador master {string}")
    public void clicar_na_imagem_heineken(String xpath) {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        WebElement element = getDriver().findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView();", element);
        waitLoad(3000L);
        jse.executeScript("arguments[0].click();", element);
    }

    @Entao("devo ser direcionado para a página da heineken brasil {string}")
    public void devo_ser_direcionado_para_pagina_heineken(String url) {
        waitLoad(2000L);
        String window = null;
        for(String w : getDriver().getWindowHandles()) {
            window = w;
        }
        String newUrl = getDriver().switchTo().window(window).getCurrentUrl();
        Assertions.assertEquals(newUrl, url);
    }
}
