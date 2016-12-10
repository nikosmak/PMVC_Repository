/**
 * 
 */
package com.nlogic.pmvc.view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import com.nlogic.domain.resources.ResourceLoader;
import com.nlogic.pmvc.enumerations.ManagedBeans;
import com.nlogic.pmvc.model.managed.PMVCObject;

/**
 * The Class ViewUtil.
 *
 * @author nikosmak
 */
public class ViewUtil {
	

	/** The Constant MANAGED_BEAN_NAMES_FILE. */
	private static final String	MANAGED_BEAN_NAMES_FILE		= "com.nlogic.pmvc.enumerations.managedbeans";
	
	/** The Constant DEFAULT_DATE_TIME_FORMAT. */
	public static final String			DEFAULT_DATE_TIME_FORMAT	= "yyyy-MM-dd hh:mm:ss";

	/** The Constant DATE_FORMAT_DD_MM_YYYY. */
	public static final String			DATE_FORMAT_DD_MM_YYYY		= "dd/MM/yyyy";
	
	/** The Constant UNDEFINED. */
	public static final String 		UNDEFINED			= "UNDEFINED";

	/**
	 * Create / retrieve an instance of the defined {@link TransferBeans} type
	 * from the {@link FacesContext}.
	 *
	 * @param <Type> the generic type
	 * @param fc The {@link FacesContext}
	 * @param managedBean The type of the {@link TransferBeans} type
	 * @return An instance of the JSF Managed Bean
	 */
	public static <Type extends PMVCObject> PMVCObject getManagedBeanInstance(
			ManagedBeans managedBean) {

		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elCtx = fc.getELContext();
		
		System.out.println("Trying to initialize : managed bean with name : "+managedBean.getManagedBeanName()+" with class : "+managedBean.beanClass().getSimpleName());
		Object obj = fc.getApplication().getExpressionFactory().createValueExpression(elCtx,
				managedBean.getManagedBeanName(), managedBean.beanClass()).getValue(elCtx);
		
		// Type type =
		Class<? extends PMVCObject> classBean = managedBean.beanClass();
		PMVCObject bean = null;
		if (classBean.isInstance(obj)) {
			bean = (PMVCObject) obj;
		}
		return bean;
	}

	/**
	 * Set an instance of the defined {@link TransferBeans} type to the.
	 *
	 * @param <Type> the generic type
	 * @param fc The {@link FacesContext}
	 * @param transferBean The type of the {@link TransferBeans} type
	 * @param beanInstance the bean instance
	 * @return An instance of the JSF Managed Bean
	 * {@link FacesContext}.
	 */
	public static <Type extends PMVCObject> void setTransferBeanInstance(FacesContext fc,
			ManagedBeans transferBean, Type beanInstance) {

		ELContext elCtx = fc.getELContext();
		fc.getApplication().getExpressionFactory().createValueExpression(elCtx, transferBean.getManagedBeanName(),
				transferBean.beanClass()).setValue(elCtx, beanInstance);
	}

	/**
	 * Creates the managed bean instance.
	 *
	 * @param <Type> the generic type
	 * @param fc the fc
	 * @param transferBean the transfer bean
	 * @return the type
	 */
	public static <Type extends PMVCObject> Type createManagedBeanInstance(FacesContext fc,
			ManagedBeans transferBean) {

		Type bean = (Type) ViewUtil.getManagedBeanInstance(transferBean);
		bean.clean();

		return bean;
	}

	/**
	 * Gets the managed bean name.
	 *
	 * @param property the property
	 * @return the managed bean name
	 */
	public static String getManagedBeanName(String property) {
		return ResourceLoader.getInstance().getResourceValue(property, MANAGED_BEAN_NAMES_FILE);

	}


	/**
 * Date format convertion.
 *
 * @param date the date
 * @param destFormat the dest format
 * @return the string
 */
public static String dateFormatConvertion(Date date, String destFormat) {

		String result = "";

		SimpleDateFormat dateFormatter = new SimpleDateFormat(destFormat);
		if(date!=null) result = dateFormatter.format(date);
		return result;

	}
	
	/**
	 * Undefined to empty.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String undefinedToEmpty(String input){
		String result = "";
		if(!StringUtils.trimToEmpty(input).equalsIgnoreCase(UNDEFINED)) result=input;
		return result;
		
	}

	/**
	 * Date format convertion.
	 *
	 * @param dateStr the date str
	 * @param srcFormat the src format
	 * @param destFormat the dest format
	 * @return the string
	 */
	public static String dateFormatConvertion(String dateStr, String srcFormat, String destFormat) {

		String result = "";

		if (StringUtils.trimToNull(dateStr) != null) try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(srcFormat);
			Date date;
			date = dateFormatter.parse(dateStr);
			dateFormatter = new SimpleDateFormat(destFormat);
			result = dateFormatter.format(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return result;

	}
	

	

}
