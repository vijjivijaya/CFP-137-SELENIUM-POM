package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Vij')]")
    WebElement userProfile;
	WebElement friends;
	

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public String verifyHomePagePageTitle() {
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {
        userProfile.click();
       return new ProfilePage();
        
    }
    
//    public ProfilePage clickOnFriends() {
//        friends.click();
//        return new FriendsPage();
//        
//    }
}
	


