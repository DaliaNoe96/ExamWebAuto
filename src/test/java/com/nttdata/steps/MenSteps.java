package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.nttdata.page.LoginMyStorePage.userInput;
import static com.nttdata.page.MenPage.*;

public class MenSteps {
    WebDriver driver;

    public MenSteps(WebDriver driver){
        this.driver =driver;
    }

    public void SelectItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(productItem));
        this.driver.findElement(productItem).click();
    }

    public void AmountItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(amountItem));
        this.driver.findElement(amountItem).click();
    }

    public void AddToCar(){
        this.driver.findElement(addToCarButton).click();
    }

}
