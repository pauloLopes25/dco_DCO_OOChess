package oochess.app.dominio;

/**
 * 
 * Classe da Partida de Torneio
 * 
 * @author Paulo Lopes – fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo – fc34921
 *
 */
public class PartidaTorneio extends Partida {

	// Atributos

	private Torneio t;

	/**
	 * 
	 * Construtor
	 * 
	 * @param t
	 */
	public PartidaTorneio(Torneio t) {
		super();
		this.setT(t);
	}

	public Torneio getT() {
		return t;
	}

	public void setT(Torneio t) {
		this.t = t;
	}

}
