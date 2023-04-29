package town.ada.setpsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.pt.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.killDriver;

public class Hg5r2StepDefinition {
    @After
    public void tearDown() {
        killDriver();
    }

    @Test
    @Dado("que acesso o site")
    public void queAcessoOSite() {
        //aceitando o cookies
        getDriver().findElement(By.xpath("//button[contains(text(),'Aceito')]")).click();
        assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/");
    }

    @Test
    @Quando("for selecionada a opção {string}")
    public void forSelecionadaAOpcao(String nomeLink) {
        getDriver().findElement(By.linkText(nomeLink)).click();
    }

    @Test
    @Entao("o usuário deve ser redirecionado para a página {string}")
    public void oUsuarioDeveSerRedirecionadoParaAPagina(String titulo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(titulo));
        assertEquals(getDriver().getTitle(), titulo);
    }

    @Quando("avançar no carrossel e chegar no banner de Lineup")
    @Test
    public void avancarNoCarrosselEChegarNoBannerDeLineup() throws InterruptedException {

        WebElement element = getDriver().findElement(By.className("carousel-control-next-icon"));
        for (int i = 0; i < 3; i++) {
            element.click();
            Thread.sleep(2000);
        }
        //quando a imagem ficar visivel em tela ele clica
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        By imagem = By.xpath("//*[@id=\"__next\"]/div[2]/div/div[2]/div[4]/a/img[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(imagem)).click();
    }

    @Test
    @E("clico na opção {string}")
    public void clicoNaOpção(String filtro) {
        getDriver().findElement(By.linkText(filtro)).click();
    }

    @Test
    @Então("o usuário deve ser redirecionado para a URL do primeiro dia disponível")
    public void oUsuárioDeveSerRedirecionadoParaAURLDoPrimeiroDiaDisponível() {
        String dia = getDriver().findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[3]/div[1]/a")).get(0).getText();
        getDriver().findElement(By.linkText(dia)).click();
        //concateno a url e verifico se será o valor correto
        assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/lineup/dia/" + dia + "/");
    }

    @Test
    @Então("quando clico nos dias exibidos o usuário deve ser redirecionado para a URL do dia disponível")
    public void quandoClicoNosDiasExibidosOUsuárioDeveSerRedirecionadoParaAURLDoDiaDisponível() {
        for (int i = 1; i <= 10; i++) {
            try {
                String dia = getDriver().findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[3]/div[" + i + "]/a")).get(0).getText();
                getDriver().findElement(By.linkText(dia)).click();
                assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/lineup/dia/" + dia + "/");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Não há mais dias disponíveis");
                break;
            }
        }

    }

    @Test
    @Então("quando clico nos palcos exibidos são exibidos os dias e os cantores")
    public void quandoClicoNosPalcosExibidosSãoExibidosOsDiasEOsCantores() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            try {
                String valorAntigo = getDriver().findElement(By.cssSelector(".container.py-50")).getAttribute("innerHTML");
                getDriver().findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/div[" + i + "]")).get(0).click();
                Thread.sleep(1000);
                String valorNovo = getDriver().findElement(By.cssSelector(".container.py-50")).getAttribute("innerHTML");

                assertNotSame(valorAntigo, valorNovo);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Não há mais palcos disponíveis");
                break;
            }
        }
    }

    @Test
    @Então("quando clico nos cantores a página é redirecionada de acordo com o palco e dia")
    public void quandoClicoNosCantoresAPáginaÉRedirecionadaDeAcordoComOPalcoEDia() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            try {
                String dia = getDriver().findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[3]/div[" + i + "]/a")).get(0).getText();
                getDriver().findElement(By.linkText(dia)).click();
                assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/lineup/dia/" + dia + "/");
                for (int k = 1; k <= 10; k++) {
                    try {
                        getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/div[" + k + "]")).click();
                    } catch (Exception e) {
                        System.out.println("Não há palco disponível");
                        break;
                    }
                    for (int j = 2; j <= 100; j++) {
                        try {
                            Thread.sleep(1000);

                            WebElement elemento = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[" + k + "]/div[" + j + "]/div/a"));
                            String cantorLineUp = elemento.getText();

                            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", elemento);
                            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", elemento);

                            Thread.sleep(1000);
                            String cantorPerfil = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[1]/h1")).getText();

                            assertEquals(cantorPerfil, cantorLineUp);
                            //quando volto a página alterior ele reseta o palco, então torno a clicar nele
                            getDriver().navigate().back();
                            getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/div[" + k + "]")).click();
                        } catch (Exception e) {
                            System.out.println("Não tem mais cantores disponíveis para este palco");
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Não há mais dias disponíveis");
                break;
            }
        }
    }


}
