package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	
	private boolean vAbertura;
	private boolean vFechamento;
	private boolean vMinimo;
	private boolean vMaximo;
	private boolean vVolume;
	private boolean vData;
	
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		vAbertura = true;
		return this;
	}
	
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		vFechamento = true;
		return this;
	}
	
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		vMinimo = true;
		return this;
	}
	
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		vMaximo = true;
		return this;
	}
	
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		vVolume = true;
		return this;
	}
	
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		vData = true;
		return this;
	}
	
	public Candle geraCandle() {
		if (vAbertura && vFechamento && vMaximo && vMinimo && vVolume && vData)
			return new Candle(abertura, fechamento, minimo, maximo, volume, data);
		
		throw new IllegalStateException("Não foram inicializados todos os atributos");
	}
}
