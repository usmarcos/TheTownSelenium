package town.ada;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHistory1_4DEfinitions {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //WebDriverManager.chromedriver().browserVersion("112.0.5615.49").setup();
        driver = new ChromeDriver();
    }

    @Dado("que estou na página de informações {string}")
    public void estou_na_pagina_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Quando("descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de QUANDO E ONDE ACONTECERÁ")
    public void descer_ate_sessao_duvidas_dropdown() {
        //Referencia: https://pt.stackoverflow.com/questions/223957/algu%C3%A9m-sabe-como-posso-fazer-scroll-no-selenium-webdriver-em-java
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,700)", "");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[1]/h2/button")).click();
    }

    @Then("deverá ser exibido em tela as seguintes informações {string}")
    public void devera_exibir_informacoes(String texto) {
        try {
            Thread.sleep(2000);
            System.out.println(texto);
        } catch (Exception e){
            System.out.println("Ola");
        }
    }

    @After
    public void stop() {
        driver.quit();
    }
}
