package com.dnb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="activity")  
public class Activity_xml {
	
	
	public Activity_xml() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlElement(name="userName")
	private String userName;
	@XmlElement(name="websiteName")
	private String websiteName;
	@XmlElement(name="activityTypeCode")
	private String activityTypeCode;
	@XmlElement(name="loggedInTime")
	private String loggedInTime;
	@XmlElement(name="number_of_views")
	private String number_of_views;
	private String activityTypeDescription;

	public String getUserName() {
		return userName;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public String getActivityTypeCode() {
		return activityTypeCode;
	}

	public String getLoggedInTime() {
		return loggedInTime;
	}

	public String getNumber_of_views() {
		return number_of_views;
	}

	public String getActivityTypeDescription() {
		return activityTypeDescription;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", websiteName=" + websiteName 
				 + ", activityTypeCode=" + activityTypeCode + ", loggedInTime=" + loggedInTime
				+ "]";
	}	
}