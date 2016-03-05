package br.com.caelum.argentum.indicadores;

import org.junit.Assert;
import org.junit.Test;

public class MediaPonderadaMovelTest {

	@Test
	public void sequenciaSimplesDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6);
		MediaMovelPonderada mpm = new MediaMovelPonderada(new IndicadorFechamento());
		Assert.assertEquals(14.0/6, mpm.calcula(serie, 2, 3), 0.00001);
		Assert.assertEquals(20.0/6, mpm.calcula(serie, 3, 3), 0.00001);
		Assert.assertEquals(26.0/6, mpm.calcula(serie, 4, 3), 0.00001);
		Assert.assertEquals(32.0/6, mpm.calcula(serie, 5, 3), 0.00001);
	}

}
