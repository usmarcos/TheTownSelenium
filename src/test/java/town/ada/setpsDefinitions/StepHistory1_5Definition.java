package town.ada.setpsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.waitLoad;

public class StepHistory1_5Definition {

    @Dado("que já estou na página de informações {string}")
    public void estou_na_pagina_de_informacoes(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
    }

    @Quando("descer até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de Quando será a venda dos ingressos do The Town")
    public void descer_ate_sessao_duvidas_selecionado_quando_sera_venda_dos_ingressos() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scrollBy(0,2500)", "");
        waitLoad(3000L);
        getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/h2/button")).click();
    }

    @Entao("deverá exibir na tela as seguintes informações {string} e {string}")
    public void devera_exibir_em_tela_a_informacao(String info1, String info2) {
        String text1 = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/div/div/p[1]")).getText();
        String text2 = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section[6]/div[2]/div[1]/div[4]/div/div/p[2]")).getText();
        Assertions.assertTrue(info1.equals(text1) && info2.equals(text2));
    }
}
