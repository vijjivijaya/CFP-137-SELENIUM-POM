package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class ProfilePage extends BaseClass {
	
	   @FindBy(xpath ="//span[text()='Friends']")
	   WebElement Friends;
	
	   public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyProfilePagePageTitle() {
        return driver.getTitle();
    }
    public FriendsPage clickOnFriends() throws InterruptedException {
    	HomePage homePage = new HomePage();
    	homePage.clickOnProfile();
    	Thread.sleep(2000);
        Friends.click();
        return new FriendsPage();
        
    }
//    public ProfilePage clickOnFriends() {
//      friends.click();
//      return new FriendsPage();
//      
//  }
}

