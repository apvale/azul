package contaazul.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.apache.commons.collections.functors.ForClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Utils;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	WebElement menuVendas = driver.findElement(By.xpath("//a[contains(text(),'Vendas e Orçamentos')]")); 
	
	
	public void menuVendas(){
		//Utils.waitForVisibility(driver, menuVendas, 10);
		driver.findElement(By.id("liVendas"));
		Actions action = new Actions(driver);
		action.moveToElement(menuVendas).perform();
		menuVendas.click();
		
		//Utils.waitForVisibility(driver, By.id("showSaleList"), 10);
		//Assert.assertEquals(driver.findElement(By.id("showSaleList")).getText(), "Vendas e Orçamentos");
	}
	
	
}
