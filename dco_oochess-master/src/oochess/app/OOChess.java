package oochess.app;

import java.util.Optional;

import oochess.app.dominio.CatalogoTorneios;
import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.dominio.Utilizador;
import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarTorneioHandler;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {

	CatalogoUtilizadores catUsers = new CatalogoUtilizadores();
	CatalogoTorneios catTor = new CatalogoTorneios();

	public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
		return new RegistarUtilizadorHandler(catUsers);
	}

	public RegistarTorneioHandler getRegistarTorneioHandler() {
		return new RegistarTorneioHandler(catTor);
	}

	/**
	 * Returns an optional Session representing the authenticated user.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Optional<Sessao> autenticar(String username, String password) {
		if (catUsers.hasUtilizador(username)) {
			Optional<Utilizador> correntUser = catUsers.tryLogin(username, password);
			return correntUser.map(u -> new Sessao(u, catTor, catUsers));
		} else
			return Optional.empty();
	}

}
