package com.nttdata.steps;

import com.nttdata.page.LoginMyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.ArrayList;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.nttdata.page.LoginMyStorePage.*;

public class LoginMyStoreStep {

    WebDriver driver;

    public LoginMyStoreStep(WebDriver driver){
        this.driver =driver;
    }

    public void escribirUsuario (String usuario) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        wait.until(ExpectedConditions.presenceOfElementLocated(userInput));

        WebElement usuarioInput = driver.findElement(userInput);
        usuarioInput.sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1) );
        wait.until(ExpectedConditions.presenceOfElementLocated(claveInput));

        WebElement claveInput = driver.findElement(LoginMyStorePage.claveInput);
        claveInput.sendKeys(clave);
    }

    public void clickSubmit() {
        this.driver.findElement(clickSubmit).click();
   //     boton.click();
    }

    public String getMessaggeError(){
        WebElement text = driver.findElement(messageError);
        return text.getText();
    }

    public void clickClothes(String clothes) {
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        wait.until(ExpectedConditions.presenceOfElementLocated(clickClothes));

        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
    }

    public void clickMs(String men) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(clickMs));

        this.driver.findElement(clickMs).click();
    }

    public boolean buscarMenu(String cate){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        wait.until(ExpectedConditions.presenceOfElementLocated(clickClothes));

        boolean found = false;

        List<WebElement> lista1= driver.findElements(menus);

        for (WebElement menuItem : lista1) {
            String lista = menuItem.getText();

            // Comparar el texto del elemento con 'cate'
            if (lista.equalsIgnoreCase(cate)) {
                menuItem.click(); // Hacer clic en el elemento encontrado
                return true; // Retornar true si se encontró y se hizo clic
            }
        }

        return false;
    }
 }
