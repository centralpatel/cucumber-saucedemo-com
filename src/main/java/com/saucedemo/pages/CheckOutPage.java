package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstnameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastnameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipPostalCodeField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement thankYouMessage;


    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
        log.info("Clicking on checkout button : " + checkOutButton.toString());
    }

    public void enterFirstname (String firstname) {
        sendTextToElement(firstnameField, firstname);
        log.info("Sending Text to firstname field : " + firstnameField.toString());
    }

    public void enterLastname (String lastname) {
        sendTextToElement(lastnameField, lastname);
        log.info("Sending Text to lastname field : " + lastnameField.toString());
    }

    public void enterZipPostalCode (String zipPostalCode) {
        sendTextToElement(zipPostalCodeField, zipPostalCode);
        log.info("Sending Text to zipPostalCode field : " + zipPostalCode.toString());
    }

    public void enterInfoDetails(String firstname, String lastName, String zipPostalCode) {
        enterFirstname(firstname);
        enterLastname(lastName);
        enterZipPostalCode(zipPostalCode);
    }
    public void clickOnContinue (){
        clickOnElement(continueButton);
        log.info("Clicking on continue button : " + continueButton.toString());
    }
    public void clickOnFinish (){
        clickOnElement(finishButton);
        log.info("Clicking on finish button : " + finishButton.toString());
    }

    public String getThankYouMessage (){
        String message = getTextFromElement(thankYouMessage);
        log.info("Getting text from : " + thankYouMessage.toString());
        return message;
    }

}
