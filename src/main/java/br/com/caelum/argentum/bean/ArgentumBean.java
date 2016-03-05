package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.OhlcChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.indicadores.SerieTemporal;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{

	private List<Negociacao> negociacoes = new ArrayList<Negociacao>();
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;
	private OhlcChartModel ohlcChartModel;
	private String titulo;
	
	public ArgentumBean() {
		this.negociacoes  = new ClienteWebService().getNegociacoes();
		geraGrafico();
	}

	public void geraGrafico() {
		List<Candlestick> candles = new CandlestickFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorModeloGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao(), titulo);
		geradorModeloGrafico.plota(defineIndicador());
		this.modeloGrafico = geradorModeloGrafico.getModeloGrafico();
		geradorModeloGrafico.plota(serie);
		ohlcChartModel = geradorModeloGrafico.getOhlcChartModel();
	}

	public Indicador defineIndicador(){
		if (nomeMedia == null || nomeIndicadorBase == null) {
			return new MediaMovelSimples(new IndicadorFechamento());
		}
		try {
			String pacote = "br.com.caelum.argentum.indicadores.";
			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();
			
			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> constructor = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) constructor.newInstance(indicadorBase);
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
	
	public OhlcChartModel getOhlcChartModel() {
		return ohlcChartModel;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}

}
