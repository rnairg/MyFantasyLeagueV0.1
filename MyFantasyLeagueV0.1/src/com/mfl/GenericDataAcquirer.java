package com.mfl;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class GenericDataAcquirer {
	
	private String xmlresourcepath;
	
	
	public String getXmlresourcepath() {
		return xmlresourcepath;
	}

	public void setXmlresourcepath(String xmlresourcepath) {
		this.xmlresourcepath = xmlresourcepath;
	}


	public Document acquireXMLResourceByPath()
	{
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(getXmlresourcepath());
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;	
	}
	
}
