package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import Pages.loginPage;
import Pages.CUDPage;

public class EnableDiasbleChkInCud extends BaseTest{
	
	//ExtentTest chkpt1;
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
    CUDPage cudPage = new CUDPage(BaseTest.driver);
    
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//adminLogin6688.json");
		return new Object[][] {{data.get(0)}};
		
	}
    
	 
	 @Test(dataProvider="getData", groups= {"adminLogin6688"})
	 public void enableDiasbleChkInCud(HashMap<String, String> input) throws InterruptedException
	 {
		 	//chkpt1 = extent.createTest("Login into the prohance", "Checking for User and Days Enable/Disable");
		 	//chkpt1.info("User Login");
		 	driver=initializeDriver6688();
		 	loginPage.clickLogin(input.get("username"),input.get("password"));
	        //chkpt1.pass("Login successfull");
	        cudPage.clickQuickLink();
	        cudPage.clickCUDLink();
	        Thread.sleep(2000);
	        cudPage.clickCustomizeReportLink();
			Thread.sleep(2000);
			
			//chkpt1.info("Select the values and chk for USER/DAYS ENABLE/DISABLE");
			cudPage.setValueForCustReportViewFilter("UserGroupId");
			cudPage.setValueForCustomerDurationView("M");
			Assert.assertTrue(cudPage.usersChkIsEnabled() && cudPage.daysChkIsEnabled());
			//chkpt1.pass("UserChkBx is enabled and DaysChkBx is enabled");
			cudPage.setValueForCustomerDurationView("D");
			Assert.assertTrue(cudPage.usersChkIsEnabled() || cudPage.daysChkIsEnabled());
			//chkpt1.pass("UserChkBx is enabled or DaysChkBx is enabled");
			cudPage.setValueForCustReportViewFilter("TeamMemberId");
			Assert.assertFalse(cudPage.usersChkIsEnabled() && cudPage.daysChkIsEnabled());
			cudPage.setValueForCustomerDurationView("M");
			Assert.assertTrue(cudPage.usersChkIsEnabled() || cudPage.daysChkIsEnabled());
	        //chkpt1.info("Test case completed");
	       
	 }


}
