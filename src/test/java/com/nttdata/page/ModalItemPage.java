package com.nttdata.page;

import org.openqa.selenium.By;

public class ModalItemPage {
    public static By titleModalCarrito = By.xpath("//*[@id=\"myModalLabel\"]");
    public static By total = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By btnFinalizar = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}
