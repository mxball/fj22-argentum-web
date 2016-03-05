package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CandlestickTest {

	
	private Calendar hoje;

	@Before
	public void setUp(){
		hoje = Calendar.getInstance();
	}

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 10, 10, 5, 100, hoje);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodeSerNula() throws Exception {
		new Candlestick(10, 10, 10, 10, 10, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoPodeTerValoresNegativos() throws Exception {
		new Candlestick(-1, 10, 10, 10, 10, hoje);
	}

}
