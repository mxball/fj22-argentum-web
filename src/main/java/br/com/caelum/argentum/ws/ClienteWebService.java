package br.com.caelum.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;


public class ClienteWebService {

	private static String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes(){
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			InputStream stream = connection.getInputStream();
			return new LeitorXML().carrega(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}
	}
}
