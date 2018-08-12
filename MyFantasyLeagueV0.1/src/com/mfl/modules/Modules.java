package com.mfl.modules;

import org.w3c.dom.Document;

public interface Modules {

	public Boolean create();
	
	public Boolean create(Document xmlresource);
	
	//public Boolean update(); // To be added later
	
	public void read();
	
	public Boolean delete();
	
}
