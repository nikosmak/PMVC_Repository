package com.nlogic.pmvc.enumerations;

import com.nlogic.pmvc.model.factory.DropDownListFactory;
import com.nlogic.pmvc.model.factory.IFactory;

public enum Factories {

	USER_INTERFACE(DropDownListFactory.getInstance());
	
	private IFactory factory = null;
	
	private Factories(IFactory factory){
		this.factory = factory;
	}
	
	public <T> T getInstance(){
		return  (T) factory;
	}
}
