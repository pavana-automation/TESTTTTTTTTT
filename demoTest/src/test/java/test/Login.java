package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.RetryAnalyzer;
import Pages.loginPage;
//import utilities.ReadXLSdata;

public class Login extends BaseTest {
	
	
	//ExtentTest login;
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//adminLogin4848.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	@Test(dataProvider="getData", groups= {"adminLogin4848"})
	public void login(HashMap<String, String> input) throws IOException, InterruptedException
	{
		driver=initializeDriver4848();
		loginPage.clickLogin(input.get("username"),input.get("password"));
		loginPage.clickLogout();
	}
	
	
}
