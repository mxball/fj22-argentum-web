package br.com.caelum.argentum.indicadores;


public interface Indicador {

	public double calcula(SerieTemporal serie, int posicao, int intervalo);
}
