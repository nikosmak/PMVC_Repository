/**
 * 
 */
package com.nlogic.pmvc.control.handler.events.health;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.nlogic.pmvc.control.handler.events.EventHandler;
import com.nlogic.pmvc.control.manager.actions.health.HealthActionManager;
import com.nlogic.pmvc.enumerations.HealthBeans;
import com.nlogic.pmvc.enumerations.ManagedBeans;
import com.nlogic.pmvc.model.health.HealthBean;
import com.nlogic.pmvc.model.managed.PMVCManagedBeanContainer;
import com.nlogic.pmvc.view.util.ViewUtil;

/**
 * @author nikosmak
 *
 */
public class HealthChoiceEventHandler  extends EventHandler{

	@Override
	public void handleListChangeEvent(ActionEvent e) {
		PMVCManagedBeanContainer pmvcManagedBeanContainer = (PMVCManagedBeanContainer) ViewUtil.getManagedBeanInstance(ManagedBeans.PMVC_MANAGED_BEAN_CONTAINTER);
		HealthBean healthBean = (HealthBean) pmvcManagedBeanContainer.getHealthBean();		
		HealthActionManager healthActionManager = (HealthActionManager) ViewUtil.getManagedBeanInstance(ManagedBeans.HEALTH_ACTION_MANAGER);
//		Important in order to switch the action handler and the model.
		FacesContext.getCurrentInstance();
		HealthBeans healthBeans = HealthBeans.findHealthBeanByKey(healthBean.getUiChoice());
		HealthBean newHealthBean = healthBeans.assignModel(healthBean);
		healthActionManager.setActionHandler(healthBeans.create(newHealthBean));
		pmvcManagedBeanContainer.setHealthBean(newHealthBean);
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void clean() {
		
	}
}
