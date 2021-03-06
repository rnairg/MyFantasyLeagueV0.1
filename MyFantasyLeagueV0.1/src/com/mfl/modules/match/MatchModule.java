package com.mfl.modules.match;

import org.w3c.dom.Document;

import com.mfl.models.Match.Matches;
import com.mfl.modules.Modules;
public class MatchModule implements Modules {
	
	private MatchXMLServices mxs;
	private MatchDBServices mds;
	
	public MatchXMLServices getMxs() {
		return mxs;
	}

	public void setMxs(MatchXMLServices mxs) {
		this.mxs = mxs;
	}

	public MatchDBServices getMds() {
		return mds;
	}

	public void setMds(MatchDBServices mds) {
		this.mds = mds;
	}

	@Override
	public Boolean create() {
		
		return null;
	}

	@Override
	public Boolean create(Document xmlResource) {
		Matches matches = getMxs().xMLToObject(xmlResource);
		getMds().setMatches(matches);
		getMds().setAction("create");
		getMds().objectToDB();
		return null;
	}

	@Override
	public Boolean update(Document xmlResource) {
		Matches matches = getMxs().xMLToObject(xmlResource);
		getMds().setMatches(matches);
		getMds().setAction("update");
		getMds().objectToDB();
		return null;
	}

	@Override
	public void read() {
		getMds().dBToObject();
		//getPds().getPlayers().displayPlayers();
		getMxs().objectToXML(getMds().getMatches());

	}

	@Override
	public Boolean delete(Document xmlResource) {
		Matches matches = getMxs().xMLToObject(xmlResource);
		getMds().setMatches(matches);
		getMds().setAction("delete");
		getMds().objectToDB();
		return null;
	}

	@Override
	public void read(int i) {
		getMds().dBToObject(i);
		//getPds().getPlayers().displayPlayers();
		getMxs().objectToXML(getMds().getMatches());

	}

}
