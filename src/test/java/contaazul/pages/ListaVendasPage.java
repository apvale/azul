package contaazul.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ListaVendasPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ListaVendasPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By vendaSelect = By.id("//input[@type='checkbox']");
	By menuAcoes = By.id("actionButtonNegotiation");
	By botaoExcluir = By.id("removeSelectedNegotiations");
	
	public void menuVendas(){
		
		Actions acoes = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath("//a[contains(text(),'Vendas')]"));
		acoes.moveToElement(menuHoverLink);
		acoes.perform();
		driver.findElement(By.xpath("//a[contains(@href, '#/vendas-e-orcamentos')]")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	public void removerVenda() throws InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.findElement(vendaSelect).click();
		driver.findElement(menuAcoes).click();
		driver.findElement(botaoExcluir).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.id("notification")).getText(), "Venda selecionada excluída com sucesso.");
	}
	
	
	

}
