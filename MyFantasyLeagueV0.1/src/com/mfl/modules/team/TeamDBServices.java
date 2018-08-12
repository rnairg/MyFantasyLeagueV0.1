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
			int teamId = (Integer)s.save(teams.getTeams().get(i));
			teams.getTeams().get(i).setId(teamId);
			for(int j=0;j<teams.getTeams().get(i).getTeamComp().size();j++)
				{
					teams.getTeams().get(i).getTeamComp().get(j).setTeamId(teams.getTeams().get(i).getId());
					teams.getTeams().get(i).getTeamComp().get(j).setId(teams.getTeams().get(i).getId(),teams.getTeams().get(i).getTeamComp().get(j).getPlayerId());
					s.save(teams.getTeams().get(i).getTeamComp().get(j));
				}
			
			/*for(int j=0;j<teams.getTeams().get(i).getTeamComp().size();j++)
			{
				s.save(teams.getTeams().get(i).getTeamComp().get(j));
			}*/
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		return null;
	}

}
