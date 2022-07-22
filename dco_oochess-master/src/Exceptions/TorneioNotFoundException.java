package Exceptions;

/**
 * 
 * Excepçao de torneio não encontrado
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class TorneioNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3302854718322065955L;

	public TorneioNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
