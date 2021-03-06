package com.mfl.modules.iplteam;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.mfl.models.IplTeam;
import com.mfl.models.IplTeam.IplTeams;
import com.mfl.modules.DBServices;

public class IplTeamDBServices implements DBServices {
	
	private IplTeams iplTeams;
	public IplTeams getIplTeams() {
		return iplTeams;
	}

	public void setIplTeams(IplTeams iplteams) {
		this.iplTeams = iplteams;
	}

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

	@Override
	public Boolean objectToDB() {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();
		for(int i=0;i<iplTeams.getIplTeams().size();i++)
		{
			System.out.println("Action is:"+getAction());
			if(getAction().equals("create"))
			{
			s.save(iplTeams.getIplTeams().get(i));
			}
			else if(getAction().equals("update"))
			{
				System.out.println("Here");
			s.update(iplTeams.getIplTeams().get(i));
			}
			else if(getAction().equals("delete"))
			{
			s.delete(iplTeams.getIplTeams().get(i));
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
		iplTeams.setIplTeams((ArrayList<IplTeam>) s.createQuery("from IplTeam t where t.id="+key).list());
		s.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean dBToObject() {
		Session s = getSessionFactory().openSession();
		s.beginTransaction();
		iplTeams.setIplTeams((ArrayList<IplTeam>) s.createQuery("select t.id as id, t.name as name from IplTeam t").setResultTransformer(Transformers.aliasToBean(IplTeam.class)).list());
		s.close();
		return null;
	}

}
