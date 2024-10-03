package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.ModalItemSteps;
import com.nttdata.steps.LoginMyStoreStep;
import com.nttdata.steps.MenSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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

    @And("Y agrego unidades del primer producto al carrito")
    public void yAgregoUnidadesDelPrimerProductoAlCarrito() throws InterruptedException {
        MenSteps item = new MenSteps(driver);
        item.SelectItem();
        Thread.sleep(1000);
        item.AmountItem();
        item.AddToCar();
        Thread.sleep(1000);
    }

    @Then("Entonces valido en el popup la confirmación del producto agregado")
    public void entoncesValidoEnElPopupLaConfirmacionDelProductoAgregado() {
        ModalItemSteps title = new ModalItemSteps(driver);
        Assertions.assertEquals("\uE876Producto añadido correctamente a su carrito de compra", title.getResponseItem());
    }

    @And("Y valido en el popup que el monto total sea {string}")
    public void yValidoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente(String total) {
        ModalItemSteps totalAmount = new ModalItemSteps(driver);
        Assertions.assertEquals(total, totalAmount.getTotalAmount());
    }

    @And("Cuando finalizo la compra")
    public void cuandoFinalizoLaCompra() throws InterruptedException {
        ModalItemSteps btnFInalizar = new ModalItemSteps(driver);
        btnFInalizar.clickFinalizar();
        Thread.sleep(3000);
    }

    @Then("Entonces valido el titulo de la pagina del carrito {string}")
    public void entoncesValidoElTituloDeLaPaginaDelCarrito(String title) {
        CarritoSteps titlePage = new CarritoSteps(driver);
        Assertions.assertEquals(title, titlePage.getTitleCarritoPage());
    }

    @And("Y vuelvo a validar el calculo de precios en el carrito sea {string}")
    public void yVuelvoAValidarElCalculoDePreciosEnElCarrito(String total) {
        CarritoSteps totalPage = new CarritoSteps(driver);
        Assertions.assertEquals(total, totalPage.getTotalAmount());
    }

    @Then("Cuando navego a la categoria {string} y espero que la automatización falle al no encontrar el menú")
    public void cuandoNavegoALaCategoria(String menu) {
        LoginMyStoreStep menuItem = new LoginMyStoreStep(driver);

        boolean menuFound = menuItem.buscarMenu(menu);
        assert !menuFound : "El menú '" + menu + "' no fue encontrado.";

        System.out.println("Navegando a la categoría: " + menu);
    }


}
