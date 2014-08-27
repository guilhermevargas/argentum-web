package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao> {
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {

		if (data == null)
			throw new IllegalArgumentException("data não pode ser nula");

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DAY_OF_MONTH) == outraData
				.get(Calendar.DAY_OF_MONTH)
				&& this.data.get(Calendar.MONTH) == outraData
						.get(Calendar.MONTH)
				&& this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

	public String toString() {
		return "Negociação: Preço " + preco + " Quantidade " + quantidade
				+ " Data "
				+ new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
	}

	@Override
	public int compareTo(Negociacao o) {
		return this.data.compareTo(o.getData());
	}
}
