package contaazul.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thoughtworks.selenium.Wait;

public class VendaPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public VendaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By nomeCliente = By.id("negotiationNegotiator");
	By porcentagemDesconto = By.cssSelector(".chosen-single");
	By desconto = By.id("negotiationDiscountRate");
	By descontoSelect = By.id("negotiationDiscountMeasureUnit_chosen");
	By salvarVendaButton = By.id("saveNegotiation");
	By novaVenda = By.id("btnBlankslateNewProposal");
	By numeroVenda = By.id("negotiationNumber");
	
	public void menuVendas(){
		wait =  new WebDriverWait(driver, 10);
		Actions acoes = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath("//a[contains(text(),'Vendas')]"));
		acoes.moveToElement(menuHoverLink);
		acoes.perform();
		driver.findElement(By.xpath("//a[contains(@href, '#/vendas-e-orcamentos')]")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnBlankslateNewProposal")));
	}
	
	public void adicionaCliente() throws InterruptedException{
		
		driver.findElement(nomeCliente).click();
	    driver.findElement(nomeCliente).clear();
	    driver.findElement(nomeCliente).sendKeys("Ana");
	    driver.findElement(nomeCliente).click();
	    driver.findElement(numeroVenda).clear();
	    driver.findElement(numeroVenda).sendKeys("4");
	    
	}
	
	public void adicionaLinhas(){
		driver.findElement(By.id("newNegotiationItem")).click();
		driver.findElement(By.id("newNegotiationItem")).click();
	}
	
	public void adicionarNProdutos(int num) throws InterruptedException {
		
		for (int i = 0; i < num; i++) {		
			
			driver.findElement(By.id("negotiationItem" + i)).sendKeys("Produto" + i);
			Thread.sleep(50);
			driver.findElement(By.id("negotiationItemDescription" + i)).sendKeys("Detalhe" + i);
			Thread.sleep(50);
			driver.findElement(By.id("negotiationItemQuantity" + i)).clear();
			Thread.sleep(50);
			driver.findElement(By.id("negotiationItemQuantity" + i)).sendKeys("50");
			driver.findElement(By.id("negotiationItemPrice" + i)).sendKeys("50");
			Thread.sleep(60);
		
		}
	}
	
	public void selecionarDesconto() throws InterruptedException{
		driver.findElement(desconto).click();
		driver.findElement(desconto).clear();
		driver.findElement(desconto).sendKeys("10");
		driver.findElement(descontoSelect).click();
		driver.findElement(By.xpath("//div[@class='chosen-drop']/ul/li[contains(.,'%')]")).click();
	}
		
	public void selecionarParcelas() {
		
		driver.findElement(By.id("negotiationInstallmentQuantity_chosen")).click();
		driver.findElement(By.xpath("//div[@class='chosen-drop']/ul/li[contains(.,'10x')]")).click();
		
	}
	
	public void salvarVenda(){
		driver.findElement(salvarVendaButton).click();
		Assert.assertEquals(driver.findElement(By.id("notification")).getText(), "A venda nº 4 foi criada com sucesso.");
	}
	
		
		
}

