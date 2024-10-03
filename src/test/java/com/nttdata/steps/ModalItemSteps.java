package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.page.ModalItemPage.*;

public class ModalItemSteps {
    WebDriver driver;

    public ModalItemSteps(WebDriver driver){
        this.driver =driver;
    }

    public String getResponseItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6) );
        wait.until(ExpectedConditions.presenceOfElementLocated(titleModalCarrito));

        WebElement ele = driver.findElement(titleModalCarrito);
        return ele.getText();
    }

    public String getTotalAmount(){
        WebElement totalHere = driver.findElement(total);
        return totalHere.getText();
    }

    public void clickFinalizar(){
        this.driver.findElement(btnFinalizar).click();
    }
}
