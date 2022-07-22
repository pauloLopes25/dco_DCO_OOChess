package oochess.app.facade;

import oochess.app.dominio.CatalogoTorneios;
import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.dominio.Utilizador;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;

public class Sessao {

	private Utilizador utl;
	private CatalogoUtilizadores catUtl;
	private CatalogoTorneios catTorn;

	/**
	 * 
	 * @param utl
	 * @param CatUtl
	 * @param catTorn
	 */
	public Sessao(Utilizador utl, CatalogoTorneios catTorn, CatalogoUtilizadores catUtl) {
		this.utl = utl;
		this.catUtl = catUtl;
		this.catTorn = catTorn;
	}

	/**
	 * 
	 * @return
	 */
	public DesafiarHandler getDesafioParaPartidaHandler() {
		return new DesafiarHandler(catTorn, catUtl, utl);
	}

	/**
	 * 
	 * @return
	 */
	public RegistarResultadoHandler getRegistarResultadoDePartida() {
		return new RegistarResultadoHandler(utl, catUtl);
	}

	/**
	 * 
	 * @return
	 */
	public ProcessarDesafiosHandler getProcessarDesafios() {
		return new ProcessarDesafiosHandler(utl, catUtl);
	}
}
