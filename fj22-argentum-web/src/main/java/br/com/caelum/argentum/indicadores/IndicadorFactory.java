package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	private final String nomeMedia;
	private final String nomeIndicadorBase;

	public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicadorBase = nomeIndicadorBase;	
	}
	
	public Indicador defineInficador() {
		if (nomeIndicadorBase == null || nomeMedia == null)
			return new MediaMovelSimples(new IndicadorFechamento());
		
		String pacote = "br.com.caelum.argentum.indicadores.";

		try {
			Class<?> classeIndicadorBase = Class.forName(pacote
					+ nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase
					.newInstance();
			
			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> constructorMedia = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) constructorMedia.newInstance(indicadorBase);
			
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar o gráfico");
		}
	}

}
