package com.mfl.modules.player;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mfl.models.Player;
import com.mfl.models.Player.Players;
//import com.mfl.modules.player.models.Players;
import com.mfl.modules.DBServices;

public class PlayerDBServices implements DBServices {
	
	private Players players;

	
	public Players getPlayers() {
		return players;
	}


	public void setPlayers(Players players) {
		this.players = players;
	}


	@Override
	public Boolean objectToDB() {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		System.out.println("Check point 1");
		for(Player player:players.getPlayers())
		{
			System.out.println("Check point 2");
			s.save(player);
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		//System.out.println("In object to db");
		//getPlayers().displayPlayers();
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}