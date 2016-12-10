/**
 * 
 */
package com.nlogic.pmvc.model.health;

import java.util.Collection;

import javax.faces.model.SelectItem;

/**
 * @author nikosmak
 *
 */
public class NurseBean extends HealthBean {

	public NurseBean() {
		super();
	}

	public NurseBean(Collection<SelectItem> uiChoiceList,String uiChoice,String healthDescription,String healthPicture){
		this.uiChoiceList = uiChoiceList;
		this.uiChoice = uiChoice;
		this.healthDescription = healthDescription;
		this.healthPicture = healthPicture;
	}

}
