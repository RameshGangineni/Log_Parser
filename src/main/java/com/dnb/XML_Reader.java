package com.dnb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class XML_Reader implements Reader{

	String xmlFilePath = null;

	public XML_Reader(String filePath) {
		this.xmlFilePath = filePath;
	}
	public Boolean validateXML()  {
		Boolean flag = true;

		try 
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);

			SAXParser parser = factory.newSAXParser();
			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
					"http://www.w3.org/2001/XMLSchema");

			XMLReader reader = parser.getXMLReader();

			reader.setErrorHandler(new ErrorHandler(){
				public void warning(SAXParseException e) throws SAXException {
					System.out.println(e.getMessage());
				}

				public void error(SAXParseException e) throws SAXException {
					System.out.println(e.getMessage());
					throw e;

				}

				public void fatalError(SAXParseException e) throws SAXException {
					System.out.println(e.getMessage());
					throw e;
				}

			});
			reader.parse(new InputSource(xmlFilePath));
		}

		catch(Exception e)
		{
			flag = false;
		}

		return flag;
	}
	
	public void inputReader() {
		 //Boolean flag = validateXML();
		
		if (true)
		{
			try {
			JAXBContext jc = JAXBContext.newInstance(Activity_xml.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			File file = new File(xmlFilePath);
			Activity_xml user =  (Activity_xml) unmarshaller.unmarshal(file);
			
			
			XMLWriter w = new XMLWriter(user);
			w.write();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
}