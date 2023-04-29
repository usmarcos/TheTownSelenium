package town.ada;

import io.cucumber.java.en.Then;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_4Definitions {
    private WebDriver driver = getDriver();

    @Dado("que estou na página de informações {string}")
    public void estou_na_pagina_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown {string}")
    public void descer_ate_sessao_duvidas_dropdown(String text) {
        /*Referencia:
        * https://pt.stackoverflow.com/questions/223957/algu%C3%A9m-sabe-como-posso-fazer-scroll-no-selenium-webdriver-em-java
        * Scripts para controlar a barra de rolagem pela posição*/
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,4000)", "");
        /*Aguardar o carregamento da página, caso contrário retorna erro pois o botão de dropdown não aparece e não
        * fica clicável*/
        waitLoad(3000L);
        //driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[8]/div[2]/div[1]/div[1]/h2/button")).click();
        driver.findElement(By.xpath(text)).click();
    }

    @Then("deverá ser exibido em tela as seguintes informações {string} {string} e {string} {string}")
    public void devera_exibir_informacoes(String texto1, String xpath1, String texto2, String xpath2) {
        String txt1 = driver.findElement(By.xpath(xpath1)).getText();
        String txt2 = driver.findElement(By.xpath(xpath2)).getText();
        Assertions.assertEquals(texto1, txt1);
        Assertions.assertEquals(texto2, txt2);
    }
}
