package oochess.app.elostrategies;

/**
 * 
 * Interface para uma estrategia de elo
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public interface IELOStrategiesAdapter {
	/**
	 * Define o ELO inicial
	 * 
	 * 
	 * @return elo inicial
	 */
	double setStarterElo();

	/**
	 * 
	 * Altera o elo consoante uma vitoria
	 * 
	 * 
	 * @param eloAtual
	 * @param eloOponente
	 * @return elo calculado
	 */
	double win(double eloAtual, double eloOponente);

	/**
	 * 
	 * Altera o elo consoante uma derrota
	 * 
	 * 
	 * @param eloAtual
	 * @param eloOponente
	 * @return elo calculado
	 */
	double loss(double eloAtual, double eloOponente);

	/**
	 * 
	 * Altera o elo consoante um empate
	 * 
	 * 
	 * @param eloAtual
	 * @param eloOponente
	 * @return elo calculado
	 */
	double draw(double eloAtual, double eloOponente);
}
