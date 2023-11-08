package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ReadXLSdata;
import Pages.loginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class login {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest login;
	private static WebDriver driver = null;
	loginPage objLoginPage = new loginPage();
	
	@BeforeTest
	public void browser() {
		
	htmlReporter = new ExtentSparkReporter("extentReport.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	System.setProperty("webdriver.chrome.driver","C:\\Users\\jayanti.p.JAMOCHAHQ\\Downloads\\chromedriver-win64\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://10.10.10.250:6688/prohance/"); 
	}
	 
	 
	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="bvtdata")
	//@Test
	public void login(String username,String password) throws InterruptedException
	//public void login() throws InterruptedException
	 {
		
		//System.out.println("The username and password are :"+username +password);
		//objLoginPage.clickLogin(username, password, driver);
		login = extent.createTest("Login into the prohance", "Check whether login is successful");
		boolean response=objLoginPage.clickLogin(username,password, driver);
		if(response== true)
		{
		login.log(Status.INFO,"Login got successfull");
		login.pass("Logged into the application");
		}
		else
		{
		login.fail("Authentication is failed");
		}
		login.info("test completed"); 
		Assert.assertEquals(response, true);
	 }
	
	 @AfterTest
	 public void tearDown() {
		
		 extent.flush();
	 }

}
