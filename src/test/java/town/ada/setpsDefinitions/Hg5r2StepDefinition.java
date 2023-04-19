package town.ada.setpsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.killDriver;

public class Hg5r2StepDefinition {
    @After
    public void closeBrowser() {
        killDriver();
    }

    @Dado("que acesso o site")
    public void queAcessoOSite() {
        assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/");
    }

    @Quando("for selecionada a opção {string}")
    public void forSelecionadaAOpcao(String nomeLink) {
        getDriver().findElement(By.linkText(nomeLink)).click();
    }

    @Entao("o usuário deve ser redirecionado para a página {string}")
    public void oUsuarioDeveSerRedirecionadoParaAPagina(String titulo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(titulo));
        assertEquals(getDriver().getTitle(), titulo);
    }

    @Quando("avançar no carrossel e chegar no banner de Lineup")
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


    @E("clico na opção {string}")
    public void clicoNaOpção(String porDia) {
        getDriver().findElement(By.linkText(porDia)).click();
    }

    @Então("o usuário deve ser redirecionado para a URL do primeiro dia disponível")
    public void oUsuárioDeveSerRedirecionadoParaAURLDoPrimeiroDiaDisponível() {
        //primeiro valor que aparecer abaixo do por dia (já que pode mudar o valor)
        String dia = getDriver().findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[3]/div[1]/a")).get(0).getText();
        getDriver().findElement(By.linkText(dia)).click();
        //concateno a url e verifico se será o valor correto
        assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/lineup/dia/" + dia + "/");
    }

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
}
