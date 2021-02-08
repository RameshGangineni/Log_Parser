package com.dnb;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

public class JSONWriter implements Writer {
	Activity user = null;
	HashMap<String, String> map1 = new HashMap<String, String>();

	public JSONWriter(Activity user) {
		this.user = user;
	}

	public void write() {
		JSONObject data = null;
		File file = null;
		FileWriter fileWriter = null;
		try
		{
			data = new JSONObject();
			file = new File("/home/rameshbabug/Documents/workspace/STS/Java/assignment/src/main/resources/data/Response.txt");

			SimpleDateFormat formatter1=new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

			Date date=formatter1.parse(user.getSignedInTime());
			Timestamp ts=new Timestamp(date.getTime());
			formatter2.format(ts);
			
			data.put("signedInTime", ts);
			data.put("user", user.getUserName());
			data.put("website", user.getWebsiteName());
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
