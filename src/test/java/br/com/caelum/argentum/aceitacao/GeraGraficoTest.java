package br.com.caelum.argentum.aceitacao;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeraGraficoTest {

	private static final String url = "http://localhost:8080/fj22-argentum-web/index.xhtml";
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void teardDown(){
		driver.close();
	}
	
	@Test
	public void testeAogerarGraficoSemTituloUmaMensagemEhApresentada() {
		driver.navigate().to(url);
		
		WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));
		titulo.sendKeys("");
		titulo.submit();
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		boolean mensagem = pageSource.contains("Titulo inválido");
		
		Assert.assertTrue(mensagem);
	}
}
