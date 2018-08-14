package com.mfl.models;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name="TEAM_MASTER")
public class Team { //Model for Table TEAM_MASTER

	@Id @GeneratedValue
	@Column (name="TEAM_ID")
	private int id;
	@Column (name="TEAM_NAME")
	private String name;
	@Column (name="TEAM_OWNER")
	private String owner;
	@ElementCollection
	@JoinTable(name="TEAM_COMP",
			   joinColumns=@JoinColumn(name="TEAM_ID")
	)
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns= {@Column(name="TEAM_COMP_ID")},generator="hilo-gen",type=@Type(type="long"))
	private Collection<TeamComp> teamComp = new ArrayList<TeamComp>();
	
	public Collection<TeamComp> getTeamComp() {
		return teamComp;
	}
	@XmlElementWrapper(name = "players")//Annotation to Bind Team Comp under Players Tag of Team XML
	@XmlElement(name = "player")
	public void setTeamComp(Collection<TeamComp> teamComp) {
		this.teamComp = teamComp;
	}
			
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Embeddable
	@Table (name="TEAM_COMP")
	public static class TeamComp{ //Model for Table TEAM_COMP
		
		@Column(name="PLAYER_ID")
		private int playerId;
		public int getPlayerId() {
			return playerId;
		}
		@XmlElement(name ="id")
		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}

	}
	@XmlRootElement(name = "teams") //Model Class for Teams XML
	public static class Teams{
		
		private ArrayList<Team> teams = new ArrayList<Team>();
		
		public ArrayList<Team> getTeams() {
			return teams;
		}

		@XmlElement(name = "team")
		public void setTeams(ArrayList<Team> teams) {
			this.teams = teams;
		}
		
		public void displayTeams()
		{
			System.out.println("Teams:"+getTeams().size());
			for(int i=0;i<getTeams().size();i++)
			{
				System.out.println("------\nID = "+getTeams().get(i).getId()+
						"\nName = "+getTeams().get(i).getName()+
						"\nOwner = "+getTeams().get(i).getOwner()+
						"\nTeam Composition ="+getTeams().get(i).getTeamComp().size());
				for(int j=0;j<getTeams().get(i).getTeamComp().size();j++)
				{
					//System.out.println("Comp ID:"+((ArrayList<TeamComp>) getTeams().get(i).getTeamComp()).get(j).getId());
					//System.out.println("Team ID:"+((ArrayList<TeamComp>) getTeams().get(i).getTeamComp()).get(j).getTeamId());
					//System.out.println("Player ID:"+((ArrayList<TeamComp>) getTeams().get(i).getTeamComp()).get(j).getPlayerId());
					System.out.println("Data Load Complete... Display Object are WIP");
				}
			}
						
		}
		
		
	}
	
}
