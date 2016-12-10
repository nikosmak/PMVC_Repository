package com.nlogic.pmvc.model.managed;

import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

/**
 * @author nikosmak
 * Main object that is inherited by all managed beans.
 *
 */
public abstract class PMVCObject {
	
	protected Log log = LogFactoryImpl.getLog(this.getClass());
	
	protected FacesContext fc = FacesContext.getCurrentInstance();

	/**
	 * initialization method
	 */
	public abstract void init();

	/** 
	 * method that resets all the data.
	 */
	public abstract void clean();

}
