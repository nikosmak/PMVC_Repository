/**
 * 
 */
package com.nlogic.pmvc.model.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.nlogic.pmvc.view.util.SelectItemBuilder;

/**
 * The Class UserInterfaceBuilder.
 * 
 * @author nikosmak
 */
public class DropDownListFactory implements	IDropDownListFactory {

	/**
	 * Instantiates a new user interface builder.
	 */
	private DropDownListFactory() {
	}

	/**
	 * The Class UserInterfaceBuilderInstanceHolder.
	 */
	private static class DropDownListFactoryInstanceHolder {

		/** The Constant INSTANCE. */
		public static final IDropDownListFactory INSTANCE = new DropDownListFactory();
	}

	/**
	 * Gets the single instance of UserInterfaceBuilder.
	 * 
	 * @return single instance of UserInterfaceBuilder
	 */
	public static IDropDownListFactory getInstance() {
		return DropDownListFactoryInstanceHolder.INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nlogic.pmvc.model.builder.IUserInterfaceBuilder#addToMap(java.util
	 * .Map, java.lang.String, java.lang.String)
	 */
	
	public Map<String, String> addToMap(Map<String, String> map, String key,String value) {
		if (map.equals(null)) {
			map = new HashMap<String, String>();
		}
		map.put(key, value);
		return map;

	}

	/**
	 * Builds the.
	 * 
	 * @return the collection
	 */
	
	public Collection<SelectItem> build() {
		Map<String, String> items = new HashMap<String, String>();
		return SelectItemBuilder.build(items, true);
	}

	/**
	 * Builds the.
	 * 
	 * @param items
	 *            the items
	 * @return the collection
	 */
	
	public Collection<SelectItem> build(Map<String, String> items) {
		return SelectItemBuilder.build(items, true);
	}

	/**
	 * Builds the.
	 * 
	 * @param items
	 *            the items
	 * @param includeInitialOption
	 *            the include initial option
	 * @return the collection
	 */
	
	public Collection<SelectItem> build(Map<String, String> items,
			boolean includeInitialOption) {

		return SelectItemBuilder.build(items, includeInitialOption, true);
	}

	/**
	 * Builds the.
	 * 
	 * @param items
	 *            the items
	 * @param includeInitialOption
	 *            the include initial option
	 * @param sortByValue
	 *            the sort by value
	 * @return the collection
	 */
	
	public Collection<SelectItem> build(Map<String, String> items,
			boolean includeInitialOption, boolean sortByValue) {

		Collection<SelectItem> list = new ArrayList<SelectItem>();
		if (items.size() > 0) {

			Map<String, String> sortedItems = sortByValue ? SelectItemBuilder
					.sortByValue(items) : items;

			for (String currentKey : sortedItems.keySet()) {
				list.add(new SelectItem(currentKey, items.get(currentKey)));
			}
		}

		return list;
	}

	/**
	 * Gets the map.
	 * 
	 * @param selectItems
	 *            the select items
	 * @return the map
	 */
	public Map<String, String> getMap(Collection<SelectItem> selectItems) {

		Map<String, String> items = new HashMap<String, String>();

		for (SelectItem selectItem : selectItems) {
			items.put((String) selectItem.getValue(), selectItem.getLabel());
		}
		return items;
	}

	/**
	 * Sort by value.
	 * 
	 * @param map
	 *            the map
	 * @return the map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> sortByValue(Map<String, String> map) {
		List<String> list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue().toString())
						.compareTo(((Map.Entry) (o2)).getValue().toString());
			}
		});

		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	/**
	 * Sort by int key.
	 * 
	 * @param map
	 *            the map
	 * @return the map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> sortByIntKey(Map<String, String> map) {
		List<String> list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) (Integer.parseInt(((Map.Entry) (o1))
						.getKey().toString()))).compareTo(Integer
						.parseInt(((Map.Entry) (o2)).getKey().toString()));
			}
		});

		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

}
