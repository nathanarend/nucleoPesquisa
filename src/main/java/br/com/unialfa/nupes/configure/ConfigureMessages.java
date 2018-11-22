package br.com.unialfa.nupes.configure;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigureMessages {

	final static String CONF = "conf";

	final static String IDIOMA = "idioma";

	final static String PAIS = "pais";

	final static String EXCECAO = "excecao";

	private static ResourceBundle initialize() {
		ResourceBundle bundle = ResourceBundle.getBundle("conf");

		return bundle;
	}

	private static Locale returnLocale() {
		ResourceBundle bundle = initialize();
		Locale locale = new Locale(bundle.getString(IDIOMA), bundle.getString(PAIS));
		return locale;
	}

	private static String returnMessagesException() {
		ResourceBundle bundle = initialize();
		String arquivoExcecao = bundle.getString(EXCECAO);
		return arquivoExcecao;
	}

	public static ResourceBundle returnBundleExceptionFile() {
		Locale locale = returnLocale();
		String baseName = returnMessagesException();
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);

		return bundle;
	}
}
