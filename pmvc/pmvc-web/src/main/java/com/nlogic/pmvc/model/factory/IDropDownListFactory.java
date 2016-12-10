/**
 * 
 */
package com.nlogic.pmvc.model.factory;

import java.util.Map;

import javax.faces.model.SelectItem;

/**
 * The Interface {@link IDropDownListFactory}.
 *
 * @author nikosmak
 */
public interface IDropDownListFactory extends IFactory<SelectItem> {

	/**
	 * Adds the to map.
	 *
	 * @param map the map
	 * @param key the key
	 * @param value the value
	 * @return the map
	 */
	public abstract Map<String,String> addToMap(Map<String,String> map, String key, String value);
}
