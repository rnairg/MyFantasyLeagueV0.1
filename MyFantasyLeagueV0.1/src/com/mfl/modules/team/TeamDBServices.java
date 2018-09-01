package com.mfl.modules.team;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import com.mfl.models.Team;
import com.mfl.models.Team.Teams;
import com.mfl.modules.DBServices;

public class TeamDBServices implements DBServices {
	
	private Teams teams;
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

	//SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	@Override
	public Boolean objectToDB() {
		Session s = getSessionFactory().openSession();
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
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject(int key) {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();
		teams.setTeams((ArrayList<Team>) s.createQuery("from Team t where t.id="+key).list());
		s.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject() {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();
		teams.setTeams((ArrayList<Team>) s.createQuery("select t.id as id, t.name as name from Team t").setResultTransformer(Transformers.aliasToBean(Team.class)).list());
		s.close();
		return null;
	}

}
