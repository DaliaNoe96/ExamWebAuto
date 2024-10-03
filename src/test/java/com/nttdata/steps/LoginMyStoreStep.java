package com.nttdata.steps;

import com.nttdata.page.LoginMyStorePage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Util;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.nttdata.page.LoginMyStorePage.*;

public class LoginMyStoreStep {

    WebDriver driver;

    public LoginMyStoreStep(WebDriver driver){
        this.driver =driver;
    }

    public void escribirUsuario (String usuario) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until(ExpectedConditions.presenceOfElementLocated(userInput));

        WebElement usuarioInput = driver.findElement(userInput);
        usuarioInput.sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until(ExpectedConditions.presenceOfElementLocated(claveInput));

        WebElement claveInput = driver.findElement(LoginMyStorePage.claveInput);
        claveInput.sendKeys(clave);
    }

    public void clickSubmit() {
        this.driver.findElement(clickSubmit).click();
   //     boton.click();
    }

    public void clickClothes(String clothes) {
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
   //     WebElement usuarioInput = driver.findElement(LoginMyStorePage.userInput);
        wait.until(ExpectedConditions.presenceOfElementLocated(clickClothes));
        //this.driver.findElement(LoginMyStorePage.clickClothes).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
//
        System.out.println("variable "+ clickMs);
    }

    public void clickMs(String men) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(clickMs));

        this.driver.findElement(clickMs).click();

    }
}
