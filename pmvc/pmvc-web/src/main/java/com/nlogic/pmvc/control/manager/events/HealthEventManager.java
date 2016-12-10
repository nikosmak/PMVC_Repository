/**
 * 
 */
package com.nlogic.pmvc.control.manager.events;

import com.nlogic.pmvc.control.handler.events.IEventHandler;

/**
 * @author nikosmak
 *
 */
public class HealthEventManager extends EventManager {

	protected IEventHandler eventHandler;

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

	public IEventHandler getEventHandler() {
		return eventHandler;
	}

	public void setEventHandler(IEventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

}
