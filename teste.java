package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Teste {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://app.contaazul.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE() throws Exception {
    driver.get(baseUrl + "/#/vendas-e-orcamentos");
    driver.findElement(By.id("negotiationSelected0")).click();
    driver.findElement(By.id("saleNumber0")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Editar')])[3]")).click();
    driver.findElement(By.linkText("Vendas e Orçamentos")).click();
    driver.findElement(By.id("negotiationSelected0")).click();
    driver.findElement(By.id("actionsSale")).click();
    driver.findElement(By.cssSelector("span.icon-left")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Confirma a exclusão da venda selecionada[\\s\\S]$"));
    try {
      assertEquals("Venda selecionada excluída com sucesso.", driver.findElement(By.cssSelector("div.container-message")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Vendas e Orçamentos")).click();
    driver.findElement(By.id("btnBlankslateNewProposal")).click();
    driver.findElement(By.id("negotiationNegotiator")).click();
    driver.findElement(By.id("negotiationNegotiator")).clear();
    driver.findElement(By.id("negotiationNegotiator")).sendKeys("Ana");
    driver.findElement(By.id("negotiationItem0")).click();
    driver.findElement(By.id("negotiationItem0")).clear();
    driver.findElement(By.id("negotiationItem0")).sendKeys("P");
    driver.findElement(By.id("negotiationItemQuantity0")).click();
    driver.findElement(By.id("negotiationItemQuantity0")).clear();
    driver.findElement(By.id("negotiationItemQuantity0")).sendKeys("50");
    driver.findElement(By.id("negotiationItemPrice0")).clear();
    driver.findElement(By.id("negotiationItemPrice0")).sendKeys("50");
    driver.findElement(By.id("appContent")).click();
    driver.findElement(By.id("saveNegotiation")).click();
    driver.findElement(By.linkText("Vendas e Orçamentos")).click();
    driver.findElement(By.id("negotiationSelected0")).click();
    driver.findElement(By.id("actionsSale")).click();
    driver.findElement(By.cssSelector("span.icon-left")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Confirma a exclusão da venda selecionada[\\s\\S]$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
