package br.com.caelum.argentum.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {
	
	public static void main(String[] args) {
		List<Negociacao> lista = Arrays.asList();
		Calendar hoje = Calendar.getInstance();
		Candlestick candle = new CandlestickFactory().constroiCandleParaData(hoje, lista);
		System.out.println(candle);
	}
}
