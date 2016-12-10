/**
 * 
 */
package com.nlogic.pmvc.model.health;

import java.util.Collection;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import com.nlogic.pmvc.model.managed.PMVCObject;

/**
 * The Class HealthBean.
 *
 * @author nikosmak
 */
public class HealthBean extends PMVCObject implements IHealthBean{

	/** The health description. */
	protected String healthDescription;
	
	/** The health picture. */
	protected String healthPicture;
	
	/** The link four label. */
	protected String linkFourLabel;
	
	/** The link four url. */
	protected String linkFourUrl;
	
	/** The link five label. */
	protected String linkFiveLabel;
	
	/** The link five url. */
	protected String linkFiveUrl;
	
	/** The action button value. */
	protected String actionButtonValue;
	
	/** The ui choice list. */
	Collection<SelectItem> uiChoiceList;
	
	/** The ui choice. */
	String uiChoice;
	
	/**
	 * Instantiates a new health managed bean.
	 */
	public HealthBean() {
		init();
	} 
		
	
	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.model.managed.PMVCManagedBean#init()
	 */
	@Override
	public void init() {
		uiChoiceList = null;
		uiChoice = StringUtils.EMPTY;
		linkFiveLabel=StringUtils.EMPTY;
		linkFiveUrl=StringUtils.EMPTY;
		linkFourLabel = StringUtils.EMPTY;
		linkFourUrl = StringUtils.EMPTY;
		
		
	}

	/* (non-Javadoc)
	 * @see com.nlogic.pmvc.model.managed.PMVCManagedBean#clean()
	 */
	@Override
	public void clean() {
		
	}

	/**
	 * Gets the health description.
	 *
	 * @return the health description
	 */
	@Override
	public String getHealthDescription() {
		return healthDescription;
	}

	/**
	 * Sets the health description.
	 *
	 * @param healthDescription the new health description
	 */
	@Override
	public void setHealthDescription(String healthDescription) {
		this.healthDescription = healthDescription;
	}


	/**
	 * Gets the ui choice list.
	 *
	 * @return the ui choice list
	 */
	@Override
	public Collection<SelectItem> getUiChoiceList() {
		return uiChoiceList;
	}


	/**
	 * Sets the ui choice list.
	 *
	 * @param uiChoiceList the new ui choice list
	 */
	@Override
	public void setUiChoiceList(Collection<SelectItem> uiChoiceList) {
		this.uiChoiceList = uiChoiceList;
	}


	/**
	 * Gets the ui choice.
	 *
	 * @return the ui choice
	 */
	@Override
	public String getUiChoice() {
		return uiChoice;
	}


	/**
	 * Sets the ui choice.
	 *
	 * @param uiChoice the new ui choice
	 */
	@Override
	public void setUiChoice(String uiChoice) {
		this.uiChoice = uiChoice;
	}


	/**
	 * Gets the link four label.
	 *
	 * @return the link four label
	 */
	@Override
	public String getLinkFourLabel() {
		return linkFourLabel;
	}


	/**
	 * Sets the link four label.
	 *
	 * @param linkFourLabel the new link four label
	 */
	@Override
	public void setLinkFourLabel(String linkFourLabel) {
		this.linkFourLabel = linkFourLabel;
	}


	/**
	 * Gets the link four url.
	 *
	 * @return the link four url
	 */
	@Override
	public String getLinkFourUrl() {
		return linkFourUrl;
	}


	/**
	 * Sets the link four url.
	 *
	 * @param linkFourUrl the new link four url
	 */
	@Override
	public void setLinkFourUrl(String linkFourUrl) {
		this.linkFourUrl = linkFourUrl;
	}


	/**
	 * Gets the link five label.
	 *
	 * @return the link five label
	 */
	@Override
	public String getLinkFiveLabel() {
		return linkFiveLabel;
	}


	/**
	 * Sets the link five label.
	 *
	 * @param linkFiveLabel the new link five label
	 */
	@Override
	public void setLinkFiveLabel(String linkFiveLabel) {
		this.linkFiveLabel = linkFiveLabel;
	}


	/**
	 * Gets the link five url.
	 *
	 * @return the link five url
	 */
	@Override
	public String getLinkFiveUrl() {
		return linkFiveUrl;
	}


	/**
	 * Sets the link five url.
	 *
	 * @param linkFiveUrl the new link five url
	 */
	@Override
	public void setLinkFiveUrl(String linkFiveUrl) {
		this.linkFiveUrl = linkFiveUrl;
	}


	/**
	 * Gets the action button value.
	 *
	 * @return the action button value
	 */
	@Override
	public String getActionButtonValue() {
		return actionButtonValue;
	}


	/**
	 * Sets the action button value.
	 *
	 * @param actionButtonValue the new action button value
	 */
	@Override
	public void setActionButtonValue(String actionButtonValue) {
		this.actionButtonValue = actionButtonValue;
	}


	/**
	 * Gets the health picture.
	 *
	 * @return the health picture
	 */
	@Override
	public String getHealthPicture() {
		return healthPicture;
	}


	/**
	 * Sets the health picture.
	 *
	 * @param healthPicture the new health picture
	 */
	@Override
	public void setHealthPicture(String healthPicture) {
		this.healthPicture = healthPicture;
	}

}
