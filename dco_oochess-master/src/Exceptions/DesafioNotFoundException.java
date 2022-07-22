package Exceptions;

/**
 * 
 * Excepçao de desafio não encontrado
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class DesafioNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2235445932280091745L;

	public DesafioNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
