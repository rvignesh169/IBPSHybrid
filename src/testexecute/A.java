package testexecute;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A {
	public static WebDriver driver;
	static Properties prop;
public static void main(String[] args) throws IOException {
	File f = new File("D:\\TCD\\Sel\\IBPSHybrid\\src\\objectrepository\\or.properties");
	FileInputStream fs = new FileInputStream(f);
	File cf = new File("D:\\TCD\\Sel\\IBPSHybrid\\src\\objectrepository\\config.properties");
	FileInputStream cs = new FileInputStream(cf);
	Properties prop = new Properties();
	prop.load(fs);
	
	driver = new FirefoxDriver();
	driver.get("http://223.31.219.48//ippbs45jun18");
	driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("65654");
}
}
