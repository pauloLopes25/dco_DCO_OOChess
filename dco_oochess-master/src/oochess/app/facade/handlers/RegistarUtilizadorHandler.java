package oochess.app.facade.handlers;

import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.elostrategies.ELOStrategyFactory;
import oochess.app.elostrategies.IELOStrategiesAdapter;

/**
 * 
 * Handler para registar um utilizador
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class RegistarUtilizadorHandler {

	private CatalogoUtilizadores catUsers;

	public RegistarUtilizadorHandler(CatalogoUtilizadores catUsers) {
		this.catUsers = catUsers;
	}

	/**
	 * Regista um utilizador normal.
	 * 
	 * @param discordUsername
	 * @param Username
	 * @param Password
	 * @ensures existe um utilizador com esse username
	 */
	public void registarUtilizador(String username, String password, String discordUsername) {

		IELOStrategiesAdapter estrategia = ELOStrategyFactory.getINSTANCE().getStrategy();
		System.out.println(username + " : " + estrategia.setStarterElo());

		catUsers.addUtilizador(username, password, discordUsername, estrategia.setStarterElo());
	}

}
