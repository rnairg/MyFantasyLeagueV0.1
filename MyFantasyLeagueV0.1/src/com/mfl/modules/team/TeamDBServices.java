package com.mfl.modules.team;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mfl.models.Team.Teams;
import com.mfl.modules.DBServices;

public class TeamDBServices implements DBServices {
	
	private Teams teams;

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	@Override
	public Boolean objectToDB() {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		for(int i=0;i<teams.getTeams().size();i++)
		{
			s.save(teams.getTeams().get(i));
			for(int j=0;j<teams.getTeams().get(i).getTeamComp().size();j++)
			{
				s.save(teams.getTeams().get(i).getTeamComp().get(j));
			}
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		return null;
	}

}
