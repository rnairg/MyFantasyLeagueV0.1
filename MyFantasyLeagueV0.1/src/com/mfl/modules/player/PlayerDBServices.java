package com.mfl.modules.player;



import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mfl.models.Player;
import com.mfl.models.Player.Players;
//import com.mfl.modules.player.models.Players;
import com.mfl.modules.DBServices;

public class PlayerDBServices implements DBServices {
	
	private Players players;
	
	private String action;
	
	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	private SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public Players getPlayers() {
		return players;
	}


	public void setPlayers(Players players) {
		this.players = players;
	}


	@Override
	public Boolean objectToDB() {
		Session s = sf.openSession();
		s.beginTransaction();
		System.out.println("Check point 1");
		for(Player player:players.getPlayers())
		{
			System.out.println("Action is:"+getAction());
			if(getAction().equals("create"))
			{
			s.save(player);
			}
			else if(getAction().equals("update"))
			{
			s.update(player);
			}
			else if(getAction().equals("delete"))
			{
			s.delete(player);
			}
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		//System.out.println("In object to db");
		//getPlayers().displayPlayers();
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject(int key) {
		Session s = sf.openSession();
		s.beginTransaction();
		players.setPlayers((ArrayList<Player>) s.createQuery("from Player").list());
		return null;
	}
	
	
	

}
