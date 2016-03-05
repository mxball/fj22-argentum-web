package br.com.caelum.argentum.indicadores;


public class IndicadorFechamento implements Indicador{

	@Override
	public double calcula(SerieTemporal serie, int posicao, int intervalo) {
		return serie.getCandlestick(posicao).getFechamento();
	}
	
	@Override
	public String toString() {
		return "Fechamento";
	}

}
