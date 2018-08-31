package com.mfl.modules.team;

import org.w3c.dom.Document;
import com.mfl.models.Team.Teams;
import com.mfl.modules.Modules;

public class TeamModule implements Modules {
	
	private TeamXMLServices txs;
	private TeamDBServices tds;

	public TeamDBServices getTds() {
		return tds;
	}

	public void setTds(TeamDBServices tds) {
		this.tds = tds;
	}

	public TeamXMLServices getTxs() {
		return txs;
	}

	public void setTxs(TeamXMLServices txs) {
		this.txs = txs;
	}

	@Override
	public Boolean create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(Document xmlResource) {
		Teams teams = getTxs().xMLToObject(xmlResource);
		getTds().setTeams(teams);
		getTds().setAction("create");
		getTds().objectToDB();
		//teams.displayTeams();
		return null;
	}

	@Override
	public void read() {
		getTds().dBToObject(3);
		//getTds().getTeams().displayTeams();
		getTxs().objectToXML(getTds().getTeams());

	}

	@Override
	public Boolean delete(Document xmlResource) {
		Teams teams = getTxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getTds().setTeams(teams);
		getTds().setAction("delete");
		getTds().objectToDB();
		return null;
	}

	@Override
	public Boolean update(Document xmlResource) {
		Teams teams = getTxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getTds().setTeams(teams);
		getTds().setAction("update");
		getTds().objectToDB();
		return null;
	}

	@Override
	public void read(int i) {
		// TODO Auto-generated method stub
		
	}

}
