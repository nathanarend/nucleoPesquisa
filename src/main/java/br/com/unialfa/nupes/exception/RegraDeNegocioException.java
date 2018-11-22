package br.com.unialfa.nupes.exception;

import java.util.ResourceBundle;

import br.com.unialfa.nupes.configure.ConfigureMessages;
import br.com.unialfa.nupes.util.Util;

public class RegraDeNegocioException extends Exception {
	private static final long serialVsersionUID = 1L;

	private ResourceBundle configure() {
		return ConfigureMessages.returnBundleExceptionFile();
	}

	public RegraDeNegocioException(String message) {
		super(message);
	}

	public RegraDeNegocioException() {
		Util.showMessageError(getMessage());
	}

	@Override
	public String getMessage() {
		ResourceBundle resource = configure();
		String msg = resource.getString(getClass().getSimpleName());

		return msg;

	}

}
