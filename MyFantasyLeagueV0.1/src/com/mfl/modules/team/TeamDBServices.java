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
			s.save(teams.getTeams().get(i));
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
