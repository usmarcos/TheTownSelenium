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

public class StepHistory1_12Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }

    @Dado("que na pagina {string} quero acessar o link de apoio institucional")
    public void quero_acessar_pagina_apoio_institucional(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        //Aceitando os termos dos cookies
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        driver.findElement(By.linkText("INFORMAÇÕES")).click();
    }

    @Quando("descer até apoio institucional e clicar no incone do estado de SP")
    public void clicar_no_icone_estado_sp() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,3200)", "");
        this.waitLoad(3000L);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/a")).click();
    }

    @Entao("devo ser redirecionado para {string}")
    public void devo_ser_redirecionado_para_pagina_estado_sp(String url) {
        this.waitLoad(2000L);
        driver.get(url);
        Assertions.assertTrue(url.equals(driver.getCurrentUrl()));
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
