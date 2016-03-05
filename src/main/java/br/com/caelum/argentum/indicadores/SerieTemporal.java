package br.com.caelum.argentum.indicadores;

import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;

public class SerieTemporal {

	private List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
		this.candles = candles;
	}
	
	public Candlestick getCandlestick(int i) {
		return this.candles.get(i);
	}

	public int getUltimaPosicao() {
		return this.candles.size() - 1;
	}
	
}
