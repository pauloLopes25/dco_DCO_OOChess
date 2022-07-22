package oochess.app.dominio;

/**
 * 
 * Classe da Partida
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class Partida {

	// Atributos
	private String resultado;

	/**
	 * 
	 * Construtos
	 * 
	 */
	public Partida() {
		this.resultado = null;
	}

	// Getters e Setters
	/**
	 * 
	 * Define o resultado
	 * 
	 * 
	 * @param resultado
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
/**
 * 
 * Devolve o resultado
 * 
 * @return resultado
 */
	public String getResultado() {
		return resultado;
	}

}
