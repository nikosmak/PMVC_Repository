/**
 * 
 */
package com.nlogic.pmvc.control.handler.actions.health;

import com.nlogic.domain.resources.Resources;
import com.nlogic.pmvc.control.handler.actions.ActionHandler;
import com.nlogic.pmvc.model.health.HealthUserInterfaceKeys;
import com.nlogic.pmvc.model.health.IHealthBean;
import com.nlogic.pmvc.model.managed.PMVCObject;
import com.nlogic.semantic.ontology.jena.DoctorInfo;

/**
 * @author nikosmak
 *
 */
public class DoctorActionHandler extends ActionHandler {

	/**
	 * 
	 */
	public DoctorActionHandler() {

	}

	public DoctorActionHandler(PMVCObject pmvcObject) {
		super(pmvcObject);
		
	}

	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.control.handler.actions.IActionHandler#action()
	 */
	
	public String action() {
		IHealthBean healthBean = (IHealthBean) pmvcObject;
		String healthDescription = DoctorInfo.getInstance().getInfo();
		
		String linkFourLabel = resourceLoader.getResourceValue(HealthUserInterfaceKeys.LINK_FOUR_LABEL_DOCTOR_KEY, Resources.HEALTH_UI);
		String linkFourURL = resourceLoader.getResourceValue(HealthUserInterfaceKeys.LINK_FOUR_URL_DOCTOR_KEY, Resources.HEALTH_UI);
		
		String linkFiveLabel = resourceLoader.getResourceValue(HealthUserInterfaceKeys.LINK_FIVE_LABEL_DOCTOR_KEY, Resources.HEALTH_UI);
		String linkFiveURL = resourceLoader.getResourceValue(HealthUserInterfaceKeys.LINK_FIVE_URL_DOCTOR_KEY, Resources.HEALTH_UI);
		
		healthBean.setHealthDescription(healthDescription);
		healthBean.setLinkFourLabel(linkFourLabel);
		healthBean.setLinkFourUrl(linkFourURL);
		healthBean.setLinkFiveLabel(linkFiveLabel);
		healthBean.setLinkFiveUrl(linkFiveURL);
		healthBean.setHealthPicture("images/doctor.jpg");
		return null;
	}

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

}
