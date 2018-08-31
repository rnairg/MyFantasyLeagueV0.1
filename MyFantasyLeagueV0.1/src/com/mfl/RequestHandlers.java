package com.mfl;

import java.util.Scanner;

import com.mfl.modules.Modules;
import com.mfl.utils.CommonUtilities;

public class RequestHandlers {

	private Modules playerModule;
	private Modules teamModule;
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

	public Modules getTeamModule() {
		return teamModule;
	}

	public void setTeamModule(Modules teamModule) {
		this.teamModule = teamModule;
	}

	
	public void handleRequest(String choice)
	{
		System.out.println("You Chose via Spring: "+choice);
		if(choice.equals("Add a Player"))
		{
			getPlayerModule().create(getGda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("Submit a Team"))
		{
			getTeamModule().create(getTgda().acquireXMLResourceByPath());
			CommonUtilities.displayMenu();
			
		}
		if(choice.equals("View Teams"))
		{
			getTeamModule().read();
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
	}

}
