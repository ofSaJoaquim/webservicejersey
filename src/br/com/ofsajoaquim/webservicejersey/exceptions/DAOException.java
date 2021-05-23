package br.com.ofsajoaquim.webservicejersey.exceptions;

public class DAOException extends RuntimeException{	

	private static final long serialVersionUID = 5046777875834296310L;
	private int code;

	public DAOException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	

}
