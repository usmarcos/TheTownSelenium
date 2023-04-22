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

public class StepHistory1_8Definitions {
    private WebDriver driver;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }

    @Dado("estou em {string} da página do The Town")
    public void estou_em_informacoes_do_the_town(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("clicar no link {string} SAIBA MAIS")
    public void clicar_no_link_faq_saiba_mais(String faq) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2900)", "");
        this.waitLoad(3000L);
        driver.findElement(By.partialLinkText(faq)).click();
    }

    @Entao("devo ir para a página {string}")
    public void devo_ir_para_a_pagina_faq(String url) {
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
