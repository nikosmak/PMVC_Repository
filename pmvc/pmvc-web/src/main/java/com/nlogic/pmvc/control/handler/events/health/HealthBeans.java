package com.nlogic.pmvc.control.handler.events.health;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import com.nlogic.domain.resources.ResourceLoader;
import com.nlogic.domain.resources.Resources;
import com.nlogic.pmvc.control.handler.actions.ActionHandler;
import com.nlogic.pmvc.control.handler.actions.health.DoctorActionHandler;
import com.nlogic.pmvc.control.handler.actions.health.NurseActionHandler;
import com.nlogic.pmvc.control.handler.actions.health.PatientActionHandler;
import com.nlogic.pmvc.model.health.DoctorBean;
import com.nlogic.pmvc.model.health.HealthBean;
import com.nlogic.pmvc.model.health.HealthUserIntefaceKeys;
import com.nlogic.pmvc.model.health.NurseBean;
import com.nlogic.pmvc.model.health.PatientBean;
import com.nlogic.pmvc.model.managed.PMVCObject;
import com.nlogic.semantic.ontology.jena.DoctorInfo;
import com.nlogic.semantic.ontology.jena.NurseInfo;
import com.nlogic.semantic.ontology.jena.PatientInfo;

public enum HealthBeans {
	
	/**
	 * The {@link DoctorBean}
	 */
	DOCTOR(HealthUserIntefaceKeys.SELECT_LIST_DOCTOR_KEY, DoctorActionHandler.class) {
		@Override
		public HealthBean assignModel(HealthBean healthBean) {
			return new DoctorBean(healthBean.getUiChoiceList(), healthBean.getUiChoice(),
					DoctorInfo.getInstance().getInfo(), ResourceLoader.getInstance()
							.getResourceValue(HealthUserIntefaceKeys.IMG_DOCTOR_KEY, Resources.HEALTH_UI));
		}
	},
	/**
	 * The {@link NurseBean}
	 */
	NURSE(HealthUserIntefaceKeys.SELECT_LIST_NURSE_KEY, NurseActionHandler.class) {
		@Override
		public HealthBean assignModel(HealthBean healthBean) {
			return new NurseBean(healthBean.getUiChoiceList(), healthBean.getUiChoice(),
					NurseInfo.getInstance().getInfo(), ResourceLoader.getInstance()
							.getResourceValue(HealthUserIntefaceKeys.IMG_NURSE_KEY, Resources.HEALTH_UI));
		}
	},
	/**
	 * The {@link PatientBean}
	 */
	PATIENT(HealthUserIntefaceKeys.SELECT_LIST_PATIENT_KEY, PatientActionHandler.class) {
		@Override
		public HealthBean assignModel(HealthBean healthBean) {
			return new PatientBean(healthBean.getUiChoiceList(), healthBean.getUiChoice(),
					PatientInfo.getInstance().getInfo(), ResourceLoader.getInstance()
							.getResourceValue(HealthUserIntefaceKeys.IMG_PATIENT_KEY, Resources.HEALTH_UI));
		}
	};
	
	protected static Log log = LogFactoryImpl.getLog(HealthBeans.class);
	
	private String key;

	private Class<? extends ActionHandler> clazz;

	private HealthBeans(String key, Class<? extends ActionHandler> clazz) {
		this.key = key;
		this.clazz = clazz;
	}

	/**
	 * This method identifies and returns the proper {@link HealthBeans}
	 * 
	 * @param key
	 * @return
	 */
	public static HealthBeans findHealthBeanByKey(String key) {
		for (HealthBeans healthBeans : HealthBeans.values()) {
			if (healthBeans.key.equals(key)) {
				return healthBeans;
			}
		}
		return null;
	}

	public ActionHandler create(HealthBean healthBean) {
		try {
			 return this.clazz.getConstructor(PMVCObject.class).newInstance(healthBean);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException exception) {
			log.error(exception);
		}
		return null;
	}

	public abstract HealthBean assignModel(HealthBean healthBean);
}
