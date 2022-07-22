package oochess.app.elostrategies;

/**
 * 
 * Estrategia de elo ByOne
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class ByOneStrategy {

	public double vitoria(double eloAtual) {
		return eloAtual + 1;
	}

	public double derrota(double eloAtual) {
		return eloAtual - 1;
	}

	public double empate(double eloAtual) {
		return eloAtual;
	}
}
