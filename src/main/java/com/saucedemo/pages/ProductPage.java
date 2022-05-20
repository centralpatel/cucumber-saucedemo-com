package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement priceHighToLow;
    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    WebElement lowPriceProduct;
    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement highPriceProduct;
    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCart;

    public void selectPriceHighToLow() {
        selectByVisibleTextFromDropDown(priceHighToLow, "Price (high to low)");
        log.info("Selecting text from filter drop down : " + priceHighToLow.toString());
    }

    public void selectLowPriceProduct() {
        clickOnElement(lowPriceProduct);
        log.info("Adding Lowest price product to basket : " + lowPriceProduct.toString());
    }

    public void selectHighPriceProduct() {
        clickOnElement(highPriceProduct);
        log.info("Adding highest price product to basket : " + highPriceProduct.toString());
    }
    public void addLowAndPricePriceProduct (){
        selectLowPriceProduct();
        selectHighPriceProduct();
    }
    public void clickOnShoppingCart (){
        clickOnElement(shoppingCart);
        log.info("Clicking on shopping cart : " + shoppingCart.toString());
    }


}
