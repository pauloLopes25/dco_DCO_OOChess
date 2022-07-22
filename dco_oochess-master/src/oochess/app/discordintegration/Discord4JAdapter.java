package oochess.app.discordintegration;

import net.padroesfactory.Channel;
import net.padroesfactory.Discord4JMock;
import oochess.app.Configuration;

public class Discord4JAdapter implements IDiscordIntegration {

	@Override
	public void sendMessage(String username, String message) {

		Configuration config = new Configuration();
		String token = config.getString("DISCORD_TOKEN");
		Discord4JMock c = new Discord4JMock(token);
		Channel canalDoDestinatario = c.getChannel(username);
		canalDoDestinatario.sendMessage(message);
	}

}
