package oochess.app.elostrategies;

import java.lang.reflect.InvocationTargetException;

import oochess.app.Configuration;

/**
 * 
 * Factory de uma dada classe ELOStrategies no ficheiro preferences
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class ELOStrategyFactory {

	private static ELOStrategyFactory INSTANCE = null;

	private ELOStrategyFactory() {
	}

	public static ELOStrategyFactory getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new ELOStrategyFactory();
		}
		return INSTANCE;
	}

	public IELOStrategiesAdapter getStrategy() {
		Configuration config = new Configuration();
		String strategy = config.getINSTANCE().getString("ELO_STRATEGY");

		try {

			@SuppressWarnings("unchecked")
			Class<IELOStrategiesAdapter> eloStrategyClass = (Class<IELOStrategiesAdapter>) Class.forName(strategy);
			return eloStrategyClass.getDeclaredConstructor().newInstance();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
				| IllegalArgumentException | InvocationTargetException | SecurityException e) {
			return new ByOne();
		}

	}

}
