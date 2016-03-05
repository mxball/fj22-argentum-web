package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {
		double maximo = 0;
		double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE;
		double volume = 0;
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			double preco = negociacao.getPreco();
			if (preco < minimo) {
				minimo = preco;
			}
			if (preco > maximo) {
				maximo = preco;
			}
		}
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {
		Calendar data = negociacoes.get(0).getData();
		List<Negociacao> negociacoesDaData = new ArrayList<Negociacao>();
		List<Candlestick> candles = new ArrayList<Candlestick>();
		for (Negociacao n : negociacoes) {
			if (isMesmaData(data, n.getData())) {
				negociacoesDaData.add(n);
			} else {
				candles.add(constroiCandleParaData(data, negociacoesDaData));
				data = n.getData();
				negociacoesDaData.clear();
				negociacoesDaData.add(n);
			}
		}
		candles.add(constroiCandleParaData(data, negociacoesDaData));
		return candles;
	}

	private boolean isMesmaData(Calendar data, Calendar data2) {
		if (data.get(Calendar.DAY_OF_MONTH) == data2.get(Calendar.DAY_OF_MONTH)) {
			if (data.get(Calendar.MONTH) == data2.get(Calendar.MONTH)) {
				if (data.get(Calendar.YEAR) == data2.get(Calendar.YEAR)) {
					return true;
				}
			}
		}
		return false;
	}

}
