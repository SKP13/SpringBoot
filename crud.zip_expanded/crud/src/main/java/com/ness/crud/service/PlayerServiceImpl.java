package com.ness.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.crud.dao.PlayerDao;
import com.ness.crud.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	
	@Autowired
	PlayerDao playerDao;
	

	@Override
	public Player savePlayer(Player player) {	
		player.setStatus("pending");
		player.setTeam("");
		playerDao.save(player);
		return player;
	}

	@Override
	public List<Player> findAllPlayers() {
		
		return playerDao.findAll();
	}
	
	public List<Player> pendingPlayerDeDeBhai(String status){
		
		return playerDao.pendingPlayerDeDeBhai(status);
	}

	@Override
	public String allotPlayer(String email, String team) {
		// TODO Auto-generated method stub
		playerDao.allotPlayer(email, team);
		return "Player Alloted";
		
	}

	@Override
	public List<Player> findByTeam(String team) {
		return playerDao.findByTeam(team);
		
		
	}
	
	public List<String>getAllTeam(){
		return playerDao.getAllTeam();
		
		
	}

	
	

	
	
}
