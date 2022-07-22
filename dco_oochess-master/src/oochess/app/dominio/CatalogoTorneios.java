package oochess.app.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe do Catalogo de Torneios
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class CatalogoTorneios {

	// Atributos
	List<Torneio> listaTorneios = new ArrayList<>();

	/**
	 * Adiciona um novo torneio
	 * 
	 * 
	 * @param nomeTorneio
	 * @param dataTorneioInicio
	 * @param dataTorneioFim
	 */
	public void addNovoTorneio(String nomeTorneio, LocalDateTime dataTorneioInicio, LocalDateTime dataTorneioFim) {

		if (!existeTorneio(nomeTorneio))
			listaTorneios.add(new Torneio(nomeTorneio, dataTorneioInicio, dataTorneioFim));

	}

	/**
	 * 
	 * 
	 * Verifica se um dado torneio ja se encontra no catalogo de torneios
	 * 
	 * @param nomeTorneio
	 * @return
	 */
	public boolean existeTorneio(String nomeTorneio) {
		for (Torneio torneio : listaTorneios) {
			if (torneio.getNomeTorneio().equals(nomeTorneio)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 
	 * Recebe uma string nomeTorneio e devolve um torneio ou null caso não encontre
	 * 
	 * @param nomeTorneio
	 * @return torneio
	 */
	public Torneio getTorneio(String nomeTorneio) {
		for (Torneio torneio : listaTorneios) {
			if (torneio.getNomeTorneio().equals(nomeTorneio)) {
				return torneio;
			}
		}
		return null;
	}
}
