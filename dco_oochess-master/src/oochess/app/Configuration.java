package oochess.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * Configuracao de leitura de um ficheiro properties
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class Configuration {

	private Configuration INSTANCE = null;
	private Properties properties = new Properties();

	public Configuration() {
		try {
			FileInputStream file = new FileInputStream("src/preferences.properties");
			properties.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Configuration getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new Configuration();
		}
		return INSTANCE;
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}
}
