package br.com.caelum.argentum.teste;

import java.util.Calendar;

import br.com.caelum.argentum.builder.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;

public class TestaCandleBuilder {

	public static void main(String[] args) {
		Candlestick candle = new CandleBuilder().comAbertura(40.0)
				.comFechamento(50.0).comMinino(39.5).comMaxima(55.2)
				.comVolume(500).comData(Calendar.getInstance()).getCandle();
		System.out.println(candle	);
	}
}
