package com.nlogic.pmvc.model.factory;

import java.util.Collection;
import java.util.Map;

public interface IFactory<T> {

	Collection<T> build(Map<String, String> items, boolean includeInitialOption, boolean sortByValue);

	Collection<T> build(Map<String, String> items, boolean includeInitialOption);

	Collection<T> build(Map<String, String> items);

	Collection<T> build();

}
