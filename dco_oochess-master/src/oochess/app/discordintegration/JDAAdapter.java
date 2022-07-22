package oochess.app.discordintegration;

import com.chavetasfechadas.JDAMock;
import com.chavetasfechadas.JDAMockBuilder;

import oochess.app.Configuration;

public class JDAAdapter implements IDiscordIntegration {

	@Override
	public void sendMessage(String username, String message) {

		Configuration config = new Configuration();
		String token = config.getString("DISCORD_TOKEN");

		JDAMock c = new JDAMockBuilder().createDefault(token).disableCache(true).setCompression(true)
				.setActivity("Playing chess").build();
		c.sendMessage(username, message);
	}

}
