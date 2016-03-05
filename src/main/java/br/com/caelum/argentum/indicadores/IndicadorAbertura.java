package br.com.caelum.argentum.indicadores;


public class IndicadorAbertura implements Indicador{

	@Override
	public double calcula(SerieTemporal serie, int posicao, int intervalo) {
		return serie.getCandlestick(posicao).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
