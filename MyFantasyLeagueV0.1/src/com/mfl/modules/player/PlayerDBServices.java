package com.mfl.modules.player;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.mfl.models.Player;
import com.mfl.models.Player.Players;
import com.mfl.modules.DBServices;

public class PlayerDBServices implements DBServices {
	
	private Players players;
	
	private String action;
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}	
	public Players getPlayers() {
		return players;
	}


	public void setPlayers(Players players) {
		this.players = players;
	}


	@Override
	public Boolean objectToDB() {
		Session s = getSessionFactory().openSession();
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
		//System.out.println("In object to db");
		//getPlayers().displayPlayers();
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject(int key) {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();
		players.setPlayers((ArrayList<Player>) s.createQuery("from Player  p where p.id="+key).list());
		s.close();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject() {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();	
		players.setPlayers((ArrayList<Player>)s.createQuery("select p.id as id, p.name as name from Player p").setResultTransformer(Transformers.aliasToBean(Player.class)).list());;
		s.close();
		return null;
	}
	
	
	

}
