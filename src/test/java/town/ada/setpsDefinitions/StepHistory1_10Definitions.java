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

public class StepHistory1_10Definitions {
    private WebDriver driver = getDriver();


    @Dado("que na pagina de informações {string} quero acessar a pagina HOME")
    public void quero_ir_para_pagina_home(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("clicar no link home {string}")
    public void clicar_no_link_home(String home) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2900)", "");
        waitLoad(3000L);
        driver.findElement(By.partialLinkText(home)).click();
    }

    @Entao("devo voltar para a página inicial {string}")
    public void devo_voltar_para_pagina_inicial(String url) {
        String linkUrl = driver.getCurrentUrl();
        waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }
}
