package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {
	private final List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		if (candles == null)
			throw new IllegalStateException("Serie temporal não pode ser nula");
		
		this.candles = candles;
	}
	
	public Candle getCandle(int i) {
		return this.candles.get(i);
	}

	public int getUltimaPosicao() {
		return candles.size() -1;
	}
}
