package contaazul.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResumoVendaPage {

	
	private WebDriver driver;
	
	public ResumoVendaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By numeroVenda = By.id("negotiationNumberLabel");
	By valorNegociado = By.id("negotiationTotalValueLabel");
	By nomeCliente = By.id("negotiationNegotiatiorName");
	By numeroParcelas = By.id("negotiationInstallment");
	By valorItens = By.id("negotiationTotalItemsLabel");
	By valorDesconto = By.id("negotiationTotalDiscountLabel");
	By valorFinal = By.id("negotiationTotalLiqueidLabel");
	
	
	public void validaNumeroVenda(int numero){
		Assert.assertEquals(driver.findElement(numeroVenda).getText(), numero);
	}
	
	public void validaValorNegociado(double valor){
		Assert.assertEquals(driver.findElement(valorNegociado).getText(), valor);
	}
	
	public void validaNomeCliente(String nome){
		Assert.assertEquals(driver.findElement(nomeCliente).getText(), nome);
	}
	
	public void validaNumParcelas(String numeroParc){
		Assert.assertEquals(driver.findElement(numeroParcelas).getText(), numeroParc);
	}
	
	public void validaValorTotalItens(double valorTotalItens){
		Assert.assertEquals(driver.findElement(valorItens).getText(), valorTotalItens);
	}
	
	public void validaValorDesconto(double valorDescontoTotal){
		Assert.assertEquals(driver.findElement(valorDesconto).getText(), valorDescontoTotal);
	}
	
	public void validaValorTotal(double valorTotal){
		Assert.assertEquals(driver.findElement(valorFinal).getText(), valorTotal);
	}
	
	
	
}
