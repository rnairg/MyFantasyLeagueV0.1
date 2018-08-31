package com.mfl.modules.player;

import org.w3c.dom.Document;

import com.mfl.models.Player.Players;
import com.mfl.modules.Modules;

public class PlayerModule implements Modules {
	
	private PlayerXMLServices pxs;
	private PlayerDBServices pds;

	public PlayerDBServices getPds() {
		return pds;
	}

	public void setPds(PlayerDBServices pds) {
		this.pds = pds;
	}

	public void setPxs(PlayerXMLServices pxs) {
		this.pxs = pxs;
	}

	public PlayerXMLServices getPxs() {
		return pxs;
	}

	
	@Override
	public Boolean create() {
		
		return null;
	}

	@Override
	public Boolean delete(Document xmlResource) {
		Players players = getPxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getPds().setPlayers(players);
		getPds().setAction("delete");
		getPds().objectToDB();
		return null;
	}

	@Override
	public void read() {
		getPds().dBToObject();
		//getPds().getPlayers().displayPlayers();
		getPxs().objectToXML(getPds().getPlayers());

	}
	@Override
	public void read(int i) {
		getPds().dBToObject(i);
		//getPds().getPlayers().displayPlayers();
		getPxs().objectToXML(getPds().getPlayers());

	}
	
	@Override
	public Boolean create(Document xmlResource) {
		
		//((PlayerDBServices) getPds()).setPlayers(((PlayerXMLServices) getPxs()).xMLtoObject(xmlResource));
		Players players = getPxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getPds().setPlayers(players);
		getPds().setAction("create");
		getPds().objectToDB();
		
		return null;
	}

	@Override
	public Boolean update(Document xmlResource) {
		Players players = getPxs().xMLToObject(xmlResource);
		//players.displayPlayers();
		getPds().setPlayers(players);
		getPds().setAction("update");
		getPds().objectToDB();
		return null;
	}

}
