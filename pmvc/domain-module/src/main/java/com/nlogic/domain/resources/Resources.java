package com.nlogic.domain.resources;

/**
 * The Enum Resources.
 */
public enum Resources {

	/** The DOMAIN. */
	DOMAIN("com.nlogic.domain.properties.", "domain"),
	HEALTH_UI("com.nlogic.pmvc.model.","health-ui");
	
	/** The path. */
	private String path = "";

	/** The key. */
	private String key = "";

	/**
	 * Instantiates a new resources.
	 *
	 * @param path the path
	 * @param key the key
	 */
	private Resources(String path, String key) {
		this.path = path;
		this.key = key;
	}

	/**
	 * Path.
	 *
	 * @return the string
	 */
	public String path() {
		return path;
	}

	/**
	 * Key.
	 *
	 * @return the string
	 */
	public String key() {
		return key;
	}

}
