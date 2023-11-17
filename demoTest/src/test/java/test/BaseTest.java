package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.CUDPage;
import Pages.loginPage;
//import jdk.internal.org.jline.utils.Log;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = new ChromeDriver();
	
	public loginPage  loginPage;
	public CUDPage cudPage;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver initializeDriver6688() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayanti.p.JAMOCHAHQ\\Downloads\\chromedriver-win64\\chromedriver.exe");
	//driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://10.10.10.250:6688/prohance/"); 
	return driver;
	}

	public WebDriver initializeDriver4848() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayanti.p.JAMOCHAHQ\\Downloads\\chromedriver-win64\\chromedriver.exe");
	//driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://10.10.10.250:4848/prohance/"); 
	return driver;
	}
	 
	@AfterTest
	public void teardown() {
		// Log.info("Tests are ending!");
		//extent.flush();
		driver.quit();
	}
	
	public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		File file = new File(destpath);
		FileUtils.copyFile(source, file);
		return destpath;
		
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException
	{
		//reading json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		//String to Hashmap 
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
		
	}
}
