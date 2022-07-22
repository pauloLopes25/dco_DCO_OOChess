package Exceptions;

/**
 * 
 * Excepçao de utilizador nao encontrado
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class UtilizadorNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String username;

	public UtilizadorNotFoundException(String username) {
		this.username = username;
	}

	public String getMessage() {
		return "O utilizador " + username + "nao foi encontrado";
	}

}
