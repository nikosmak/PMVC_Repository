/**
 * 
 */
package com.nlogic.pmvc.control.handler.events.health;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.nlogic.domain.resources.ResourceLoader;
import com.nlogic.domain.resources.Resources;
import com.nlogic.pmvc.control.handler.actions.health.DoctorActionHandler;
import com.nlogic.pmvc.control.handler.actions.health.NurseActionHandler;
import com.nlogic.pmvc.control.handler.actions.health.PatientActionHandler;
import com.nlogic.pmvc.control.handler.events.EventHandler;
import com.nlogic.pmvc.control.manager.actions.health.HealthActionManager;
import com.nlogic.pmvc.enumerations.ManagedBeans;
import com.nlogic.pmvc.model.health.DoctorBean;
import com.nlogic.pmvc.model.health.HealthBean;
import com.nlogic.pmvc.model.health.HealthUserIntefaceKeys;
import com.nlogic.pmvc.model.health.NurseBean;
import com.nlogic.pmvc.model.health.PatientBean;
import com.nlogic.pmvc.model.managed.PMVCManagedBeanContainer;
import com.nlogic.pmvc.view.util.ViewUtil;
import com.nlogic.semantic.ontology.jena.DoctorInfo;
import com.nlogic.semantic.ontology.jena.NurseInfo;
import com.nlogic.semantic.ontology.jena.PatientInfo;

/**
 * @author nikosmak
 *
 */
public class HealthChoiceEventHandler  extends EventHandler{

	/**
	 * 
	 */
	public HealthChoiceEventHandler() {
	}

	@Override
	public void handleListChangeEvent(ActionEvent e) {
		PMVCManagedBeanContainer pmvcManagedBeanContainer = (PMVCManagedBeanContainer) ViewUtil.getManagedBeanInstance(ManagedBeans.PMVC_MANAGED_BEAN_CONTAINTER);
		HealthBean healthBean = (HealthBean) pmvcManagedBeanContainer.getHealthBean();		
		HealthActionManager healthActionManager = (HealthActionManager) ViewUtil.getManagedBeanInstance(ManagedBeans.HEALTH_ACTION_MANAGER);
//		Important in order to switch the action handler and the model.
		FacesContext.getCurrentInstance();
		
		if(HealthUserIntefaceKeys.SELECT_LIST_DOCTOR_KEY.equals(healthBean.getUiChoice())){
			HealthBean doctorBean = new DoctorBean(healthBean.getUiChoiceList(),
													healthBean.getUiChoice(),
													DoctorInfo.getInstance().getInfo(),
													ResourceLoader.getInstance().getResourceValue(HealthUserIntefaceKeys.IMG_DOCTOR_KEY, Resources.HEALTH_UI));

			healthActionManager.setActionHandler(new DoctorActionHandler(doctorBean));
			pmvcManagedBeanContainer.setHealthBean(doctorBean);
		} else if(HealthUserIntefaceKeys.SELECT_LIST_NURSE_KEY.equals(healthBean.getUiChoice())){
			HealthBean nurseBean = new NurseBean(healthBean.getUiChoiceList(),
												healthBean.getUiChoice(),
												NurseInfo.getInstance().getInfo(),
												ResourceLoader.getInstance().getResourceValue(HealthUserIntefaceKeys.IMG_NURSE_KEY, Resources.HEALTH_UI));
			
			healthActionManager.setActionHandler(new NurseActionHandler(nurseBean));
			pmvcManagedBeanContainer.setHealthBean(nurseBean);
		} else if(HealthUserIntefaceKeys.SELECT_LIST_PATIENT_KEY.equals(healthBean.getUiChoice())){
			HealthBean patientBean = new PatientBean(healthBean.getUiChoiceList(),
													healthBean.getUiChoice(),
													PatientInfo.getInstance().getInfo(),
													ResourceLoader.getInstance().getResourceValue(HealthUserIntefaceKeys.IMG_PATIENT_KEY, Resources.HEALTH_UI));
			
			healthActionManager.setActionHandler(new PatientActionHandler(patientBean));
			pmvcManagedBeanContainer.setHealthBean(patientBean);
		}
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void clean() {
		
	}

}
