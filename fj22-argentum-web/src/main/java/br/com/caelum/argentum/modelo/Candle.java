package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Candle {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candle(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {

		if (minimo > maximo)
			throw new IllegalArgumentException(
					"Mínimo não pode ser maior que máximo");

		if (data == null)
			throw new IllegalArgumentException("Data não pode ser nule");
		
		if (abertura < 0 || fechamento < 0) {
			throw new IllegalArgumentException("Valor não pode ser negativo");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	@Override
	public String toString() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data
				.getTime());
		return "Abertura " + this.abertura + " Fechemento " + this.fechamento
				+ " Mínima " + this.minimo + " Máxima " + this.maximo
				+ " Data " + dataFormatada;
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
}
