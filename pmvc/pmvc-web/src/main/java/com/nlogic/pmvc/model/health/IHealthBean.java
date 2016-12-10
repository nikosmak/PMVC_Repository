package com.nlogic.pmvc.model.health;

import java.util.Collection;

import javax.faces.model.SelectItem;

public interface IHealthBean {

	public abstract void setHealthPicture(String healthPicture);

	public abstract String getHealthPicture();

	public abstract void setActionButtonValue(String actionButtonValue);

	public abstract String getActionButtonValue();

	public abstract void setLinkFiveUrl(String linkFiveUrl);

	public abstract String getLinkFiveUrl();

	public abstract void setLinkFiveLabel(String linkFiveLabel);

	public abstract String getLinkFiveLabel();

	public abstract void setLinkFourUrl(String linkFourUrl);

	public abstract String getLinkFourUrl();

	public abstract void setLinkFourLabel(String linkFourLabel);

	public abstract String getLinkFourLabel();

	public abstract void setUiChoice(String uiChoice);

	public abstract String getUiChoice();

	public abstract void setUiChoiceList(Collection<SelectItem> uiChoiceList);

	public abstract Collection<SelectItem> getUiChoiceList();

	public abstract void setHealthDescription(String healthDescription);

	public abstract String getHealthDescription();


	
}
