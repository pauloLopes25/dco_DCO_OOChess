package oochess.app.facade.handlers;

import java.time.LocalDateTime;

import oochess.app.dominio.CatalogoTorneios;

/**
 * 
 * Handler para registar um torneio
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class RegistarTorneioHandler {

	private CatalogoTorneios catTorn;

	public RegistarTorneioHandler(CatalogoTorneios catTorn) {
		this.catTorn = catTorn;
	}

	/**
	 * Regista um torneio.
	 * 
	 * @param nomeTorneio
	 * @param inicio
	 * @param fim
	 * @ensures existe um torneio com esse nome
	 */
	public void registarTorneio(String nomeTorneio, LocalDateTime inicio, LocalDateTime fim) {
		catTorn.addNovoTorneio(nomeTorneio, inicio, fim);
	}

}