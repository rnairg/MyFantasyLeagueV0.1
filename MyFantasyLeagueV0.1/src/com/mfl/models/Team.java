package com.mfl.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table (name="TEAM_MASTER")
public class Team { //Model for Table TEAM_MASTER

	@Id
	@Column (name="TEAM_ID")
	protected int id;
	@Column (name="TEAM_NAME")
	private String name;
	@Column (name="TEAM_OWNER")
	private String owner;
	@Transient
	private ArrayList<TeamComp> teamComp = new ArrayList<TeamComp>();
	
	@XmlElementWrapper(name = "players")
	@XmlElement(name = "player")
	public void setTeamComp(ArrayList<TeamComp> teamComp) {
		this.teamComp = teamComp;
	}

	public ArrayList<TeamComp> getTeamComp() {
		return teamComp;
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
	
	@Entity
	@Table (name="TEAM_COMP")
	public static class TeamComp{ //Model for Table TEAM_COMP
		
		@Id
		@Column(name="TEAM_COMP_ID")
		private String id;
		@Column(name="TEAM_ID")
		private int teamId;
		@Column(name="PLAYER_ID")
		private int playerId;
		
		public String getId() {
			return id;
		}
		public void setId(int teamId, int playerId) {
			this.id = teamId+"."+playerId;
		}
		public int getTeamId() {
			return teamId;
		}
		public void setTeamId(int teamId) {
			this.teamId = teamId;
		}
		public int getPlayerId() {
			return playerId;
		}
		@XmlElement(name ="id")
		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}

	}
	@XmlRootElement(name = "teams")
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
					System.out.println("Comp ID:"+getTeams().get(i).getTeamComp().get(j).getId());
					System.out.println("Team ID:"+getTeams().get(i).getTeamComp().get(j).getTeamId());
					System.out.println("Player ID:"+getTeams().get(i).getTeamComp().get(j).getPlayerId());
				}
			}
						
		}
		
		
	}
	
}
