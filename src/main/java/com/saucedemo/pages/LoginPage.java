package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton ;

    public void enterUsername(String username) {
        sendTextToElement(usernameField, username);
        log.info("Sending text to Username field : " + usernameField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Sending text to password field : " + passwordField.toString());
    }
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Clicking on Login Button : " + loginButton.toString());
    }

    public void loginUsernamePassword (String username, String password){
        enterUsername(username);
        enterPassword(password);
    }
}
