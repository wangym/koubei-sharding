/**
 * 
 */
package com.koubei.sharding.client.exception;

/**
 * @author xuanyin
 * 
 */
public final class ShardingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6480612383716276638L;

	/**
	 * 
	 */
	public ShardingException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public ShardingException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public ShardingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public ShardingException(Throwable cause) {
		super(cause);
	}
}
