package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.FriendsPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;

public class ProfilePageTest extends BaseClass {
	LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    FriendsPage friendsPage;
    
	  public ProfilePageTest() {
	        super();
	    }
	  
	  @BeforeMethod
	    public void setUp() {
	        initialiazation();
	        loginPage = new LoginPage();
	        profilePage = new ProfilePage();
	        friendsPage = new FriendsPage();
	        homePage = loginPage.login(prop.getProperty("Emailaddress"), prop.getProperty("password"));
//	        profilePage = homePage.clickOnProfile();
  }
	  
	  @Test
	    public void verifyClickOnFriends() throws InterruptedException {
	    friendsPage = profilePage.clickOnFriends();
      Thread.sleep(5000);
      }
	  
	  @AfterMethod
	    public void tearDown() {
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        driver.quit();
	    }
}






