package oochess.app.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * 
 * Classe do Catalogo de Utilizadores
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class CatalogoUtilizadores {

	// Atributos
	HashMap<String, Utilizador> utilizadores = new HashMap<>();

	/**
	 * Adiciona um utilizador novo ao catalogo
	 * 
	 * 
	 * @param password
	 * @param username
	 */
	public void addUtilizador(String username, String password, String discordUsername, double elo) {

		if (!hasUtilizador(username)) {
			utilizadores.put(username, new Utilizador(username, password, discordUsername, elo));
		} else {
			System.out.println("O username ja existe"); // Devia ser exceção?
		}
	}

	/**
	 * 
	 * Verifica se o utilizador existe no catalogo
	 * 
	 * @param username
	 * @return
	 */
	public boolean hasUtilizador(String username) {
		return utilizadores.containsKey(username);
	}

	/**
	 * 
	 * Devolve um utilizador no catalogo, dado o seu username
	 * 
	 * @param username
	 * @return
	 */
	public Utilizador getUtilizador(String username) {
		return utilizadores.get(username);
	}

	/**
	 * 
	 * Tenta efetuar o login com o username a password correspondente
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Optional<Utilizador> tryLogin(String username, String password) {
		if (utilizadores.get(username).hasPassword(password)) {
			return Optional.of(utilizadores.get(username));
		} else
			return Optional.empty();
	}

	/**
	 * 
	 * Funcao que percorre todos os utilizadores excepto o utilizador dado e
	 * verifica a lista de desafios de cada 1 em busca de um dado desafio
	 * 
	 * 
	 * 
	 * @param d  - Desafio
	 * @param u1 - Utilizador adversario
	 * @return Utilizador
	 */
	public Utilizador getUtilizadorByDesafio(Desafio d, Utilizador u1) {

		for (Entry<String, Utilizador> entry : utilizadores.entrySet()) {
			Utilizador value = entry.getValue();
			if (value.getAllDesafios().contains(d) && !value.equals(u1)) {
				return value;
			}
		}
		return null; // This is not right
	}

	/**
	 * Devolve a lista de jogadores e respectivos ELOs que tenham uma diferenca
	 * absoluta entre o seu ELO e do jogador autenticado inferior ao delta
	 * 
	 * 
	 * @param delta
	 * @param u1    - Utilizador corrente
	 * @return - Lista de utilizadores compativeis
	 */
	public List<Utilizador> getListDeltaElo(int delta, Utilizador u1) {

		List<Utilizador> listaelos = new ArrayList<>();

		for (Entry<String, Utilizador> entry : utilizadores.entrySet()) {

			Utilizador value = entry.getValue();
			// estou aqui
			if (Math.abs(value.getElo() - u1.getElo()) <= delta) {
				listaelos.add(value);
			}
		}
		return listaelos;
	}

}
