package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.UtilityClass;

public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
    HomePage homepage;
    String sheetName = "Sheet2";
    Logger  log = Logger.getLogger(LoginPageTest.class);
    
    public LoginPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialiazation();
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.verifyPageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up",title);
    }

//    @Test(priority = 2)
//    public void fbLogoImageTest() {
//        boolean logo = loginPage.validateFbImage();
//        Assert.assertTrue(logo);
//    }

//    @Test(priority = 2)
//    public void loginTest() {
//        homepage = loginPage.login(prop.getProperty("Emailaddress"), prop.getProperty("password"));
//    }
    
    @DataProvider
	public Object[][] getLoginTestData() {
		Object data [][] = UtilityClass.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginTestData")
	public void multipleLoginTest(String userName,String password) throws InterruptedException {
		loginPage.loginMultipleAccounts(userName,password);
		Thread.sleep(3000);
	    log.info("login successful with username: " +userName);
	}
    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        log.info("browser is closed");
    }	

}
