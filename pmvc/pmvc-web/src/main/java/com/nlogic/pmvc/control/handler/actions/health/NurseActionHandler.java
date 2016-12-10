/**
 * 
 */
package com.nlogic.pmvc.control.handler.actions.health;

import com.nlogic.domain.resources.Resources;
import com.nlogic.pmvc.control.handler.actions.ActionHandler;
import com.nlogic.pmvc.model.health.HealthUserIntefaceKeys;
import com.nlogic.pmvc.model.health.IHealthBean;
import com.nlogic.pmvc.model.managed.PMVCObject;
import com.nlogic.semantic.ontology.jena.NurseInfo;

/**
 * @author nikosmak
 *
 */
public class NurseActionHandler extends ActionHandler {

	/**
	 * 
	 */
	public NurseActionHandler() {
	}

	public NurseActionHandler(PMVCObject pmvcObject) {
		super(pmvcObject);
	}

	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.control.handler.actions.IActionHandler#action()
	 */
	@Override
	public String action() {
		IHealthBean healthBean = (IHealthBean) pmvcObject;
//		String healthDescription = resourceLoader.getResourceValue(HealthUserIntefaceKeys.NURSE_DESCRIPTION, Resources.HEALTH_UI);
		String healthDescription = NurseInfo.getInstance().getInfo();
		
		String linkFourLabel = resourceLoader.getResourceValue(HealthUserIntefaceKeys.LINK_FOUR_LABEL_NURSE_KEY, Resources.HEALTH_UI);
		String linkFourURL = resourceLoader.getResourceValue(HealthUserIntefaceKeys.LINK_FOUR_URL_NURSE_KEY, Resources.HEALTH_UI);
		
		String linkFiveLabel = resourceLoader.getResourceValue(HealthUserIntefaceKeys.LINK_FIVE_LABEL_NURSE_KEY, Resources.HEALTH_UI);
		String linkFiveURL = resourceLoader.getResourceValue(HealthUserIntefaceKeys.LINK_FIVE_URL_NURSE_KEY, Resources.HEALTH_UI);
		
		healthBean.setHealthDescription(healthDescription);
		healthBean.setLinkFourLabel(linkFourLabel);
		healthBean.setLinkFourUrl(linkFourURL);
		healthBean.setLinkFiveLabel(linkFiveLabel);
		healthBean.setLinkFiveUrl(linkFiveURL);
		healthBean.setHealthPicture("images/nurse.jpg");
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
