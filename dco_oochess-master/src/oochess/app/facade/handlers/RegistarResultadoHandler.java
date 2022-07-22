package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;

import Exceptions.DesafioNotFoundException;
import Exceptions.UtilizadorNotFoundException;
import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.dominio.Desafio;
import oochess.app.dominio.Partida;
import oochess.app.dominio.PartidaEspontanea;
import oochess.app.dominio.Utilizador;

/**
 * 
 * Handler para registar o resultado de uma partida
 * 
 * @author Guilherme Soares - fc51798
 *
 */
public class RegistarResultadoHandler {

	private Utilizador u1;
	private Utilizador u2;
	private Desafio d;
	private PartidaEspontanea pE1;
	private PartidaEspontanea pE2;
	CatalogoUtilizadores cat;

	/**
	 * 
	 * Construtor
	 * 
	 * @param u1
	 * @param cat
	 */
	public RegistarResultadoHandler(Utilizador u1, CatalogoUtilizadores cat) {
		this.u1 = u1;
		this.cat = cat;
	}

	/**
	 * 
	 * Metodo que dado um codigo de um desafio, vai buscar esse desafio e o seu
	 * oponente
	 * 
	 * 
	 * 
	 * @param codigoDesafio
	 * @throws DesafioNotFoundException
	 */
	public void indicaDesafio(String codigoDesafio) throws DesafioNotFoundException {

		d = u1.getDesafio(codigoDesafio);
		if (d == null) {
			throw new DesafioNotFoundException("Desafio nao encontrado");
		}
		u2 = cat.getUtilizadorByDesafio(d, u1);
	}

	/**
	 * 
	 * Metodo que vai devolver os ultimos 5 adversarios de partidas espontaneas do
	 * jogador atual
	 * 
	 * 
	 * @return Lista com os nomes dos ultimos 5 adversarios de partidas espontaneas
	 */
	public List<String> indicaPartidaEspontanea() {
		// Vou adicionar 5 partidas espontaneas so para testar
		u1.addPartidaEspontanea(new PartidaEspontanea("allezzz", LocalDateTime.now().minusWeeks(3)));
		u1.addPartidaEspontanea(new PartidaEspontanea("nome", LocalDateTime.now().minusWeeks(2)));
		u1.addPartidaEspontanea(new PartidaEspontanea("tinder", LocalDateTime.now().minusWeeks(1)));
		u1.addPartidaEspontanea(new PartidaEspontanea("todoPartido", LocalDateTime.now().minusDays(3)));
		u1.addPartidaEspontanea(new PartidaEspontanea("PARKOUR", LocalDateTime.now().minusWeeks(2)));
		return u1.getListaAdversarios();
	}

	/**
	 * Metodo que vai criar uma partida espontanea nova e registar o adversario e
	 * data/hora para ambos os jogadores
	 * 
	 * 
	 * @param username
	 * @param datahora
	 * @throws UtilizadorNotFoundException
	 */
	public void indicaDetalhes(String username, LocalDateTime datahora) throws UtilizadorNotFoundException {
		try {

			u2 = cat.getUtilizador(username);// Vai buscar o adversario

			pE2 = u2.createNewPartidaEspontanea(u1.getUsername(), datahora); // Cria outra partida para a lista de
																				// partidas
																				// do adversario
			pE1 = u1.createNewPartidaEspontanea(username, datahora);// Cria a partida espontanea para o utilizador a
																	// registar o resultado
		} catch (Exception e) {
			e.getMessage();
			throw new UtilizadorNotFoundException(username);
		}
	}

	/**
	 * 
	 * Metodo que vai registar um dado resultado da partida, atualizando e
	 * devolvendo o ELO do jogador que regista a partida
	 * 
	 * 
	 * @param resultado - String do resultado da partida
	 * @requires resultado == VITORIA || resultado == EMPATE || resultado == DERROTA
	 * @return ELO do jogador que está a registar o resultado
	 */
	public double indicarResultado(String resultado) {

		String resultadoContrario = "VITORIA";
		if (resultado.equals("VITORIA")) {
			resultadoContrario = "DERROTA";
		} else if (resultado.equals("EMPATE")) {
			resultadoContrario = "EMPATE";
		}

		if (d == null) {

			pE1.setResultado(resultado);
			pE2.setResultado(resultadoContrario);
			u1.addPartidaEspontanea(pE1);
			u2.addPartidaEspontanea(pE2);
			u1.updateELO(resultado, u2.getElo());
			u2.updateELO(resultadoContrario, u2.getElo());
		} else {

			Partida p = d.getPartidaAssociada();
			p.setResultado(resultado + " de " + u1.getUsername() + ": Partida disputada entre " + u1.getUsername()
					+ " e " + u2.getUsername());
			u1.updateELO(resultado, u2.getElo());
			u2.updateELO(resultado, u2.getElo());
		}
		return u1.getElo();
	}
}
