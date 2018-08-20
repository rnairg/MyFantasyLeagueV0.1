package com.mfl.modules.team;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mfl.models.Team;
import com.mfl.models.Team.Teams;
import com.mfl.modules.DBServices;

public class TeamDBServices implements DBServices {
	
	private Teams teams;
	private String action;
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	@Override
	public Boolean objectToDB() {
		Session s = sf.openSession();
		s.beginTransaction();
		for(int i=0;i<teams.getTeams().size();i++)
		{
			System.out.println("Action is:"+getAction());
			if(getAction().equals("create"))
			{
			s.save(teams.getTeams().get(i));
			}
			else if(getAction().equals("update"))
			{
				System.out.println("Here");
			s.update(teams.getTeams().get(i));
			}
			else if(getAction().equals("delete"))
			{
			s.delete(teams.getTeams().get(i));
			}
			
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject(int key) {
		Session s = sf.openSession();
		s.beginTransaction();
		teams.setTeams((ArrayList<Team>) s.createQuery("from Team").list());
		return null;
	}

}
