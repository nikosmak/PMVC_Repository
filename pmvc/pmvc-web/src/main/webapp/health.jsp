<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<f:view>

<a4j:status id="stateStatus" onstart="Richfaces.showModalPanel('ajaxLoadingModalBox')" onstop="Richfaces.hideModalPanel('ajaxLoadingModalBox')"/>
		
	<rich:modalPanel id="ajaxLoadingModalBox" width="200" height="100" moveable="false"  resizeable="false">
		<h:panelGrid columns="1">
			
			<h:graphicImage value="/images/ajax-loader.gif"/>
		</h:panelGrid>
		
	</rich:modalPanel>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Health Care</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h:form>

<div id="wrapper">
  <div id="header">
    <div class="logo">
      <h1>NLogic</h1>
      
    </div>
  </div>
   
  <div id="navigation">
    <ul>
      <li style="margin-left: 1px"><a href="http://all-free-download.com/free-website-templates/">Free Business Templates</a></li>
      <li id="current"><a href="http://all-free-download.com/free-website-templates/">Link No Three</a></li>
      <a4j:outputPanel id="linksPanel">
      <li><h:outputLink value="#{pMVCManagedBeanContainer.healthBean.linkFourUrl}">
      <h:outputText value="#{pMVCManagedBeanContainer.healthBean.linkFourLabel}"></h:outputText></h:outputLink></li>
      <li><h:outputLink value="#{pMVCManagedBeanContainer.healthBean.linkFiveUrl}"><h:outputText value="#{pMVCManagedBeanContainer.healthBean.linkFiveLabel}"></h:outputText></h:outputLink></li>
      </a4j:outputPanel>
    </ul>
  </div>
  <div id="navigationmenuline">&nbsp;</div>
  <div id="leftcolumn">
    <h3>Healthcare Website Template</h3>
    <blockquote>
      <p>This is an open source template and is relased and distributed under Creative Commons 2.5 licence. You are free to use this template in any way you like. All I ask for is that you leave the web site design credit links in the footer area of this template intact.</p>
    </blockquote>
    <div id="boxes">
      <div class="box">
        <h4>Lorem Ipsum</h4>
        <ul>
          <li><a href="http://all-free-download.com/free-website-templates/">Lorem ipsum dolor sit amet</a></li>
          <li><a href="http://all-free-download.com/free-website-templates/">Lorem ipsum dolor sit amet</a></li>
          <li><a href="http://all-free-download.com/free-website-templates/">Lorem ipsum dolor sit amet</a></li>
          <li><a href="http://all-free-download.com/free-website-templates/">Lorem ipsum dolor sit amet</a></li>
          <li><a href="http://all-free-download.com/free-website-templates/">Lorem ipsum dolor sit amet</a></li>
        </ul>
        <img src="images/img2.jpg" class="floatTR" alt="" />
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec rutrum neque eu nisl. Morbi eget felis. Morbi eget felis.</p>
        <a href="http://all-free-download.com/free-website-templates/">read more</a> </div>
      <div class="box">
        <h4>Lorem Ipsum</h4>
        <img src="images/img3.jpg" class="floatTL" alt="" />
        <p>Lorem ipsum dolor sit amet, conse adipisin elit. Donec rutrum neque eu nisl. Morbi eget felis.</p>
        <a href="http://all-free-download.com/free-website-templates/">read more</a> <img src="images/img4.jpg" class="floatTL" alt="" />
        <p>Lorem ipsum dolor sit amet, conse adipisin elit. Donec rutrum neque eu nisl. Morbi eget felis.</p>
        <a href="http://all-free-download.com/free-website-templates/">read more</a> </div>
    </div>
    <div class="clear"></div>
  </div>
  <div id="content">
    <h3>Λεπτομέρειες</h3>
    <a4j:outputPanel id="healthPanel">
   <h:graphicImage value="#{pMVCManagedBeanContainer.healthBean.healthPicture}" styleClass="floatTL"/>
    <p><h:outputText value="#{pMVCManagedBeanContainer.healthBean.healthDescription}"></h:outputText></p>
    <a4j:commandButton value="Yποβολή" action="#{healthActionManager.actionHandler.action}" status="stateStatus" reRender="healthPanel,linksPanel"></a4j:commandButton>
    </a4j:outputPanel>
    <div class="clear"></div>
  
  </div>
  <div id="rightcolumn">
    <h4>More Links Here</h4>
    <div class ="rightnavigation">
    
    	<h:selectOneMenu id="uiChoice" value="#{pMVCManagedBeanContainer.healthBean.uiChoice}">
    		<a4j:support ajaxSingle="true" status="stateStatus" event="onchange" actionListener="#{healthEventManager.eventHandler.handleListChangeEvent}" reRender="healthPanel"></a4j:support>
    		<f:selectItems value="#{pMVCManagedBeanContainer.healthBean.uiChoiceList}"/>
    	</h:selectOneMenu>
    
      <ul>
        <li><a href="http://all-free-download.com/free-website-templates/">Free CSS Templates</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Three</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Four</a></li>
      </ul>
    </div>
    <h5>Ads here</h5>
    <div class ="ads">
      <ul>
        <li><a href="http://all-free-download.com/free-website-templates/">Link One</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Two</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Three</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Four</a></li>
      </ul>
    </div>
    <div class ="rightnavigation">
      <ul>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Five</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Six</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Seven</a></li>
        <li><a href="http://all-free-download.com/free-website-templates/">Link Eight</a></li>
      </ul>
    </div>
    <div class="news">
      <h2>News and Events</h2>
      <h3>Aug.16.07.</h3>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec rutrum ... </p>
      <a href="http://all-free-download.com/free-website-templates/">read more</a>
      <h3>Aug.10.07.</h3>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec rutrum ... </p>
      <a href="http://all-free-download.com/free-website-templates/">read more</a> </div>
  </div>
</div>

</h:form>
<div id="footer"> <a href="http://all-free-download.com/free-website-templates/">Valid XHTML</a> | <a href="http://all-free-download.com/free-website-templates/">Valid CSS</a> <br/>
  Copyright &copy; 2007  All Rights Reserved. <br/>
  Designed By <a href="http://www.businesswebsitetemplates.blogspot.com/">Heltcare Website Templates</a>. </div>
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>

</f:view>