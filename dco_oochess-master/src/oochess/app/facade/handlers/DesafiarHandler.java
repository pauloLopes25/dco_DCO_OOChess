package oochess.app.facade.handlers;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Exceptions.InvalidTimeFrameException;
import Exceptions.TorneioNotFoundException;
import oochess.app.discordintegration.Discord4JAdapter;
import oochess.app.dominio.CatalogoTorneios;
import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.dominio.Desafio;
import oochess.app.dominio.PartidaAmigavel;
import oochess.app.dominio.PartidaTorneio;
import oochess.app.dominio.Torneio;
import oochess.app.dominio.Utilizador;

/**
 * 
 * Handler que permite a um utilizador desafiar outro para uma partida
 * 
 * @author Diogo Melo - fc34921
 *
 */
public class DesafiarHandler {

	private CatalogoTorneios cattorneios;
	private CatalogoUtilizadores catutilizadores;
	private Torneio tor;
	private Utilizador u1;
	private Utilizador u2;
	private List<Utilizador> utilizadoresInDelta;

	/**
	 * 
	 * Construtor
	 * 
	 * @param cattorneios
	 * @param catutilizadores
	 * @param u1
	 */
	
	public DesafiarHandler(CatalogoTorneios cattorneios, CatalogoUtilizadores catutilizadores, Utilizador u1) {
		this.cattorneios = cattorneios;
		this.catutilizadores = catutilizadores;
		this.u1 = u1;
		utilizadoresInDelta = new ArrayList<>();
	}
	/**
	 * 
	 * Metodo que permite ao utilizador desafiador indicar o torneio a que a partida vai pertencer
	 * e dado um nome de torneio, vai buscar esse torneio
	 * 
	 * 
	 * @param nome
	 * @throws TorneioNotFoundException
	 */

	public void indicaTorneio(String nome) throws TorneioNotFoundException {

		tor = cattorneios.getTorneio(nome);
		if (tor == null) {
			throw new TorneioNotFoundException("Torneio nao existe");
		}
	// fica a validaçao abaixo comentada, porque nao temos nenhum caso de uso eu que se inscreva
	// utilizadores (neste caso o utilizador 1) num torneio	
	//		if (!u1.getTorneiosInscritos().contains(tor) && tor =! null)) {
	//			throw new TorneioNotFoundException("Utilizador nao inscrito no torneio");
	//		}

	}
	/**
	 * 
	 * Metodo que permite ao utilizador indicar ao sistema o delta de ELO que é aceitável 
	 * e dado um delta de eLO, vai buscar uma lista do tipo Utilizador
	 * contendo utilizadores dentro desse delta (intervalo) de Elo
	 * 
	 * 
	 * @param delta
	 * @return utilizadoresInDelta
	 */

	public List<Utilizador> indicaDeltaElo(int delta) {
		utilizadoresInDelta = catutilizadores.getListDeltaElo(delta, u1);
		return utilizadoresInDelta;
	}

	/**
	 * 
	 * Metodo que permite ao utilizador indicar ao sistema o username do jogador 
	 * com quer estabelecer uma partida e dado um nome de Jogador a desafiar, 
	 * vai buscar esse Jogador (Utilizador desafiado u2)
	 * 
	 * 
	 * @param nome
	 * 
	 */
	public void indicaJogador(String nome) {
		for (Utilizador user : utilizadoresInDelta) {
			if (user.getUsername().equals(nome))
				u2 = user;
		}
		// fica a validaçao abaixo comentada, porque nao temos nenhum caso de uso em que inscreva
		// utilizadores (neste caso o utilizador 2) num torneio	
		//		if (!u2.getTorneiosInscritos().contains(tor) && tor =! null) {
		//			throw new TorneioNotFoundException("Utilizador nao inscrito no torneio");
		//		}
		
	}
	/**
	 * Metodo que permite ao utilizador indicar detalhes (a hora e data da partida), 
	 * bem como uma mensagem opcional
	 * 
	 * @param datahora
	 * @param msg
	 * @return codigo do desafio criado
	 * @throws InvalidTimeFrameException
	 */
	public String indicaDetalhes(LocalDateTime datahora, String msg) throws InvalidTimeFrameException {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		Random rand = new Random();
		int length = (rand.nextInt(10)) + 1;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}

		Desafio d = new Desafio(sb.toString(), datahora, "Pendente");
		if (tor == null) {
			PartidaAmigavel pA = new PartidaAmigavel();
			d.setPartidaAssociada(pA);
			u1.addDesafioEnviado(d);
			u2.addDesafioRecebido(d);
		} else {
			if (LocalDateTime.now().isBefore(datahora) && datahora.isAfter(tor.getInicio())
					&& datahora.isBefore(tor.getFim())) {
				PartidaTorneio pT = new PartidaTorneio(tor);
				d.setPartidaAssociada(pT);
				tor.addPartida(pT);
				u1.addDesafioEnviado(d);
				u2.addDesafioRecebido(d);
			} else {
				throw new InvalidTimeFrameException("Data invalida");
			}
		}
		Discord4JAdapter da = new Discord4JAdapter();
		da.sendMessage(u2.getUsername(), "O jogador " + u1.getUsername() + " convidou-o para uma partida de xadrez em "
				+ d.getData() + " : " + msg);

		return d.getCodigo();
	}
}