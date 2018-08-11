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
	public Boolean add() {
		
		return null;
	}

	@Override
	public Boolean delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void extract() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Boolean add(Document xmlResource) {
		
		
		//((PlayerDBServices) getPds()).setPlayers(((PlayerXMLServices) getPxs()).xMLtoObject(xmlResource));
		Players players = getPxs().xMLtoObject(xmlResource);
		getPds().setPlayers(players);
		getPds().objectToDB();
		
		return null;
	}

}
