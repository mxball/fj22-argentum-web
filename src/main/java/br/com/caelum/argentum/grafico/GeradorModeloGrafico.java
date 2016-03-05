package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.SerieTemporal;
import br.com.caelum.argentum.modelo.Candlestick;

public class GeradorModeloGrafico {

	private int fim;
	private int comeco;
	private SerieTemporal serie;
	private LineChartModel modeloGrafico;
	private OhlcChartModel ohlcChartModel;
	private String titulo;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim, String titulo) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.titulo = titulo;
		this.modeloGrafico = new LineChartModel();
		this.ohlcChartModel = new OhlcChartModel();
	}
	
	public void plota(Indicador indicador) {
		LineChartSeries chartSeries = new LineChartSeries(indicador.toString());
		for (int i = comeco; i <= fim; i++) {
			double valor = indicador.calcula(serie, i, 3);
			chartSeries.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSeries);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle(titulo);
	}
	
	public LineChartModel getModeloGrafico() {	
		return modeloGrafico;
	}
	
	public void plota(SerieTemporal serie) {
		for(int i=0; i <= serie.getUltimaPosicao();i++){
			Candlestick candle = serie.getCandlestick(i);
			ohlcChartModel.add(new OhlcChartSeries(i, candle.getAbertura(), candle.getMaximo(), candle.getMinimo(), candle.getFechamento()));
		}
		ohlcChartModel.setTitle("Candlestick");
        ohlcChartModel.setCandleStick(true);
        ohlcChartModel.getAxis(AxisType.X).setLabel("Sector");
        ohlcChartModel.getAxis(AxisType.Y).setLabel("Index Value");
	}
	
	public OhlcChartModel getOhlcChartModel() {
		return ohlcChartModel;
	}
}
