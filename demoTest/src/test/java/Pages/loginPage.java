package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage{
	
	By username = By.id("tlogin");
	
	By password = By.id("tpwdsaved");
	
	By login1 = By.id("loginSubmitFrm");
	
	  //Set user name in textbox

    public void  setUserName(String strUserName,WebDriver driver){

    	System.out.println(strUserName);
        driver.findElement(username).sendKeys(strUserName);
        //this.setUserName(strUserName);

    }
    
    //Set password in password textbox
    public void setPassword(String strPassword,WebDriver driver){

         driver.findElement(password).sendKeys(strPassword);
         //this.setPassword(strPassword);

    }
    
  //Click on login button
    public boolean clickLogin(String strUserName, String strPassword, WebDriver driver) throws InterruptedException{
    	
    	driver.findElement(username).sendKeys(strUserName);
    	driver.findElement(password).sendKeys(strPassword);
    	driver.findElement(login1).click();
    	Thread.sleep(2000);
    	//boolean errormsg=driver.findElement(By.id("error-msg-ajax")).isDisplayed();
    	try {
    			driver.findElement(By.id("error-msg-ajax")).isDisplayed();
    			return false;
    	}catch(org.openqa.selenium.NoSuchElementException e)
    	{
    		try {
    		driver.findElement(By.xpath("//div[@class='large-duplicate-session']")).isDisplayed();
    		driver.findElement(By.xpath("//input[@value='Yes']")).click();
    		}catch(org.openqa.selenium.NoSuchElementException e1)
    		{
    			//driver.findElement(By.id("userProfileDropdown")).click();
    			//driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
    			return true;
    		}
    	}
    	//driver.findElement(By.id("userProfileDropdown")).click();
		//driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		return true;
	
    }
    
    		
}
