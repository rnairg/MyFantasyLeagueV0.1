package com.mfl.modules.team;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

import com.mfl.models.Team.Teams;
import com.mfl.modules.XMLServices;

public class TeamXMLServices implements XMLServices {

	@Override
	public Teams xMLtoObject(Document xmlResource) {
		try {
			JAXBContext jc;
			
				jc = JAXBContext.newInstance(Teams.class);
				Unmarshaller um =jc.createUnmarshaller();
				Teams teams = (Teams)um.unmarshal(xmlResource);
				return teams;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		// TODO Auto-generated method stub
	}

	@Override
	public void displayObject() {
		// TODO Auto-generated method stub

	}

}
