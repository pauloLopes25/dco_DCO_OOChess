package Exceptions;

/**
 * 
 * Excepçao de datas nao compativeis
 * 
 * @author Paulo Lopes - fc51974
 * @author Guilherme Soares - fc51798
 * @author Diogo Melo - fc34921
 *
 */
public class InvalidTimeFrameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5164210273635418278L;

	public InvalidTimeFrameException(String errorMessage) {
		super(errorMessage);
	}

}
