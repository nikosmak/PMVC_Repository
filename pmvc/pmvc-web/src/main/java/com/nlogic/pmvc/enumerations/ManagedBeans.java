/**
 * 
 */
package com.nlogic.pmvc.enumerations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import com.nlogic.pmvc.control.manager.actions.health.HealthActionManager;
import com.nlogic.pmvc.control.manager.events.EventManager;
import com.nlogic.pmvc.control.manager.events.HealthEventManager;
import com.nlogic.pmvc.model.managed.ManagedBeanNamesPropertyKeys;
import com.nlogic.pmvc.model.managed.PMVCObject;
import com.nlogic.pmvc.model.managed.PMVCManagedBeanContainer;
import com.nlogic.pmvc.view.util.ViewUtil;

/**
 * The Enum ManagedBeans.
 *
 * @author nikosmak
 */
public enum ManagedBeans {
	
	/** The event manager. */
	EVENT_MANAGER(EventManager.class, ManagedBeanNamesPropertyKeys.EVENT_MANAGER_KEY,false),
	
	/** The HEALT h_ even t_ manager. */
	HEALTH_EVENT_MANAGER(HealthEventManager.class,ManagedBeanNamesPropertyKeys.HEALTH_EVENT_MANAGER_KEY,false),
	
	/** The HEALT h_ actio n_ manager. */
	HEALTH_ACTION_MANAGER(HealthActionManager.class,ManagedBeanNamesPropertyKeys.HEALTH_ACTION_MANAGER_KEY,false),
		
	PMVC_MANAGED_BEAN_CONTAINER(PMVCManagedBeanContainer.class,ManagedBeanNamesPropertyKeys.PMVC_MANAGED_BEAN_CONTAINER,false);
	

	/** The bean class. */
	private Class<? extends PMVCObject> beanClass;

	/** The name property. */
	private String nameProperty;

	/** The is short session. */
	private boolean isShortSession;

	/** The Constant EL_PREFIX. */
	private static final String EL_PREFIX = "#{";
	
	/** The Constant EL_SUFFIX. */
	private static final String EL_SUFFIX = "}";

	/** The log. */
	private Log log;

	/**
	 * Instantiates a new managed beans.
	 *
	 * @param beanClass the bean class
	 * @param nameProperty the name property
	 * @param isShortSession the is short session
	 */
	private ManagedBeans(Class<? extends PMVCObject> beanClass,
			String nameProperty, boolean isShortSession) {
		log = LogFactoryImpl.getLog(ManagedBeans.class);

		this.beanClass = beanClass;

		this.nameProperty = nameProperty;
		this.isShortSession = isShortSession;
	}

	/**
	 * Bean class.
	 *
	 * @return the class<? extends pmvc managed bean>
	 */
	public Class<? extends PMVCObject> beanClass() {
		return beanClass;
	}

	/**
	 * Name property.
	 *
	 * @return the string
	 */
	public String nameProperty() {
		return nameProperty;
	}

	/**
	 * Checks if is short session.
	 *
	 * @return true, if is short session
	 */
	public boolean isShortSession() {

		return isShortSession;
	}

	/**
	 * Gets the transfer bean name.
	 *
	 * @return the transfer bean name
	 */
	public String getManagedBeanName() {

		return new StringBuffer().append(EL_PREFIX)
				.append(ViewUtil.getManagedBeanName(this.nameProperty()))
				.append(EL_SUFFIX).toString();
	}

	/**
	 * Find transfer bean by class.
	 *
	 * @param beanClass the bean class
	 * @return the managed beans
	 */
	public static ManagedBeans findManagedBeanByClass(
			Class<? extends PMVCObject> beanClass) {

		for (ManagedBeans bean : ManagedBeans.values()) {
			if (bean.beanClass().equals(beanClass)) {
				return bean;
			}
		}
		return null;
	}
}
