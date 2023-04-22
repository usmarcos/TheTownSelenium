package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_6Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
    }

    @Dado("que entrei na página de informações {string}")
    public void entrei_na_pagina_de_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Quando("descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e clicar no botão {string}")
    public void clicar_no_botao_ver_todas_as_duvidas(String botao) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2360)", "");
        /*Aguardar o carregamento da página, caso contrário retorna erro pois o botão de dropdown não aparece e não
         * fica clicável*/
        this.waitLoad(3000L);
        driver.findElement(By.linkText(botao)).click();
    }

    @Entao("devo ser direcionado para a página {string}")
    public void devo_ser_direcionado_para_faq(String url) {
        this.waitLoad(1000L);
        String page = driver.getCurrentUrl();
        Assertions.assertTrue(page.equals(url));
    }

    @After
    public void stop() {
        //driver.quit();
    }

    private void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
