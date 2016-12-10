/**
 * 
 */
package com.nlogic.pmvc.model.managed;

import com.nlogic.pmvc.control.initialiser.health.HealthInitialiser;
import com.nlogic.pmvc.model.health.IHealthBean;

/**
 * @author nikosmak
 * When the {@link PMVCManagedBeanContainer} constructor will be
 * called by the faces-context it will execute the initializer.
 * We want to initialize this {@link PMVCObject} so we 
 * will set <code>this</code> reference to the {@link PMVCObject}
 * parameter.
 */
public class PMVCManagedBeanContainer extends PMVCObject{
	
	private IHealthBean healthBean;
	
	public PMVCManagedBeanContainer(){
		HealthInitialiser healthInitialiser = new HealthInitialiser(this);
		healthInitialiser.initialise();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void clean() {
		
	}

	public IHealthBean getHealthBean() {
		return healthBean;
	}

	public void setHealthBean(IHealthBean healthBean) {
		this.healthBean = healthBean;
	}

	
}
