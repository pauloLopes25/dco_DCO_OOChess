package oochess.app.discordintegration;

import java.lang.reflect.InvocationTargetException;

import oochess.app.Configuration;

/**
 * 
 * Factory de uma dada classe para adaptar o discord no ficheiro preferences
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class DiscordAdapterFactory {

	private static DiscordAdapterFactory INSTANCE = null;

	private DiscordAdapterFactory() {
	}

	public static DiscordAdapterFactory getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new DiscordAdapterFactory();
		}
		return INSTANCE;
	}

	public IDiscordIntegration getStrategy() {
		Configuration config = new Configuration();
		String discord = config.getINSTANCE().getString("DISCORD_CLASS");

		try {

			@SuppressWarnings("unchecked")
			Class<IDiscordIntegration> discordClass = (Class<IDiscordIntegration>) Class.forName(discord);
			return discordClass.getDeclaredConstructor().newInstance();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
				| IllegalArgumentException | InvocationTargetException | SecurityException e) {
			return new Discord4JAdapter();
		}

	}

}
