package oochess.app.dominio;

import java.time.LocalDateTime;

/**
 * 
 * Classe da Partida Espontanea
 * 
 * @author Paulo Lopes – fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo – fc34921
 *
 */
public class PartidaEspontanea {

	// Atributos

	private String nomeAdversario;
	private LocalDateTime data;
	private String resultado;

	// Construtores

	/**
	 * 
	 * Construtor
	 * 
	 * @param nomeAdversario
	 * @param data
	 * @param resultado
	 */
	public PartidaEspontanea(String nomeAdversario, LocalDateTime data, String resultado) {

		this.nomeAdversario = nomeAdversario;
		this.data = data;
		this.resultado = resultado;
	}

	/**
	 * 
	 * Construtor
	 * 
	 * @param nomeAdversario
	 * @param data
	 */
	public PartidaEspontanea(String nomeAdversario, LocalDateTime data) {

		this.nomeAdversario = nomeAdversario;
		this.data = data;
		this.resultado = null;
	}

	// Getters

	/**
	 * 
	 * Devolve o nome do adversario
	 * 
	 * 
	 * @return
	 */
	public String getNomeAdversario() {
		return nomeAdversario;
	}

	/**
	 * 
	 * Define o nome do adversario
	 * 
	 * @param nomeAdversario
	 */
	public void setNomeAdversario(String nomeAdversario) {
		this.nomeAdversario = nomeAdversario;
	}

	/**
	 * 
	 * Devolve a data da partida
	 * 
	 * @return data
	 */
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * 
	 * Define a data de uma partida
	 * 
	 * 
	 * @param data
	 */
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * 
	 * Devolve o resultado da partida
	 * 
	 * 
	 * @return
	 */
	public String getResultado() {
		return resultado;
	}

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

}
