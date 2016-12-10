/**
 * 
 */
package com.nlogic.domain.resources;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The Class ResourceLoader.
 *
 * @author nikosmak
 */
public class ResourceLoader {
	
	/**
	 * Instantiates a new resource loader.
	 */
	private ResourceLoader() {
	}

	/**
	 * The Class ResourceLoaderInstanceHolder.
	 */
	private static class ResourceLoaderInstanceHolder {
		
		/** The Constant INSTANCE. */
		public static final ResourceLoader INSTANCE = new ResourceLoader();
	}

	/**
	 * Gets the single instance of ResourceLoader.
	 *
	 * @return single instance of ResourceLoader
	 */
	public static ResourceLoader getInstance() {
		return ResourceLoaderInstanceHolder.INSTANCE;
	}
	
	/**
	 * Gets the resource value.
	 *
	 * @param resources the resources
	 * @return the resource value
	 */
	public String getResourceValue(String key, Resources resources){
		return getBundledString(key, resources.path()+resources.key());
	}
	
	public String getResourceValue(String key,String path){
		return getBundledString(key, path);
	}
	
	/**
	 * Gets the bundled string.
	 *
	 * @param id the id
	 * @param propertiesFileName the properties file name
	 * @return the bundled string
	 * @throws MissingResourceException the missing resource exception
	 */
	private String getBundledString(String id, String propertiesFileName) throws MissingResourceException {

		ResourceBundle bundle = ResourceBundle.getBundle(propertiesFileName);

		return bundle.getString(id);
	}

	/**
	 * Gets the parameterized bundled string.
	 *
	 * @param id the id
	 * @param arguments the arguments
	 * @param propertiesFileName the properties file name
	 * @return the parameterized bundled string
	 */
	private String getParameterizedBundledString(String id, Object[] arguments, String propertiesFileName) {

		ResourceBundle bundle = ResourceBundle.getBundle(propertiesFileName);

		MessageFormat formatter = new MessageFormat("");

		formatter.applyPattern(bundle.getString(id));
		return formatter.format(arguments);
	}

	
	
}
