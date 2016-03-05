package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandlestickFactoryTest {

	private Calendar hoje;
	private List<Negociacao> negociacoes;

	@Before
	public void setUp() {
		hoje = Calendar.getInstance();
	}

	@Test
	public void sequenciaSimplesDeNegociacao() {
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

		negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3,
				negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void semNegociacaoGeraCandleComZeros() throws Exception {
		negociacoes = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void negociacoesEmOrdemCrescenteDeValor() throws Exception {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(41.5, 100, hoje);
		Negociacao negociacao3 = new Negociacao(42.5, 100, hoje);
		Negociacao negociacao4 = new Negociacao(43.5, 100, hoje);
		Negociacao negociacao5 = new Negociacao(44.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(44.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(44.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(21250.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void negociacoesEmOrdemDecrescenteDeValor() throws Exception {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao5 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao4 = new Negociacao(41.5, 100, hoje);
		Negociacao negociacao3 = new Negociacao(42.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(43.5, 100, hoje);
		Negociacao negociacao1 = new Negociacao(44.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(44.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(44.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(21250.0, candle.getVolume(), 0.00001);
	}
}
