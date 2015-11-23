package contaazul.exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import contaazul.pages.ListaVendasPage;
import contaazul.pages.LoginPage;
import contaazul.pages.VendaPage;

public class Exercise3 {
	
	public WebDriver driver = new FirefoxDriver();
	public LoginPage loginpage = new LoginPage(driver);
	public ListaVendasPage listavendas = new ListaVendasPage(driver);
	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@Test
	public void acessarMenuVendas() throws InterruptedException {
		driver.get("http://app.contaazul.com.br");
		driver.manage().window().maximize();
		loginpage.login("ana.paula.vale@contaazul.com", "123456");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		listavendas.menuVendas();
		
	}
	
	@Test
	public void removerVenda() throws InterruptedException{
		listavendas.removerVenda();
	}
	
	@AfterClass
	public void fecharBrowser(){
		driver.close();
	}
	
}
