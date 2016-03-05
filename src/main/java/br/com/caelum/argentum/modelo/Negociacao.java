package br.com.caelum.argentum.modelo;

import java.io.Serializable;
import java.util.Calendar;

public final class Negociacao implements Serializable{

	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data não pode ser nula!");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public double getVolume(){
		return preco * quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
}
