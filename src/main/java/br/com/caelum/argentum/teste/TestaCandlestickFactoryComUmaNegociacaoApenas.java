package br.com.caelum.argentum.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComUmaNegociacaoApenas {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(49.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(53.3, 100, hoje);
		List<Negociacao> lista = new ArrayList<Negociacao>();
		lista.add(negociacao);
		lista.add(negociacao2);
		lista.add(negociacao3);
		lista.add(negociacao4);
		Candlestick candleParaData = new CandlestickFactory().constroiCandleParaData(hoje, lista);
		System.out.println(candleParaData);
	}
}
