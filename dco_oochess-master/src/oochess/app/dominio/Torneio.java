package oochess.app.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe do Torneio
 * 
 * @author Paulo Lopes – fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo – fc34921
 *
 */
public class Torneio {

	// Atributos

	private final String nomeTorneio;
	private final LocalDateTime inicio;
	private final LocalDateTime fim;
	List<PartidaTorneio> listaPartidasDeTorneio = new ArrayList<>();

	/**
	 * 
	 * Construtor
	 * 
	 * @param nomeTorneio
	 * @param inicio
	 * @param fim
	 */
	public Torneio(String nomeTorneio, LocalDateTime inicio, LocalDateTime fim) {
		this.nomeTorneio = nomeTorneio;
		this.inicio = inicio;
		this.fim = fim;
	}

	// Getters

	/**
	 * 
	 * Devolve o nome do torneio
	 * 
	 * @return nomeTorneio
	 */
	public String getNomeTorneio() {
		return nomeTorneio;
	}

	/**
	 * 
	 * Devolve a data de inicio do torneio
	 * 
	 * 
	 * @return data de inicio
	 */
	public LocalDateTime getInicio() {
		return inicio;
	}

	/**
	 * 
	 * Devolve a data de fim do torneio
	 * 
	 * @return data de fim
	 */
	public LocalDateTime getFim() {
		return fim;
	}

	public void addPartida(PartidaTorneio pT) {
		listaPartidasDeTorneio.add(pT);
	}

}
