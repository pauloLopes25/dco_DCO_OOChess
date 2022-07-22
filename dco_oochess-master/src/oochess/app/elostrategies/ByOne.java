package oochess.app.elostrategies;

/**
 * 
 * Adaptador da interface IELOStrategiesAdapter para estrategia ByOne
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class ByOne implements IELOStrategiesAdapter {

	private ByOneStrategy strategy = new ByOneStrategy();

	@Override
	public double setStarterElo() {
		return 5;
	}

	@Override
	public double win(double eloAtual, double eloOponente) {
		return strategy.vitoria(eloAtual);
	}

	@Override
	public double loss(double eloAtual, double eloOponente) {
		return strategy.derrota(eloAtual);
	}

	public double draw(double eloAtual, double eloOponente) {
		return strategy.empate(eloAtual);
	}

}
