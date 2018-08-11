package com.mfl.modules.player;


import javax.xml.bind.JAXBContext;
import com.mfl.models.Player.Players;
import com.mfl.modules.XMLServices;

//import com.mfl.modules.player.models.Players;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

public class PlayerXMLServices implements XMLServices {
	
	@Override
	public Players xMLtoObject(Document xmlResource) {
		try {
			JAXBContext jc;
			
				jc = JAXBContext.newInstance(Players.class);
				Unmarshaller um =jc.createUnmarshaller();
				return (Players)um.unmarshal(xmlResource);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	
		
	}
	@Override
	public void displayObject() {
		
	}
	

}
