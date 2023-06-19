package com.ness.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ness.crud.model.Player;

@Service
public interface PlayerService {

	public Player savePlayer(Player player);
	public List<Player> findAllPlayers();
	public List<Player> pendingPlayerDeDeBhai(String status);
	public String allotPlayer(String email, String team);
	public List<Player> findByTeam(String team);
	public List<String>getAllTeam();
	
	
}

