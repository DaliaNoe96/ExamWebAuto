package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginMyStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverWait;

import static com.nttdata.core.DriverManager.getDriver;

public class MyStoreStepDef {
    WebDriver driver;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");

    }
    @And("Y me logueo con mi usuario {string} y clave {string}")
    public void yMeLogueoConMiUsuarioYClave(String usuario, String clave) {
        LoginMyStoreStep login = new LoginMyStoreStep(driver);
        login.escribirUsuario(usuario);
        login.escribirClave(clave);

        login.clickSubmit();

        //Ingresar usuario registrado
        //campo usuario //input[@id="field-email"]
        //campo clave //input [@id="field-password"]


        //Darle clic en iniciar sesión
        //button iniciar sesión -> //button[@id="submit-login"]
    }

    @When("Cuando navego a la categoria {string} y subcategoria {string}")
    public void cuandoNavegoALaCategoriaYSubcategoria(String Clothes, String Men) throws InterruptedException {
        LoginMyStoreStep login = new LoginMyStoreStep(driver);
        login.clickClothes(Clothes);
        login.clickMs(Men);

        Thread.sleep(1000);

    }

    @And("Y agrego {int} unidades del primer producto al carrito")
    public void yAgregoUnidadesDelPrimerProductoAlCarrito(int arg0) {

    }

    @Then("Entonces valido en el popup la confirmación del producto agregado")
    public void entoncesValidoEnElPopupLaConfirmacionDelProductoAgregado() {
    }

    @And("Y valido en el popup que el monto total sea calculado correctamente")
    public void yValidoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
    }

    @And("Cuando finalizo la compra")
    public void cuandoFinalizoLaCompra() {
    }

    @Then("Entonces valido el titulo de la pagina del carrito")
    public void entoncesValidoElTituloDeLaPaginaDelCarrito() {
    }

    @And("Y vuelvo a validar el calculo de precios en el carrito")
    public void yVuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
