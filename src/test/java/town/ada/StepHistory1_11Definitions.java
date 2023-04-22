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
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_11Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
    }

    @Dado("que clico no link de {string} a partir de {string}")
    public void clico_no_link_informacoes_na_home(String link, String url) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        driver.findElement(By.linkText("INFORMAÇÕES")).click();
    }

    @When("descer na página de informações e clicar na imagem da Heineken Patrocinador master")
    public void clicar_na_imagem_heineken() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,3200)", "");
        this.waitLoad(3000L);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div/a")).click();
    }

    @Entao("devo ser direcionado para a página da heineken brasil {string}")
    public void devo_ser_direcionado_para_pagina_heineken(String url) {
        this.waitLoad(2000L);
        String linkUrl = driver.getCurrentUrl();
        Assertions.assertTrue(linkUrl.equals(url));
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
