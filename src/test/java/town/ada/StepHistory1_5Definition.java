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

public class StepHistory1_5Definition {
    private WebDriver driver;

    @Before
    public void setup() {
        /*
        System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        */
    }

    @Dado("que já estou na página de informações {string}")
    public void estou_na_pagina_de_informacoes(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("descer até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de Quando será a venda dos ingressos do The Town")
    public void descer_ate_sessao_duvidas_selecionado_quando_sera_venda_dos_ingressos() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,2500)", "");
        this.waitLoad(3000L);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/h2/button")).click();
    }

    @Entao("deverá exibir na tela as seguintes informações {string} e {string}")
    public void devera_exibir_em_tela_a_informacao(String info1, String info2) {
        String text1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/div/div/p[1]")).getText();
        String text2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/div/div/p[2]")).getText();
        Assertions.assertTrue(info1.equals(text1) && info2.equals(text2));
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
