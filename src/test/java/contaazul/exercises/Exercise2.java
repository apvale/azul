package contaazul.exercises;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import contaazul.pages.LoginPage;
import contaazul.pages.VendaPage;

public class Exercise2 {
	
	public WebDriver driver = new FirefoxDriver();
	public LoginPage loginpage = new LoginPage(driver);
	public VendaPage venda = new VendaPage(driver);
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@Test
	public void acessarMenuVendas() throws InterruptedException {
		driver.get("http://app.contaazul.com.br");
		driver.manage().window().maximize();
		loginpage.login("ana.paula.vale@contaazul.com", "123456");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		venda.menuVendas();
		
	}
	@Test
	public void novaVenda() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnBlankslateNewProposal")));
		driver.findElement(By.id("btnBlankslateNewProposal")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("negotiationNegotiator")));
		venda.adicionaCliente();
		venda.adicionaLinhas();
		venda.adicionarNProdutos(5);
		venda.selecionarDesconto();
		venda.selecionarParcelas();
		venda.salvarVenda();
	} 
	
	@Test
	public void validaVenda(){
		venda.validaVenda();
	}
	
	
	
	/*@AfterSuite
	public void sair(){
		driver.quit();
	}*/
}