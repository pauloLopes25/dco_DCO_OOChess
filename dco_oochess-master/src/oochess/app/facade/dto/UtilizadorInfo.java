package oochess.app.facade.dto;

/**
 * 
 * Classe DTO para utilizador
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class UtilizadorInfo {

	private String username;
	private int Elo;
	private String discordUsername;

	public UtilizadorInfo(String username, int elo, String discordUsername) {
		this.username = username;
		this.Elo = elo;
		this.discordUsername = discordUsername;
	}

	public String usernameToString() {
		return this.username;
	}

	public int getElo() {
		return this.Elo;
	}

	public String getDiscordUsername() {
		return this.discordUsername;
	}
}
