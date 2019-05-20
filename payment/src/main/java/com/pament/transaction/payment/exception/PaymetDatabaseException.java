package com.pament.transaction.payment.exception;

public class PaymetDatabaseException  extends Exception {

	/**
	 * Added Default Initial serial version id. Update the serial version when
	 * there is a change in this class
	 */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private transient String message;
	
	private Integer errorcode;

	/**
	 * Default Constructor.
	 */
	public PaymetDatabaseException() {
		super();
	}

	/**
	 * Parameterized Constructor to store the error or exception.
	 *
	 * @param message the message
	 */
	public PaymetDatabaseException(final String message) {
		super(message);
		this.message = message;
	}

	/**Returns error message. If no value is set, returns null
	 *@return message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * Setting cause for the persistence exception
	 *
	 * @param cause
	 *            reason for exception of Throwable type
	 */
	public PaymetDatabaseException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Setting persistence error message & cause for the exception
	 *
	 * @param message
	 *            message of String type
	 * @param cause
	 *            cause for exception,which is Throwable type
	 */

	public PaymetDatabaseException(final String message, final Throwable cause) {

		super(message, cause);
		this.message = message;
	}
	
	public PaymetDatabaseException(final String message, final Throwable cause,final Integer code) {

		super(message, cause);
		this.message = message;
		this.errorcode=code;
	}

	/**
	 * @return the errorcode
	 */
	public Integer getErrorcode() {
		return errorcode;
	}

	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}


