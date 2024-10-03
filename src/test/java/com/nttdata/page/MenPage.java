package com.nttdata.page;

import org.openqa.selenium.By;

public class MenPage {
    public static By productItem = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
    public static By amountItem = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By addToCarButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
}
