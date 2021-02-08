package com.dnb;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File dir = new File("/home/rameshbabug/Documents/workspace/STS/Java/assignment/src/main/resources/data/");

		File[] files = dir.listFiles();
		for (File file : files) {
			String filePath = file.getAbsolutePath();
			System.out.println(filePath);
			if (filePath.endsWith(".xml")){
				XML_Reader xmlReader = new XML_Reader(filePath);  
				xmlReader.inputReader();
			}
			else if(filePath.endsWith(".json")){
				JsonReader jsonReader = new JsonReader(filePath);
				jsonReader.inputReader();
			}
		}
	}
}