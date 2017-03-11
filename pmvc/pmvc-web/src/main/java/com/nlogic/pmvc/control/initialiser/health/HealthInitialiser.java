package com.nlogic.pmvc.control.initialiser.health;

import java.util.HashMap;
import java.util.Map;

import com.nlogic.domain.resources.Resources;
import com.nlogic.pmvc.control.handler.actions.health.DoctorActionHandler;
import com.nlogic.pmvc.control.handler.events.health.HealthChoiceEventHandler;
import com.nlogic.pmvc.control.initialiser.Initialiser;
import com.nlogic.pmvc.control.manager.actions.health.HealthActionManager;
import com.nlogic.pmvc.control.manager.events.HealthEventManager;
import com.nlogic.pmvc.enumerations.ManagedBeans;
import com.nlogic.pmvc.model.health.DoctorBean;
import com.nlogic.pmvc.model.health.HealthBean;
import com.nlogic.pmvc.model.health.HealthUserInterfaceKeys;
import com.nlogic.pmvc.model.managed.PMVCObject;
import com.nlogic.pmvc.model.managed.PMVCManagedBeanContainer;
import com.nlogic.pmvc.view.util.ViewUtil;

/**
 * @author nikosmak
 * This is the main initializer class for the p-mvc app.
 * The {@link PMVCManagedBeanContainer} is retrieved as {@link PMVCObject}
 * constructor parameter and it is assigned the proper values.
 */
public class HealthInitialiser extends Initialiser{

	public HealthInitialiser(){
		
	}
	
	public HealthInitialiser(PMVCObject pmvcObject) {
		super(pmvcObject);
		
	}
	
	public void init(){
		super.init();
		PMVCManagedBeanContainer managedBeanContainer = (PMVCManagedBeanContainer) pmvcObject;
		HealthBean healthBean = new DoctorBean();
		String healthDescription = resourceLoader.getResourceValue(HealthUserInterfaceKeys.DOCTOR_DESCRIPTION, Resources.HEALTH_UI);
		
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
		
		//select list initial values
		Map<String,String> map = new HashMap<String, String>();
		dropDownListFactory.addToMap(map, HealthUserInterfaceKeys.SELECT_LIST_DOCTOR_KEY,  resourceLoader.getResourceValue(HealthUserInterfaceKeys.SELECT_LIST_DOCTOR_KEY, Resources.HEALTH_UI));
		dropDownListFactory.addToMap(map, HealthUserInterfaceKeys.SELECT_LIST_NURSE_KEY, resourceLoader.getResourceValue(HealthUserInterfaceKeys.SELECT_LIST_NURSE_KEY, Resources.HEALTH_UI));
		dropDownListFactory.addToMap(map, HealthUserInterfaceKeys.SELECT_LIST_PATIENT_KEY, resourceLoader.getResourceValue(HealthUserInterfaceKeys.SELECT_LIST_PATIENT_KEY, Resources.HEALTH_UI));
		
		healthBean.setUiChoiceList(dropDownListFactory.build(map));
		managedBeanContainer.setHealthBean(healthBean);
		
	}



	@Override
	public void initEventManagers() {
		HealthEventManager healthEventManager = (HealthEventManager) ViewUtil.getManagedBeanInstance(ManagedBeans.HEALTH_EVENT_MANAGER);
		HealthChoiceEventHandler healthChoiceEventHandler = new HealthChoiceEventHandler();
		healthEventManager.setEventHandler(healthChoiceEventHandler);
	}



	@Override
	public void initActionManagers() {
		HealthActionManager healthActionManager = (HealthActionManager) ViewUtil.getManagedBeanInstance(ManagedBeans.HEALTH_ACTION_MANAGER);
		PMVCManagedBeanContainer pmvcManagedBeanContainer = (PMVCManagedBeanContainer) this.pmvcObject;
		DoctorActionHandler doctorActionHandler = new DoctorActionHandler((PMVCObject) pmvcManagedBeanContainer.getHealthBean());
		healthActionManager.setActionHandler(doctorActionHandler);
	}
}
