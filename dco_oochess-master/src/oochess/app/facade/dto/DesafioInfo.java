package oochess.app.facade.dto;

import java.time.LocalDateTime;

/**
 * 
 * Classe DTO para desafio
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class DesafioInfo {

	private LocalDateTime hora;
	private String status;

	public DesafioInfo(LocalDateTime hora, String status) {
		this.hora = hora;
		this.status = status;
	}

	public LocalDateTime getHora() {
		return this.hora;
	}

	public String getStatus() {
		return this.status;
	}

}
