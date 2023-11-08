package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.loginPage;
import Pages.CUDPage;

public class EnableDiasbleChkInCud {
	
   // WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest chkpt1;
	private static WebDriver driver = null;
	SoftAssert softAssert = new SoftAssert();
    loginPage objLoginPage = new loginPage();
    CUDPage CUDPage = new CUDPage();
    
	@BeforeTest
	public void browser() {
	htmlReporter = new ExtentSparkReporter("extentReport.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	System.setProperty("webdriver.chrome.driver","C:\\Users\\jayanti.p.JAMOCHAHQ\\Downloads\\chromedriver-win64\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://10.10.10.250:4848/prohance/"); 
	
	}
	 
	 @Test()
	 public void enableDiasbleChkInCud() throws InterruptedException
	 {
		 	chkpt1 = extent.createTest("Login into the prohance", "Checking for User and Days Enable/Disable");
		 	chkpt1.info("User Login");
	        objLoginPage.clickLogin("pavana_admin", "1", driver);
	        chkpt1.pass("Login successfull");
	        CUDPage.clickQuickLink(driver);
	        CUDPage.clickCUDLink(driver);
	        Thread.sleep(2000);
			CUDPage.clickCustomizeReportLink(driver);
			Thread.sleep(2000);
			chkpt1.info("Select the values and chk for USER/DAYS ENABLE/DISABLE");
			CUDPage.setValueForCustReportViewFilter("UserGroupId", driver);
			CUDPage.setValueForCustomerDurationView("M", driver);
			softAssert.assertTrue(CUDPage.usersChkIsEnabled(driver) && CUDPage.daysChkIsEnabled(driver));
			chkpt1.pass("UserChkBx is enabled and DaysChkBx is enabled");
			CUDPage.setValueForCustomerDurationView("D", driver);
			softAssert.assertTrue(CUDPage.usersChkIsEnabled(driver) || CUDPage.daysChkIsEnabled(driver));
			chkpt1.pass("UserChkBx is enabled or DaysChkBx is enabled");
			CUDPage.setValueForCustReportViewFilter("TeamMemberId", driver);
			softAssert.assertFalse(CUDPage.usersChkIsEnabled(driver) && CUDPage.daysChkIsEnabled(driver));
			CUDPage.setValueForCustomerDurationView("M", driver);
			softAssert.assertTrue(CUDPage.usersChkIsEnabled(driver) || CUDPage.daysChkIsEnabled(driver));
			driver.quit();
	        
	       
	 }


}
