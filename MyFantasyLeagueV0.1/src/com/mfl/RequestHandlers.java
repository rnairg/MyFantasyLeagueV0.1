package com.mfl;

import com.mfl.modules.Modules;

public class RequestHandlers {

	private Modules playerModule;
	//private Modules teamModule;
	private GenericDataAcquirer gda;
	private GenericDataAcquirer tgda;
	
	public GenericDataAcquirer getTgda() {
		return tgda;
	}

	public void setTgda(GenericDataAcquirer tgda) {
		this.tgda = tgda;
	}

	public GenericDataAcquirer getGda() {
		return gda;
	}

	public void setGda(GenericDataAcquirer gda) {
		this.gda = gda;
	}

	public void setPlayerModule(Modules playerModule) {
		this.playerModule = playerModule;
	}

	public Modules getPlayerModule() {
		return playerModule;
	}

	/*public Modules getTeamModule() {
		return teamModule;
	}

	public void setTeamModule(Modules teamModule) {
		this.teamModule = teamModule;
	}*/

	
	public void handleRequest(String choice)
	{
		System.out.println("You Chose via Spring: "+choice);
		if(choice.equals("Enter a Player"))
		{
			getPlayerModule().add(getGda().acquireXMLResourceByPath());
			
		}
		if(choice.equals("Submit a Team"))
		{
			//getTeamModule().add(getTgda().acquireXMLResourceByPath());
			System.out.println("Team Sumission Under Construction!");
			
		}
	}

}
