package town.ada.setpsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static town.ada.core.DriverFactory.getDriver;
import static town.ada.core.DriverFactory.killDriver;

public class Hg5r4StepDefinition {
    @After
    public void tearDown() {
        killDriver();
    }

    @Então("clico nas notícias disponíveis o usuário deve ser redirecionado para a página correspondente")
    public void clicoNasNotíciasDisponíveisOUsuárioDeveSerRedirecionadoParaAPáginaCorrespondente() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1000);
                String titulo = getDriver().getTitle();
                //fazendo com que a página faça um scroll até o elemento antes
                WebElement elemento = getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/div/div/div[" + i + "]/a/div/div[2]"));
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", elemento);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", elemento);
                //elemento.click();
                Thread.sleep(1000);
                String novaPagina = getDriver().getTitle();
                assertNotEquals(titulo, novaPagina);
                getDriver().navigate().back();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Não existem mais notícias disponíveis");
                break;
            }
        }
    }
}
