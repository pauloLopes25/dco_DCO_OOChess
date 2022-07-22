package oochess.app.dominio;

import java.time.LocalDateTime;

/**
 * 
 * Classe do Desafio
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class Desafio {
	// Atributos
	private String codigo;
	private LocalDateTime data;
	private String status;
	private Partida partida;

	public Desafio(String codigo, LocalDateTime data, String status) {
		this.codigo = codigo;
		this.data = data;
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * 
	 * @param hora
	 */
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * 
	 * 
	 * @return partida
	 */
	public Partida getPartidaAssociada() {

		return this.partida;

	}

	/**
	 * 
	 * @param partida - Partida
	 */
	public void setPartidaAssociada(Partida partida) {

		this.partida = partida;

	}

}
