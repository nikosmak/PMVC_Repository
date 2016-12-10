package com.nlogic.domain.exception;

/**
 * The Interface IExceptionHandler.
 */
public interface IExceptionHandler {
	
	/**
	 * Handle.
	 *
	 * @param contextCode the context code
	 * @param errorCode the error code
	 * @param errorText the error text
	 * @param t the t
	 */
	public void handle(String contextCode, String errorCode, String errorText,
			Throwable t) throws EnrichableException;

	/**
	 * Raise.
	 *
	 * @param contextCode the context code
	 * @param errorCode the error code
	 * @param errorText the error text
	 */
	public void raise(String contextCode, String errorCode, String errorText) throws EnrichableException;
}
