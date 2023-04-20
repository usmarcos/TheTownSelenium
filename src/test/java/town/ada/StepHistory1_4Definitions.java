package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_4Definitions {
    private WebDriver driver;

    /*
    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        //driver = new ChromeDriver();
    }
    */

    @Dado("que estou na página de informações {string}")
    public void estou_na_pagina_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Quando("descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de QUANDO E ONDE ACONTECERÁ")
    public void descer_ate_sessao_duvidas_dropdown() {
        /*Referencia:
        * https://pt.stackoverflow.com/questions/223957/algu%C3%A9m-sabe-como-posso-fazer-scroll-no-selenium-webdriver-em-java
        * Scripts para controlar a barra de rolagem pela posição*/
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2346)", "");
        /*Aguardar o carregamento da página, caso contrário retorna erro pois o botão de dropdown não aparece e não
        * fica clicável*/
        this.waitLoad(3000L);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[1]/h2/button")).click();
    }

    @Then("deverá ser exibido em tela as seguintes informações {string} e {string}")
    public void devera_exibir_informacoes(String texto1, String texto2) {
        String txt1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[1]/div/div/p[1]")).getText();
        String txt2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[1]/div/div/p[2]")).getText();
        Assertions.assertEquals(texto1, txt1);
        Assertions.assertEquals(texto2, txt2);
    }

    /*
    @After
    public void stop() {
        driver.quit();
    }
    */

    private void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
