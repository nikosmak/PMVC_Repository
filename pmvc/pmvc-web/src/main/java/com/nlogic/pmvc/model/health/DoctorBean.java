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
public class DoctorBean extends HealthBean {

	public DoctorBean() {
		super();
	}
	
	public DoctorBean(Collection<SelectItem> uiChoiceList,String uiChoice,String healthDescription,String healthPicture){
		this.uiChoiceList = uiChoiceList;
		this.uiChoice = uiChoice;
		this.healthDescription = healthDescription;
		this.healthPicture = healthPicture;
	}

}
