package com.mfl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class CommonUtilities {
	
	


	public CommonUtilities() {}
	

	public static Boolean isInEnum(String s, Class<?extends Enum<?>> choiceList)//Checks if a String is a part of an enum
	{
		//String [] cl = Arrays.stream(choiceList.getEnumConstants()).map(Enum::name).toArray(String[]::new);
		for(Object i:choiceList.getEnumConstants())
		{
			if(s.equals(i.toString()))
			{
				return true;
			}
		}
		return false;
	}
	public static ArrayList<String> readNodeListMap(HashMap<String,NodeList> nodeListMap, String module)
	{
		if(module.equals("player"))
		{
			return parseplayers(nodeListMap);
		}
		else if(module.equals("team"))
		{
			return parseteams(nodeListMap);
		}
		else
		{
			return null;
		}
	}
	public static ArrayList<String> parseplayers(HashMap<String,NodeList> nodeListMap)
	{
		ArrayList<String> players = new ArrayList<String>();
		String player;
		for(String id:nodeListMap.keySet())
		{
			player = id;
			NodeList playerNodeList = nodeListMap.get(id);
			for(int i =0; i<playerNodeList.getLength(); i++)
			{
				Node playerNode = playerNodeList.item(i);
				if(playerNode.getNodeType()==Node.ELEMENT_NODE)
				{
					Element playerElement = (Element) playerNode;
					player = player +"|"+playerElement.getTagName().trim()+":"+playerElement.getTextContent();
				}
			}
			players.add(player);
		}
		return players;
		
	}
	public static ArrayList<String> parseteams(HashMap<String,NodeList> nodeListMap)
	{
		ArrayList<String> teams = new ArrayList<String>();
		String team = "Adding Team is still under Construction";
		for(String id:nodeListMap.keySet())
		{
			team = id;
			NodeList teamNodeList = nodeListMap.get(id);
			for(int i =0; i<teamNodeList.getLength(); i++)
			{
				Node teamNode = teamNodeList.item(i);
				if(teamNode.getNodeType()==Node.ELEMENT_NODE)
				{
					Element teamElement = (Element) teamNode;
					team = team +"|"+teamElement.getTagName().trim()+":"+teamElement.getTextContent();
				}
			}
			teams.add(team);
		}
	    return teams;
		
	}
	public static HashMap<String, NodeList> extractDataFromParsedXML(Document inputDoc, String module)
	{
		HashMap<String,NodeList> extractedDataMap = new HashMap<String,NodeList>();
		
		NodeList List = inputDoc.getElementsByTagName(module);
		for(int i=0;i<List.getLength();i++)
		{
			Node node=List.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
			   Element element = (Element) node;
			   String id = element.getAttribute("id");
			   NodeList nodeDetailsList = element.getChildNodes();
			   extractedDataMap.put(id,nodeDetailsList);
			}
		}
		return extractedDataMap;
	}
	
	public static void displayMenu()
	{
		System.out.println("What would you like to do:\n");
		System.out.println("---Team Options---\n");
		System.out.println("a. Submit a Team\n");
		System.out.println("b. View Teams\n");
		System.out.println("c. Update Teams\n");
		System.out.println("d. Delete Teams\n");
		System.out.println("---Player Options---\n");
		System.out.println("e. Add a Player\n");
		System.out.println("f. View Players\n");
		System.out.println("g. Update Players\n");
		System.out.println("h. Delete Players\n");
		System.out.println("---Match Options---\n");
		System.out.println("i. Add a Match\n");
		System.out.println("j. View Matches\n");
		System.out.println("k. Update Matches\n");
		System.out.println("l. Delete Matches\n");
		System.out.println("---IPL Team Options---\n");
		System.out.println("m. Submit a IPL Team\n");
		System.out.println("n. View IPL Teams\n");
		System.out.println("o. Update IPL Teams\n");
		System.out.println("p. Delete IPL Teams\n");
		System.out.println("---Player Stat Options---\n");
		System.out.println("q. Submit a Player Stat\n");
		System.out.println("r. View Player Stat\n");
		System.out.println("s. Update Player Stat\n");
		System.out.println("t. Delete Player Stat\n");
	}
}
