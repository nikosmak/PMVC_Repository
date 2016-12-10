package com.nlogic.pmvc.view.util;

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

/**
 * 
 * @author D. Barpakis
 *
 */
public class SelectItemBuilder {
    
	public static Collection<SelectItem> build() {
		Map<String, String> items = new HashMap<String, String>();
		return SelectItemBuilder.build(items, true);
	}
	
	public static Collection<SelectItem> build(Map<String, String> items) {
		return SelectItemBuilder.build(items, true);
	}
	
	public static Collection<SelectItem> build(Map<String, String> items, boolean includeInitialOption) {
        
		return SelectItemBuilder.build(items, includeInitialOption, true);
    }
	
	public static Collection<SelectItem> build(Map<String, String> items, boolean includeInitialOption, boolean sortByValue) {
        
		Collection<SelectItem> list = new ArrayList<SelectItem>();
//        if(includeInitialOption) {
//            list.add(new SelectItem(
//            		ViewUtil.getUIElement(UIElementsPropertykeys.ID_INITIAL_VAL_DROP_DOWN), 
//            		ViewUtil.getLabel(LabelsPropertyKeys.DROPDOWN_MENU_INITIAL_VAL)));            }

        if (items.size()>0) {
        	
        	Map<String, String> sortedItems = sortByValue ? SelectItemBuilder.sortByValue(items) : items;
         
            for(String currentKey: sortedItems.keySet()) {
                list.add(new SelectItem(currentKey, items.get(currentKey)));                
            }
        }
        

       return list;
    }
    

	public static Map<String, String> getMap(Collection<SelectItem> selectItems) {
		
		Map<String, String> items = new HashMap<String, String>();

		for(SelectItem selectItem: selectItems) {
			items.put((String)selectItem.getValue(), selectItem.getLabel());			
		}		
		return items;
	}
	

	@SuppressWarnings("unchecked")
	public static Map<String,String> sortByValue(Map<String,String> map) {
		List<String> list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue().toString()).compareTo(((Map.Entry) (o2)).getValue().toString());
			}
		});

		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry)it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		
		return result;
	} 
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> sortByIntKey(Map<String,String> map) {
		List<String> list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) (
							Integer.parseInt(
									((Map.Entry) (o1)).getKey().toString()))
								).compareTo(
							Integer.parseInt(
									((Map.Entry) (o2)).getKey().toString())
						);
			}
		});

		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry)it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		
		return result;
	} 
}
