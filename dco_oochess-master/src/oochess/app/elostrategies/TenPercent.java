package oochess.app.elostrategies;

/**
 * 
 * Adaptador da interface IELOStrategiesAdapter para estrategia TenPercent
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class TenPercent implements IELOStrategiesAdapter {

	private TenPercentStrategy strategy = new TenPercentStrategy();

	@Override
	public double setStarterElo() {
		return 50;
	}

	@Override
	public double win(double eloAtual, double eloOponente) {
		return strategy.vitoria(eloAtual, eloOponente);

	}

	@Override
	public double loss(double eloAtual, double eloOponente) {
		return strategy.derrota(eloAtual, eloOponente);
	}

	@Override
	public double draw(double eloAtual, double eloOponente) {
		return strategy.empate(eloAtual, eloOponente);
	}

}
