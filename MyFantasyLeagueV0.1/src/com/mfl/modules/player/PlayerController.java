package com.mfl.modules.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfl.models.Player.Players;
import com.mfl.modules.Modules;


@RestController
public class PlayerController {
	
	@Autowired
	private Modules playerModule;

	@RequestMapping("/players")
	public Players getAllPlayers()
	{
		
		return (Players) playerModule.read();
		
	}
	
	@RequestMapping("/players/player/{id}")
	public Players getPlayer(@PathVariable("id") int id)
	{
		
		return (Players) playerModule.read(id);
		
	}
	

}
