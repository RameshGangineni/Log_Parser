package com.dnb;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

public class XMLWriter implements Writer {
	Activity_xml user = null;
	HashMap<String, String> map1 = new HashMap<String, String>();

	public XMLWriter(Activity_xml user) {
		this.user = user;
		map1.put("001", "Viewed");
		map1.put("002", "Purchased");
	}

	public void write() {
		File file = null;
		JSONObject data = null;
		FileWriter fileWriter = null;

		try
		{
			data = new JSONObject();
			file = new File("/home/rameshbabug/Documents/workspace/STS/Java/assignment/src/main/resources/data/Response.txt");

			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date=formatter1.parse(user.getLoggedInTime());
			Timestamp ts=new Timestamp(date.getTime());
			formatter2.format(ts);

			data.put("signedInTime", ts);
			data.put("user", user.getUserName());
			data.put("website", user.getWebsiteName());

			if(user.getActivityTypeCode() !=null)
				data.put("activityTypeDescription", map1.get(user.getActivityTypeCode()));
			else
				data.put("activityTypeDescription", user.getActivityTypeDescription());

			fileWriter = new FileWriter(file, true);
			fileWriter.write(data.toString());
			fileWriter.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
