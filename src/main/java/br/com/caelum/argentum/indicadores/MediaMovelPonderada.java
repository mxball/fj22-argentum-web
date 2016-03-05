package br.com.caelum.argentum.indicadores;


public class MediaMovelPonderada implements Indicador{

	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador indicador) {
		this.outroIndicador = indicador;
	}
	
	@Override
	public double calcula(SerieTemporal serie, int posicao, int intervalo) {
		double soma = 0;
		int peso = intervalo;
		for (int i = posicao; i > posicao - intervalo; i--) {
			soma += outroIndicador.calcula(serie, i, intervalo) * peso;
			peso--;
		}
		return soma /6;
	}
	
	@Override
	public String toString() {
		return "MMP - " + outroIndicador.toString();
	}

}
