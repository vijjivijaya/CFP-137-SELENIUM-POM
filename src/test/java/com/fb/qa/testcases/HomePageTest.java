package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;

public class HomePageTest extends BaseClass {
	
	 LoginPage loginPage;
	    HomePage homePage;
	    ProfilePage profilePage;

	    public HomePageTest() {
	        super();
	    }

	    @BeforeMethod
	    public void setUp() {
	        initialiazation();
	        loginPage = new LoginPage();
	        profilePage = new ProfilePage();
	        homePage = loginPage.login(prop.getProperty("Emailaddress"), prop.getProperty("password"));
	    }

//	    @Test
//	    public void verifyHomePageTitleTest() {
//	       String homePageTitle = homepage.verifyHomePagePageTitle();
//	        Assert.assertEquals(homePageTitle,"Kai Gazi | Facebook", homePageTitle);
//	    }

	    @Test
	    public void verifyClickOnProfile() throws InterruptedException {
	    profilePage = homePage.clickOnProfile();
        Thread.sleep(2000);
        
	    }
	    
//	    @Test
//	    public void verifyClickOnFriends() throws InterruptedException {
//	        profilePage = homepage.clickOnFriends();
//        Thread.sleep(2000);
//        
//	    }

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


