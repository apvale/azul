package contaazul.exercises;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import contaazul.pages.LoginPage;

public class Exercise1 {
	
	private WebDriver driver = new ChromeDriver();
	public LoginPage loginpage = new LoginPage(driver);
	
	@Test
	public void acessarSite(){
		driver.manage().window().maximize();
		driver.get("https://app.contaazul.com.br/");		
		Assert.assertEquals(driver.getTitle(), "ContaAzul - A maneira mais simples de gerenciar sua pequena empresa");
	}
		
	@Test
	public void validaMensagemErroLoginEmailIncorreto(){
		loginpage.login("ana.paula.vale@contaazul.com.br", "123456");
		loginpage.validaMensagemErroLoginEmailIncorreto();
	}
	
	@Test
	public void validaMensagemErroLoginSenhaIncorreta(){
		loginpage.login("ana.paula.vale@contaazul.com", "1234");
		loginpage.validaMensagemErroLoginSenhaIncorreta();
	}
	
	@Test
	public void validaMensagemErroLoginEmailEmBranco() throws Exception {
		loginpage.login("", "123456");
		loginpage.validaMensagemErroLoginEmailEmBranco();
	}
	
	@Test
	public void validaMensagemErroLoginSenhaEmBranco(){
		loginpage.login("ana.paula.vale@contaazul.com", "");
		loginpage.validaMensagemErroLoginSenhaEmBranco();
	}

	@AfterClass
	public void fecharBrowser(){
		driver.close();
	}
}
