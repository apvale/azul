package contaazul.exercises;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import contaazul.pages.LoginPage;
import contaazul.pages.ResumoVendaPage;
import contaazul.pages.VendaPage;

public class Exercise2 {
	
	public WebDriver driver = new FirefoxDriver();
	public LoginPage loginpage = new LoginPage(driver);
	public VendaPage venda = new VendaPage(driver);
	private ResumoVendaPage resumovenda = new ResumoVendaPage(driver);
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@BeforeClass
	public void acessarMenuVendas() throws InterruptedException {
		driver.get("http://app.contaazul.com.br");
		driver.manage().window().maximize();
		loginpage.login("ana.paula.vale@contaazul.com", "123456");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		venda.menuVendas();
		
	}
	@Test
	public void novaVenda() throws InterruptedException{
		
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
		
		resumovenda.validaNumeroVenda(4);
		resumovenda.validaNomeCliente("Ana");
		resumovenda.validaValorNegociado(11250.00);
		resumovenda.validaNumParcelas("Parcelado em 10x");
		resumovenda.validaValorDesconto(1250.00);
		resumovenda.validaValorTotalItens(12500.00);
		resumovenda.validaValorTotal(11250.00);
		
	}
	
	
	@AfterClass
	public void fecharBrowser(){
		driver.close();
	}
}