package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	 // declaration
    @FindBy(id = "email")
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    // initialization
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }


    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String usr, String pwd) {
        username.sendKeys(usr);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
   
    }


	public void loginMultipleAccounts(String userName2, String password2) {
		// TODO Auto-generated method stub
		username.sendKeys(userName2);
        password.sendKeys(password2);
        loginButton.click();
		
	}


}
