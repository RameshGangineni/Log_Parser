package com.dnb;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {


	public Activity() {
		// TODO Auto-generated constructor stub
	}


	private String userName;

	private String websiteName;

	private String signedInTime;

	private String activityTypeDescription;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getSignedInTime() {
		return signedInTime;
	}

	public void setSignedInTime(String signedInTime) {
		this.signedInTime = signedInTime;
	}

	public String getActivityTypeDescription() {
		return activityTypeDescription;
	}

	public void setActivityTypeDescription(String activityTypeDescription) {
		this.activityTypeDescription = activityTypeDescription;
	}

	@Override
	public String toString() {
		return "Activity [userName=" + userName + ", websiteName=" + websiteName + ", signedInTime=" + signedInTime
				+ ", activityTypeDescription=" + activityTypeDescription + "]";
	}
}
