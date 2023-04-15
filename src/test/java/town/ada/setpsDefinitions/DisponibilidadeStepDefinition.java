package town.ada.setpsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

import static org.junit.jupiter.api.Assertions.*;
import static town.ada.core.DriverFactory.*;

import org.junit.jupiter.api.AfterAll;
import town.ada.page.BaseAccess;

public class DisponibilidadeStepDefinition extends BaseAccess {
    @Dado("que o usuário acesse a página")
    public void que_o_usuário_acesse_a_página() {
        setUp();
        assertEquals(getDriver().getCurrentUrl(), "https://thetown.com.br/pt/");
    }

    @Então("a página é carregada com o título {string}")
    public void a_página_é_carregada_com_o_título(String string) {
        assertEquals(getDriver().getTitle(), string);
    }

    @AfterAll
    public void fecharNavegacao() {
        tearDown();
    }

}
