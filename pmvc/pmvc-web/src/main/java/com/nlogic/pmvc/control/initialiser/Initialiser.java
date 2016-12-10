/**
 * 
 */
package com.nlogic.pmvc.control.initialiser;

import com.nlogic.domain.resources.ResourceLoader;
import com.nlogic.pmvc.enumerations.Factories;
import com.nlogic.pmvc.model.factory.IDropDownListFactory;
import com.nlogic.pmvc.model.managed.PMVCObject;

/**
 * @author nikosmak
 *
 */
public abstract class Initialiser {

	protected IDropDownListFactory dropDownListFactory;
	protected ResourceLoader resourceLoader;
	public Initialiser(){
		
	}
	
	protected PMVCObject pmvcObject = null;
	
	public Initialiser(PMVCObject pmvcObject){
		this.pmvcObject= pmvcObject;
	}
	
	public void initialise(){
		init();
		initEventManagers();
		initActionManagers();
	}
	
	public abstract void initEventManagers();
	
	public abstract void initActionManagers();
	
	public void init(){
		dropDownListFactory =  Factories.USER_INTERFACE.getInstance();
		resourceLoader = ResourceLoader.getInstance();
	}
}
