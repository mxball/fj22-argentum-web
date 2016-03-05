package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.primefaces.component.calendar.CalendarUtils;

public class NegociacaoTest {

	@Test
	public void dataEhImutavel() {
		Calendar hoje = Calendar.getInstance();
		hoje.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, hoje);

		Calendar data = n.getData();
		data.set(Calendar.DAY_OF_MONTH, 20);
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegoiacaoComDataNula() throws Exception {
		new Negociacao(10, 100, null);
	}

	@Test
	public void testName() throws Exception {
		
		Calendar agora = Calendar.getInstance();
		Calendar maisTarde = Calendar.getInstance();
		Assert.assertEquals(agora, maisTarde);
	}

}
