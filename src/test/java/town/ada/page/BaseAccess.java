package town.ada.page;

import static town.ada.core.DriverFactory.*;


public class BaseAccess {
    public static void setUp() {
        System.out.println("Acessando página...");
        getDriver().get("https://thetown.com.br/pt/");
    }

    public static void tearDown() {
        System.out.println("Encerrando o driver...");
        killDriver();
    }


}
