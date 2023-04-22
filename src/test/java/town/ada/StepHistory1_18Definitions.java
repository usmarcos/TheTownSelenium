package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_18Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }

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
        this.waitLoad(3000L);
    }

    @E("clicar em {string}")
    public void clicar_em_o_festival(String festival) {
        driver.findElement(By.linkText(festival)).click();
    }

    @Entao("devo ser direcionado para a página de festival {string}")
    public void devo_ser_direcionado_para_festival(String url) {
        String linkUrl = driver.getCurrentUrl();
        this.waitLoad(2000L);
        Assertions.assertTrue(linkUrl.equals(url));
    }

    @After
    public void stop() {
        driver.quit();
    }

    private void waitLoad(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Não deu certo");
        }
    }
}
