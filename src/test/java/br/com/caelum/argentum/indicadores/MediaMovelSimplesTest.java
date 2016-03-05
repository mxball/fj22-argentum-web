package br.com.caelum.argentum.indicadores;

import org.junit.Assert;
import org.junit.Test;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandle() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		MediaMovelSimples mms = new MediaMovelSimples(new IndicadorFechamento());
		Assert.assertEquals(2.0, mms.calcula(serie, 2, 3), 0.00001);
		Assert.assertEquals(3.0, mms.calcula(serie, 3, 3), 0.00001);
		Assert.assertEquals(10.0/3, mms.calcula(serie, 4, 3), 0.00001);
		Assert.assertEquals(11.0/3, mms.calcula(serie, 5, 3), 0.00001);
		Assert.assertEquals(4.0, mms.calcula(serie, 6, 3), 0.00001);
		Assert.assertEquals(13.0/3, mms.calcula(serie, 7, 3), 0.00001);
		Assert.assertEquals(4.0, mms.calcula(serie, 8, 3), 0.00001);
	}

}
