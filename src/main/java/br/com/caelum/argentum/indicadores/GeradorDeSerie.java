package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double... valores) {
		List<Candlestick> serie = new ArrayList<Candlestick>();
		for (double d : valores) {
			serie.add(new Candlestick(d, d, d, d, d, Calendar.getInstance()));
			
		}
		return new SerieTemporal(serie);
	}

	
}
