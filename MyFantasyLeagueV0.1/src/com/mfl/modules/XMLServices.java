package com.mfl.modules;

import org.w3c.dom.Document;

//import com.mfl.modules.player.PlayerXMLServices.Players;

public interface XMLServices {
	
	public Object xMLtoObject(Document xmlResource);

	void displayObject();

}
