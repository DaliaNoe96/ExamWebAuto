package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginMyStorePage {

    public static By userInput = By.xpath("//input[@id=\"field-email\"]");
    public static By claveInput = By.xpath("//input[@id=\"field-password\"]");
    public static By clickSubmit= By.xpath("//button[@id=\"submit-login\"]");
    public static By clickClothes= By.xpath("//*[@id=\"category-3\"]/a");
    public static By clickMs= By.cssSelector("#category-3 div ul li:nth-child(1) a");
    //"//button[@id=\"submit-login\"]"
}