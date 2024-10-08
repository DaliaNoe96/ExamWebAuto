package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginMyStoreStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

public class LogInvStepDef {
    WebDriver driver;

    @Given("me encuentro en la página de la tienda")
    public void meEncuentroEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");
    }

    @When("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        LoginMyStoreStep login = new LoginMyStoreStep(driver);
        login.escribirUsuario(usuario);
        login.escribirClave(clave);

        login.clickSubmit();

    }

    @Then("Entonces espero que la automatización falle con el mensaje {string}")
    public void entoncesEsperoQueLaAutomatizacionFalleAlNoLlegarALaPantallaPrincipal(String messageError) throws InterruptedException {
        Thread.sleep(2000);
        LoginMyStoreStep mensaje = new LoginMyStoreStep(driver);
        Assertions.assertEquals(messageError, mensaje.getMessaggeError());
    }


}
