package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static town.ada.StepDefinitions.getDriver;
import static town.ada.StepDefinitions.waitLoad;

public class StepHistory1_11Definitions {
    private WebDriver driver = getDriver();

    @Dado("que estou na pagina {string}")
    public void clico_no_link_informacoes_na_home(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @When("descer na página de informações e clicar na imagem da Heineken Patrocinador master {string}")
    public void clicar_na_imagem_heineken(String xpath) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView();", element);
        waitLoad(3000L);
        jse.executeScript("arguments[0].click();", element);
    }

    @Entao("devo ser direcionado para a página da heineken brasil {string}")
    public void devo_ser_direcionado_para_pagina_heineken(String url) {
        waitLoad(2000L);
        String window = null;
        for(String w : driver.getWindowHandles()) {
            window = w;
        }
        String newUrl = driver.switchTo().window(window).getCurrentUrl();
        Assertions.assertTrue(newUrl.equals(url));
    }
}
