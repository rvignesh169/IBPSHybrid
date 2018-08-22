package testexecute;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Keyword {
	static FirefoxDriver driver;
	static Properties prop;
	public  void loadproperties() throws IOException{
		prop = new Properties();
		File f = new File("D:\\TCD\\Sel\\IBPSHybrid\\src\\objectrepository\\or.properties");
		FileInputStream fs = new FileInputStream(f);
		
		prop.load(fs);
	}
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		
	}
	
	public void input(String testData, String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testData);
		
	}
	public void click(String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		try 
	    { 
			Alert alt = driver.switchTo().alert(); 
	        alt.accept();
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	      return;  
	    } 
	}

	public void navigate(String testData) {
	
		driver.get(testData);
		
	}
	public void titleverification(String testData){
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		assert actualtitle.equals(testData);
	}
	public boolean alertcheck(String testData, String objectName){
		driver.findElement(By.xpath(prop.getProperty(objectName))).isDisplayed();
		return true;
	}
	
	public void select(String testData, String objectName){
		Select sel = new Select(driver.findElement(By.xpath(prop.getProperty(objectName))));
		System.out.println(sel.getOptions());
		sel.selectByValue(testData);
	}
}
