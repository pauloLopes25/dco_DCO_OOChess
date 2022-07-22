package oochess.app.elostrategies;

/**
 * 
 * Estrategia de elo TenPercent
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class TenPercentStrategy {

	public double vitoria(double eloAtual, double eloOponente) {
		return eloAtual + (((eloAtual - eloOponente) * 0.10) + 5);

	}

	public double derrota(double eloAtual, double eloOponente) {
		return eloAtual - (((eloAtual - eloOponente) * 0.10) + 5);

	}

	public double empate(double eloAtual, double eloOponente) {
		if (eloAtual > eloOponente) {
			return (eloAtual - ((eloAtual - eloOponente) * 0.05));
		} else {
			return (eloAtual + ((eloAtual - eloOponente) * 0.05));
		}

	}

}
