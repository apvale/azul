package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private static WebDriverWait wait;
	protected static WebDriver driver;
	
	public static void iniatilize(WebDriver driver){
		driver = new ChromeDriver();
		driver.get("http://app.contaazul.com.br");
		driver.manage().window().maximize();
	}

	public static WebElement waitForVisibility(WebDriver driver, By by, int waitTime) {
		wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	public static void closeBrowser(){
		driver.quit();
	}

	

}
