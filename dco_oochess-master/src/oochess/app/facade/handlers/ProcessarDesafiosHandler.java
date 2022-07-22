package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oochess.app.dominio.CatalogoUtilizadores;
import oochess.app.dominio.Desafio;
import oochess.app.dominio.Utilizador;

/**
 * 
 * Handler para o processamento de desafios
 * 
 * @author Paulo Lopes - fc51974
 *
 */
public class ProcessarDesafiosHandler {

	private Utilizador u1;
	private Utilizador u2;
	private List<Desafio> desafiosPendentes = new ArrayList<Desafio>();
	private Desafio d;
	private CatalogoUtilizadores catUsers;

	public ProcessarDesafiosHandler(Object user, CatalogoUtilizadores catUtl) {
		this.u1 = (Utilizador) user;
		this.catUsers = catUtl;
	}

	/**
	 * 
	 * Esta função devolve uma Lista de Desafios que se encontram no estado de
	 * pendente
	 * 
	 * @return List<Desafio> em que o status se encontra em status pendente
	 */
	public List<Desafio> consultarDesafiosPendentes() {

		for (Desafio desafio : this.u1.getAllDesafios()) {
			if (desafio.getStatus().equals("Pendente")) {
				desafiosPendentes.add(desafio);
			}
		}

		return desafiosPendentes;
	}

	/**
	 * 
	 * @param codigo
	 * @param resposta
	 */
	public void respondeADesafio(String codigo, Boolean resposta) {
		if (resposta) {
			aceitarDesafio(codigo);
		} else {
			rejeitarDesafio(codigo);
		}
	}

	/**
	 * 
	 * @param codigo
	 */
	private void aceitarDesafio(String codigo) {
		for (Desafio desafio : desafiosPendentes) {
			if (desafio.getCodigo().equals(codigo)) {
				desafio.setStatus("Aceite");
			}

		}
	}

	// usar o padrao Adaptar para evitar a repetição de codigo no
	// aceitar/rejeitarDesafio

	/**
	 * 
	 * @param codigo
	 */
	private void rejeitarDesafio(String codigo) {

		for (Desafio desafio : desafiosPendentes) {
			if (desafio.getCodigo().equals(codigo)) {
				desafio.setStatus("Rejeitado");
				catUsers.getUtilizadorByDesafio(desafio, u1);
				d = desafio;
			}

		}
	}

	/**
	 * 
	 * @param datahora
	 */
	public void indicaNovaData(LocalDateTime datahora) {
		Desafio d1 = new Desafio(d.getCodigo(), datahora, "Pendente"); // Aqui vamos gerar um codigo novo
		u1.addDesafioEnviado(d1);
		u2.addDesafioRecebido(d1);
	}

}
