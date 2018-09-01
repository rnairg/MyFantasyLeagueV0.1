package com.mfl;

import java.util.Scanner;

import com.mfl.modules.Modules;
import com.mfl.utils.CommonUtilities;

public class RequestHandlers {

	private Modules playerModule;
	private Modules teamModule;
	private Modules iplTeamModule;
	private Modules matchModule;
	private GenericDataAcquirer gda;
	private GenericDataAcquirer tgda;
	private GenericDataAcquirer mgda;
	private GenericDataAcquirer itgda;
	
	public GenericDataAcquirer getMgda() {
		return mgda;
	}

	public void setMgda(GenericDataAcquirer mgda) {
		this.mgda = mgda;
	}
	
	public Modules getMatchModule() {
		return matchModule;
	}

	public void setMatchModule(Modules matchModule) {
		this.matchModule = matchModule;
	}

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

	public Modules getTeamModule() {
		return teamModule;
	}

	public void setTeamModule(Modules teamModule) {
		this.teamModule = teamModule;
	}
	public Modules getIplTeamModule() {
		return iplTeamModule;
	}
	
	public void setIplTeamModule(Modules iplteamModule) {
		this.iplTeamModule = iplteamModule;
	}

	public GenericDataAcquirer getItgda() {
		return itgda;
	}

	public void setItgda(GenericDataAcquirer itgda) {
		this.itgda = itgda;
	}

	
	public void handleRequest(String choice)
	{
		System.out.println("You Chose via Spring: "+choice);
		/*+++++++++++++PLAYER++++++++++++++*/
		if(choice.equals("Add a Player"))
		{
			getPlayerModule().create(getGda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("View Players"))
		{
			getPlayerModule().read();
			System.out.println("Which Player would you like to view\n");
			Scanner sc1 = new Scanner(System.in);
			int c = Integer.parseInt(sc1.next());
			getPlayerModule().read(c);
			CommonUtilities.displayMenu();
			//sc1.close();
			
		}
		if(choice.equals("Update Players"))
		{
			getPlayerModule().update(getGda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Delete Players"))
		{
			getPlayerModule().delete(getGda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		/*+++++++++++++TEAM++++++++++++++*/
		if(choice.equals("Submit a Team"))
		{
			getTeamModule().create(getTgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("View Teams"))
		{
			getTeamModule().read();
			System.out.println("Which Team would you like to view\n");
			Scanner sc1 = new Scanner(System.in);
			int c = Integer.parseInt(sc1.next());
			getTeamModule().read(c);
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Update Teams"))
		{
			getTeamModule().update(getTgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Delete Teams"))
		{
			getTeamModule().delete(getTgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		/*+++++++++++++IPL TEAM++++++++++++++*/
		if(choice.equals("Submit a IPL Team"))
		{
			getIplTeamModule().create(getItgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("View IPL Teams"))
		{
			getIplTeamModule().read();
			System.out.println("Which IPL Team would you like to view\n");
			Scanner sc1 = new Scanner(System.in);
			int c = Integer.parseInt(sc1.next());
			getIplTeamModule().read(c);
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Update IPL Teams"))
		{
			getIplTeamModule().update(getItgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Delete IPL Teams"))
		{
			getIplTeamModule().delete(getItgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		/*+++++++++++++IPL MATCH++++++++++++++*/		
		if(choice.equals("Add a Match"))
		{
			getMatchModule().create(getMgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		
		if(choice.equals("View Matches"))
		{
			getMatchModule().read();
			System.out.println("Which Match would you like to view\n");
			Scanner sc1 = new Scanner(System.in);
			int c = Integer.parseInt(sc1.next());
			getMatchModule().read(c);
			CommonUtilities.displayMenu();
			//sc1.close();
			
		}
		if(choice.equals("Update Matches"))
		{
			getMatchModule().update(getMgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Delete Matches"))
		{
			getMatchModule().delete(getMgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		
	}

	

}
