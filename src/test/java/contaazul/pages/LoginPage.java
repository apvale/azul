package contaazul.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By usernameField = By.id("username_login");
	By passwordField = By.id("password_login");
	By loginButton = By.id("loginSubmit");
	By feedback = By.cssSelector("div.alert-error");
	
	public void login(String user, String password){
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public void validaMensagemErroLoginEmailIncorreto(){
		Assert.assertEquals(driver.findElement(feedback).getText(), "E-mail informado não existe ou a senha está incorreta!");
		
	}
	
	public void validaMensagemErroLoginSenhaIncorreta(){
		Assert.assertEquals(driver.findElement(feedback).getText(), "E-mail informado não existe ou a senha está incorreta!");
	}
	
	public void validaMensagemErroLoginEmailEmBranco() throws InterruptedException{
		Assert.assertEquals(driver.findElement(By.id("feedback")).getText(), "Por favor, informe seu e-mail!");
		
	}
	
	public void validaMensagemErroLoginSenhaEmBranco(){
		Assert.assertEquals(driver.findElement(feedback).getText(), "E-mail informado não existe ou a senha está incorreta!");
	}
	
	
	
	
	
}