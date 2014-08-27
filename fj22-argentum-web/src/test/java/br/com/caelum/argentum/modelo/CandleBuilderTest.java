package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected=IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios () {
		CandleBuilder builder = new CandleBuilder();
		builder.comAbertura(20.10);
		builder.comFechamento(50.3);
		builder.comMinimo(20.10);
		builder.comMaximo(50.3);
		builder.comData(Calendar.getInstance());
		
		Candle candle = builder.geraCandle();
	}

}
