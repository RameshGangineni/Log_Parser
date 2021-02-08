package com.dnb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class JsonReader implements Reader {

	String jsonFile = null;

	public JsonReader(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	public void inputReader() {
		try {
			System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
			File file = new File(jsonFile);
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder jsonStr = new StringBuilder();
			String st = "";
			while ((st = br.readLine()) != null) {
				jsonStr.append(st.replaceAll("\\s", ""));
			}

			JAXBContext jc = JAXBContext.newInstance(Activity.class);
			System.out.println("JSON"+jsonStr.toString());
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
			unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
			StreamSource json = new StreamSource(new StringReader(jsonStr.toString()));
			Activity user = unmarshaller.unmarshal(json, Activity.class).getValue();
			JSONWriter jsonWriter = new JSONWriter(user);
			jsonWriter.write();

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
