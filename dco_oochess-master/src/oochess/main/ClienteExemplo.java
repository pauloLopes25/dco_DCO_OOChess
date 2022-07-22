package oochess.main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import Exceptions.DesafioNotFoundException;
import Exceptions.InvalidTimeFrameException;
import Exceptions.TorneioNotFoundException;
import Exceptions.UtilizadorNotFoundException;
import oochess.app.OOChess;
import oochess.app.dominio.Desafio;
import oochess.app.dominio.Utilizador;
import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;
import oochess.app.facade.handlers.RegistarTorneioHandler;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

public class ClienteExemplo {

	private static String codigoDaPartida;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		OOChess p = new OOChess();

		RegistarUtilizadorHandler regHandler = p.getRegistarUtilizadorHandler();

		regHandler.registarUtilizador("Felismina", "hortadafcul", "fel1sgamer");
		regHandler.registarUtilizador("Silvino", "bardoc2", "s1lv1n0");
		regHandler.registarUtilizador("Maribel", "torredotombo", "SkubaPatr0l");

		// Para o UC5 vamos ter de ter aquele torneio criado para o verificar
		RegistarTorneioHandler regTorneioHandler = p.getRegistarTorneioHandler();
		regTorneioHandler.registarTorneio("Torneio Xadrez da CADI", LocalDateTime.MIN, LocalDateTime.MAX);

		// SSD - UC5
		Optional<Sessao> talvezSessao = p.autenticar("Silvino", "bardoc2");
		talvezSessao.ifPresent((Sessao s) -> {

			DesafiarHandler desh = s.getDesafioParaPartidaHandler();

			try {
				desh.indicaTorneio("Torneio Xadrez da CADI");
			} catch (TorneioNotFoundException e) {
				e.printStackTrace();
			}

			List<Utilizador> jogadoresEElos = desh.indicaDeltaElo(50);

			desh.indicaJogador("Maribel");
			try {
				codigoDaPartida = desh.indicaDetalhes(LocalDateTime.now().plusDays(1),
						"Amanha vou finalmente derrotar-te!");
			} catch (InvalidTimeFrameException e) {
				e.printStackTrace();
			}

		});

		// SSD - UC6

		talvezSessao.ifPresent((Sessao s) -> {
			RegistarResultadoHandler rh = s.getRegistarResultadoDePartida();
			rh.indicaPartidaEspontanea();
			try {
				rh.indicaDetalhes("Felismina", LocalDateTime.now());
			} catch (UtilizadorNotFoundException e) {
				e.printStackTrace();
			}
			double novoEloDoSilvino = rh.indicarResultado("DERROTA");
			System.out.println("[NovoElo] Silvino: " + novoEloDoSilvino);

		});

		// SSD - UC7
		Optional<Sessao> talvezOutraSessao = p.autenticar("Maribel", "torredotombo");
		talvezOutraSessao.ifPresent((Sessao s) -> {
			ProcessarDesafiosHandler pdh = s.getProcessarDesafios();
			boolean disponivel = true;
			for (Desafio d : pdh.consultarDesafiosPendentes()) {
				pdh.respondeADesafio(d.getCodigo(), disponivel);
				if (!disponivel) {
					pdh.indicaNovaData(LocalDateTime.now().plusDays(2));
				}
				disponivel = !disponivel;
			}
		});

		// SSD - UC6 (alt)

		talvezOutraSessao.ifPresent((Sessao s) -> {
			RegistarResultadoHandler rh = s.getRegistarResultadoDePartida();
			try {
				rh.indicaDesafio(codigoDaPartida);
			} catch (DesafioNotFoundException e) {
				e.printStackTrace();
			}
			double novoEloDaMaribel = rh.indicarResultado("VITORIA"); // Poderia ser também EMPATE
			System.out.println("[NovoElo] Maribel: " + novoEloDaMaribel);

		});
	}
}
