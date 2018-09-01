package com.mfl.modules.iplteam;

import org.w3c.dom.Document;

import com.mfl.models.IplTeam.IplTeams;
import com.mfl.modules.Modules;

public class IplTeamModule implements Modules {
	
	private IplTeamXMLServices itxs;
	private IplTeamDBServices itds;

	public IplTeamXMLServices getItxs() {
		return itxs;
	}

	public void setItxs(IplTeamXMLServices itxs) {
		this.itxs = itxs;
	}

	public IplTeamDBServices getItds() {
		return itds;
	}

	public void setItds(IplTeamDBServices itds) {
		this.itds = itds;
	}

	@Override
	public Boolean create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(Document xmlResource) {
		IplTeams iplteams = getItxs().xMLToObject(xmlResource);
		getItds().setIplTeams(iplteams);
		getItds().setAction("create");
		getItds().objectToDB();
		//teams.displayTeams();
		return null;
	}

	@Override
	public void read() {
		getItds().dBToObject();
		//getTds().getTeams().displayTeams();
		getItxs().objectToXML(getItds().getIplTeams());

	}

	@Override
	public Boolean delete(Document xmlResource) {
		IplTeams iplteams = getItxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getItds().setIplTeams(iplteams);
		getItds().setAction("delete");
		getItds().objectToDB();
		return null;
	}

	@Override
	public Boolean update(Document xmlResource) {
		IplTeams iplteams = getItxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getItds().setIplTeams(iplteams);
		getItds().setAction("update");
		getItds().objectToDB();
		return null;
	}

	@Override
	public void read(int i) {
		getItds().dBToObject(i);
		//getTds().getTeams().displayTeams();
		getItxs().objectToXML(getItds().getIplTeams());
		
	}

}
