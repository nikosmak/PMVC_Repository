/**
 * 
 */
package com.nlogic.pmvc.control.manager.actions.health;

import com.nlogic.pmvc.control.handler.actions.IActionHandler;
import com.nlogic.pmvc.control.manager.actions.ActionManager;

/**
 * @author nikosmak
 *
 */
public class HealthActionManager extends ActionManager {

	/**
	 * 
	 */
	public HealthActionManager() {
	}
	
	protected IActionHandler actionHandler;

	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.model.managed.PMVCManagedBean#init()
	 */
	@Override
	public void init() {

	}

	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.model.managed.PMVCManagedBean#clean()
	 */
	@Override
	public void clean() {

	}

	public IActionHandler getActionHandler() {
		return actionHandler;
	}

	public void setActionHandler(IActionHandler actionHandler) {
		this.actionHandler = actionHandler;
	}

}
