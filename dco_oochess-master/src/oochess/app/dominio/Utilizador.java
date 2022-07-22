package oochess.app.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oochess.app.elostrategies.ELOStrategyFactory;
import oochess.app.elostrategies.IELOStrategiesAdapter;

/**
 * 
 * Classe do Utiizador
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */

public class Utilizador {

	// Atributos

	String username;
	String discordUsername;
	double elo;
	String password;
	List<Desafio> desafiosRecebidos = new ArrayList<>();
	List<Desafio> desafiosEnviados = new ArrayList<>();
	List<PartidaEspontanea> listaPartidasEspontaneas = new ArrayList<>();
	List<Torneio> listaTorneiosInscritos = new ArrayList<>();

	/**
	 * 
	 * Construtor
	 * 
	 * @param username
	 * @param elo
	 * @param password
	 */
	public Utilizador(String username, String password, String discordUsername, double elo) {
		this.username = username;
		this.elo = elo;
		this.password = password;
		this.discordUsername = discordUsername;
	}

	// Getters e Setters

	/**
	 * Devolve o username do nosso utilizado
	 * 
	 * @return username do Utilizador
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Talvez nao seja necessário verificar dps
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Devolve o Elo de um Utilizador da App
	 * 
	 * @return um Elo pertencente de um Utilizador
	 */
	public double getElo() {
		return elo;
	}

	/**
	 * 
	 * Faz o update do ELO consoante um resultado e o seu adversario...
	 * 
	 * @param resultado
	 */
	public void updateELO(String resultado, double eloOponente) {
		IELOStrategiesAdapter estrategia = ELOStrategyFactory.getINSTANCE().getStrategy();
		switch (resultado) {
		case "VITORIA":
			elo = estrategia.win(elo, eloOponente);
			break;
		case "DERROTA":
			elo = estrategia.loss(elo, eloOponente);
			break;
		default:
			elo = estrategia.draw(elo, eloOponente);
		}
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean hasPassword(String password) {
		return this.password.contentEquals(password);
	}

	/**
	 * 
	 * Devolve os desafios recebidos pelo utilizador
	 * 
	 * @return Desafios Recebidos
	 */
	public List<Desafio> getDesafiosRecebidos() {
		return this.desafiosRecebidos;
	}

	/**
	 * Devolve os desafios enviados pelo utilizador
	 * 
	 * @return Desafios Enviados
	 */
	public List<Desafio> getDesafiosEnviados() {
		return this.desafiosEnviados;
	}

	/**
	 * 
	 * Devolve todos os desafios em que o jogador esteve envolvido
	 * 
	 * 
	 * @return Lista de todos os desafios do user
	 */
	public List<Desafio> getAllDesafios() {
		List<Desafio> allDesafios = new ArrayList<>();
		for (Desafio d : desafiosRecebidos) {
			allDesafios.add(d);
		}
		for (Desafio d : desafiosEnviados) {
			allDesafios.add(d);
		}
		return allDesafios;
	}

	/**
	 * 
	 * Devolve os torneios em que o utilizador esta inscrito
	 * 
	 * @return Lista de Torneios
	 */
	public List<Torneio> getTorneiosInscritos() {
		return listaTorneiosInscritos;
	}

	/**
	 * 
	 * Procura um desafio por codigo na lista de desafios do utilizador
	 * 
	 * 
	 * @param codigo - String identificadora do desafio
	 * @return Desafio
	 */
	public Desafio getDesafio(String codigo) {

		for (Desafio d1 : desafiosEnviados) {
			if (d1.getCodigo().equals(codigo)) {
				return d1;
			}
		}
		for (Desafio d1 : desafiosRecebidos) {
			if (d1.getCodigo().equals(codigo)) {
				return d1;
			}
		}
		return null;
	}

	/**
	 * Atualiza o estado de um desafio para um dado estado
	 * 
	 * 
	 * @param codigo
	 * @param a
	 */
	public void updateDesafioStatus(String codigo, String a) {
		for (Desafio d1 : desafiosRecebidos) {
			if (d1.getCodigo().equals(codigo)) {
				d1.setStatus(a);
			}
		}
		for (Desafio d1 : desafiosEnviados) {
			if (d1.getCodigo().equals(codigo)) {
				d1.setStatus(a);
			}
		}
	}

	/**
	 * Devolve todas as partidas espontaneas disputadas pelo utilizador
	 * 
	 * 
	 * @return
	 */
	public List<PartidaEspontanea> getListaPartidasEspontaneas() {
		return listaPartidasEspontaneas;
	}

	/**
	 * Adiciona uma partida espontanea disputada � lista de partidas espontaneas
	 * do utilizador
	 * 
	 * @param p - Partida Espontanea
	 */
	public void addPartidaEspontanea(PartidaEspontanea p) {
		listaPartidasEspontaneas.add(p);
	}

	/**
	 * Adiciona um dado desafio na lista de desafios recebidos
	 * 
	 * @param d - Desafio a adicionar
	 */
	public void addDesafioRecebido(Desafio d) {
		desafiosRecebidos.add(d);
	}

	/**
	 * Adiciona um dado desafio na lista de desafios enviados
	 * 
	 * @param d - Desafio a adicionar
	 */
	public void addDesafioEnviado(Desafio d) {
		desafiosEnviados.add(d);
	}

	/**
	 * 
	 * Metodo que devolve nomes dos ultimos 5 oponentes de partidas espontaneas
	 * disputadas pelo utilizador
	 * 
	 * 
	 * @return Lista de strings com usernames
	 */
	public List<String> getListaAdversarios() {

		int i = this.listaPartidasEspontaneas.size() - 1;
		List<String> adversarios = new ArrayList<>();

		while (i != -1 || i > listaPartidasEspontaneas.size() - 4) {

			adversarios.add(listaPartidasEspontaneas.get(i).getNomeAdversario());
			i--;
		}
		return adversarios;
	}

	/**
	 * Cria uma nova partida espontanea
	 * 
	 * 
	 * @param nome - Nome do adversario
	 * @param data - Data e hora da partida
	 * @return Partida criada
	 */
	public PartidaEspontanea createNewPartidaEspontanea(String nome, LocalDateTime data) {
		return new PartidaEspontanea(nome, data);
	}

}
