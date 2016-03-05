package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if(maximo < minimo){
			throw new IllegalArgumentException("Valor máximo não pode ser menor que mínimo");
		}
		if(data == null){
			throw new IllegalArgumentException("Data não pode ser nula");
		}
		if(maximo < 0 || minimo < 0 || abertura < 0 || fechamento < 0 || volume < 0){
			throw new IllegalArgumentException("Nenhum valor pode ser negativo!");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data
				.getTime());
		return "[ Abertura:" + abertura + ", Fechamento: " + fechamento
				+ ", Mínima: " + minimo + ", Máxima: " + maximo + ", Volume: "
				+ volume + ", Data: " + dataFormatada + "]";
	}

}
