package br.com.caelum.argentum.modelo;

import org.junit.Test;

public class SerieTemporalTest {

	@Test(expected=IllegalStateException.class)
	public void SerieTemporalComListaNula() {
		SerieTemporal serie = new SerieTemporal(null);
	}
}
