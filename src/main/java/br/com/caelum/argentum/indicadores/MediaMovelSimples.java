package br.com.caelum.argentum.indicadores;



public class MediaMovelSimples implements Indicador{

	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador indicador) {
		this.outroIndicador = indicador;
	}
	
	@Override
	public double calcula(SerieTemporal serie, int posicao, int intervalo){
		double soma = 0.0;
		for (int i = posicao; i > posicao - intervalo; i--) {
			soma += outroIndicador.calcula(serie, i, intervalo);
		}
		return soma/3;
	}
	
	@Override
	public String toString() {
		return "MMS - " + outroIndicador.toString();
	}

}
