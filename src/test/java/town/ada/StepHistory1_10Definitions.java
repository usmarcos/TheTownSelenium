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

public class StepHistory1_10Definitions {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
    }

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
        this.waitLoad(3000L);
        driver.findElement(By.partialLinkText(home)).click();
    }

    @Entao("devo voltar para a página inicial {string}")
    public void devo_voltar_para_pagina_inicial(String url) {
        String linkUrl = driver.getCurrentUrl();
        this.waitLoad(2000L);
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
