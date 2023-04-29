package town.ada;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import static town.ada.StepDefinitions.getDriver;
import static town.ada.StepDefinitions.waitLoad;

public class StepHistory1_2Definitions {
    private WebDriver driver = getDriver();

    @Dado("que clico no menu {string} na pagina {string}")
    public void clico_no_menu_informacoes(String informacoes, String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msg-cookie\"]/div/div/button")).click();
        driver.findElement(By.linkText(informacoes.toUpperCase())).click();
    }

    @Quando("descer até o mapa interativo")
    public void descer_ate_mapa_interativo() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,1500)", "");
        waitLoad(3000L);
    }

    @E("clico no balão com numero 6")
    public void clico_no_balao_numero_6() {
        Point point = driver.findElement(By.xpath("//*[@id=\"map\"]/div[1]/div[4]/div[6]")).getLocation();
        System.out.println(point);
    }

    @Entao("deverá aparecer a mensagem com as informações do palco {string}")
    public void devera_aparecer_mensagem_skyline(String texto) {
        String txt = driver.findElement(By.className("leaflet-popup-content")).getText();
        waitLoad(1000L);
        Assertions.assertTrue(txt.contains(texto));
    }
}
