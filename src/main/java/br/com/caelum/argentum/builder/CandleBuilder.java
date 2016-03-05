package br.com.caelum.argentum.builder;

import java.util.Calendar;

import br.com.caelum.argentum.modelo.Candlestick;

public class CandleBuilder {

	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinino(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaxima(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}
	
	public Candlestick getCandle(){
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
