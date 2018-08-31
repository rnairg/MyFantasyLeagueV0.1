package com.mfl.modules;

import org.w3c.dom.Document;

public interface Modules {

	public Boolean create();
	
	public Boolean create(Document xmlresource);
	
	public Boolean update(Document xmlResource);
	
	public void read();
	
	public Boolean delete(Document xmlResource);

	void read(int i);
	
}
