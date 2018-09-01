package com.mfl.models;

import java.util.ArrayList;

//import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MATCH_MASTER")
public class Match {
	
	@Id @GeneratedValue
	@Column (name="MATCH_ID")
	private int id;
	@Column (name="TEAM_ONE")
	private String teamOne;
	@Column (name="TEAM_TWO")
	private String teamTwo;
	@Column (name="SCORE_ONE")
	private int scoreOne;
	@Column (name="SCORE_TWO")
	private int scoreTwo;
	@Column (name="WICKET_ONE")
	private int wicketOne;
	@Column (name="WICKET_TWO")
	private int wicketTwo;
	/*@OneToMany
	@JoinColumn (name="PLAYER_STATS_ID")
	private Collection<PlayerStats> playerStats;*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamOne() {
		return teamOne;
	}
	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}
	public String getTeamTwo() {
		return teamTwo;
	}
	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}
	public int getScoreOne() {
		return scoreOne;
	}
	public void setScoreOne(int scoreOne) {
		this.scoreOne = scoreOne;
	}
	public int getScoreTwo() {
		return scoreTwo;
	}
	public void setScoreTwo(int scoreTwo) {
		this.scoreTwo = scoreTwo;
	}
	public int getWicketOne() {
		return wicketOne;
	}
	
	public void setWicketOne(int wicketOne) {
		this.wicketOne = wicketOne;
	}
	
	public int getWicketTwo() {
		return wicketTwo;
	}
	public void setWicketTwo(int wicketTwo) {
		this.wicketTwo = wicketTwo;
	}
	/*public Collection<PlayerStats> getPlayerStats() {
		return playerStats;
	}
	public void setPlayerStats(Collection<PlayerStats> playerStats) {
		this.playerStats = playerStats;
	}*/
	@XmlRootElement(name = "matches")
	public static class Matches{
		
		private ArrayList<Match> matches= new ArrayList<>();

		public ArrayList<Match> getMatches() {
			return matches;
		}
		@XmlElement(name="match")
		public void setMatches(ArrayList<Match> matches) {
			this.matches = matches;
		}
		
		
	}
}
