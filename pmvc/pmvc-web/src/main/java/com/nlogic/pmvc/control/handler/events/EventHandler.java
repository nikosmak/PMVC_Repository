/**
 * 
 */
package com.nlogic.pmvc.control.handler.events;

import javax.faces.event.ActionEvent;

import com.nlogic.pmvc.control.handler.PMVCHandler;

/**
 * @author nikosmak
 *
 */
public abstract class EventHandler extends PMVCHandler implements IEventHandler{

	/**
	 * 
	 */
	public EventHandler() {
	}
	
	
	public abstract void handleListChangeEvent(ActionEvent e); //throws JessException;
	
	
}
