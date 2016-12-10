/**
 * 
 */
package com.nlogic.pmvc.control.handler.actions;

import com.nlogic.domain.resources.ResourceLoader;
import com.nlogic.pmvc.control.handler.PMVCHandler;
import com.nlogic.pmvc.model.managed.PMVCObject;

/**
 * @author nikosmak
 *
 */
public abstract class ActionHandler extends PMVCHandler implements IActionHandler{

	/**
	 * 
	 */
	protected PMVCObject pmvcObject;
	protected ResourceLoader resourceLoader;
	public ActionHandler() {
		resourceLoader = ResourceLoader.getInstance();
	}
	
	public ActionHandler(PMVCObject pmvcObject){
		this.pmvcObject = pmvcObject;
		resourceLoader = ResourceLoader.getInstance();
	}

}
