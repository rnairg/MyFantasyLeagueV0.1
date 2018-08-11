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
	
}
