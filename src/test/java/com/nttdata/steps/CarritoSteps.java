package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.nttdata.page.CarritoPage.*;

public class CarritoSteps {
    WebDriver driver;

    public CarritoSteps(WebDriver driver){
        this.driver =driver;
    }

    public String getTitleCarritoPage(){
        WebElement title = driver.findElement(titleCarrito);
        return title.getText();
    }

    public String getTotalAmount(){
        WebElement total = driver.findElement(totalAmount);
        return total.getText();
    }

}
