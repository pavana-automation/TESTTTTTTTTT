package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage{
	
	WebDriver driver;
	
	@FindBy(id = "tlogin")
	WebElement username;
	
	@FindBy(id = "tpwdsaved")
	WebElement password;
	
	@FindBy(id = "loginSubmitFrm")
	WebElement login1;
	
	@FindBy(id= "error-msg-ajax")
	WebElement errmsg;
	
	@FindBy(xpath= "//div[@class='large-duplicate-session']")
	WebElement duplicateScreen;
	//span[contains(text(),"My Activities")]
	@FindBy(xpath= "//input[@value='Yes']")
	WebElement yesBtn;
	
	 public loginPage(WebDriver driver)
	    {
	 
	        this.driver=driver;
	        PageFactory.initElements(driver,this); 
	             
	}
    //Set UserName
    public void  setUserName(String username){
    	this.username.sendKeys(username);
    }
    
    //Set Password
    public void setPassword(String password){
         this.password.sendKeys(password);
    }
    
  //Click on login button
    public boolean clickLogin(String username, String password){
    	this.username.sendKeys(username);
    	this.password.sendKeys(password);
    	this.login1.click();
    	try {
    	if(this.errmsg.isDisplayed())
    	{
    		return false;
    	}
    	else if(this.duplicateScreen.isDisplayed())
    	{
    		this.yesBtn.click();
    		return true;
    	}
    	}
    	catch(org.openqa.selenium.NoSuchElementException e)
    	{
    		System.out.println("EXCEPTION IS CAUGHT");
    	}
		return true;
		
    }
    
    public void clickLogout()
    {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("userProfileDropdown"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]"))).click();
    	//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]"))).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
    }
    		
}
