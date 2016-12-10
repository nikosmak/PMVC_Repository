package com.nlogic.pmvc.control.handler.events;

import javax.faces.event.ActionEvent;

/**
 * The Interface IEventHandler.
 */
public interface IEventHandler {

	/**
	 * Handle list change event.
	 *
	 * @param e the e
	 */
	public abstract void handleListChangeEvent(ActionEvent e);

}
