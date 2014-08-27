package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;


public class NegociacaoTest {
	
	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao negociacao = new Negociacao(10, 5, calendar);
		
		//ainda que eu tente mudar a data para 20...
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMillisengundosEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		 Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		 Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		 

		  Negociacao negociacao = new Negociacao(40.0, 100, manha);
		  Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	
}
