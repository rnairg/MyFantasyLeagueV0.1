package com.mfl.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table (name="PLAYER_MASTER")
public class Player {
	
	@Id
	@Column (name = "PLAYER_ID")
	private int id;
	
	@Column (name = "PLAYER_NAME")
	private String name;
	
	@Column (name = "PLAYER_CATEGORY")
	private String category;
	
	@Column (name = "PLAYER_IPL_TEAM")
	private String iplTeam;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIplTeam() {
		return iplTeam;
	}
	public void setIplTeam(String iplTeam) {
		this.iplTeam = iplTeam;
	}
	
	public Player(int id, String name,String category, String iplTeam)
	{
		setId(id);
		setName(name);
		setCategory(category);
		setIplTeam(iplTeam);
	}
	public Player() {
		
	}
	@XmlRootElement(name="players")
	public static class Players {
		
		ArrayList<Player> players = new ArrayList<Player>();
		public ArrayList<Player> getPlayers() {
			return players;
		}
		
		@XmlElement(name="player")
		public void setPlayers(ArrayList<Player> players) {
			this.players = players;
		}
		
		public void displayPlayers()
		{
			System.out.println("Players:"+getPlayers().size());
			for(int i=0;i<getPlayers().size();i++)
			{
				System.out.println("------\nID = "+getPlayers().get(i).getId()+
						"\nName = "+getPlayers().get(i).getName()+
						"\nCategory = "+getPlayers().get(i).getCategory()+
						"\nIPL Team = "+getPlayers().get(i).getIplTeam());
			}
		}

	}
	
}
