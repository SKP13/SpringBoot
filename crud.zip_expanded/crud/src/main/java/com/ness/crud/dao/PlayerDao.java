package com.ness.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ness.crud.model.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, String>{

	@Query("from Player p where p.status= :status")
	public List<Player> pendingPlayerDeDeBhai(String status);
	
	@Transactional //query start end karna padta hai. toh isliye yeh.
	 @Modifying //whenever we use DML(update,delete,insert) query then use this annotations. kyuki khudki query likh rahe hum.  
	@Query("update Player p set p.status='alloted', p.team=:team  where p.email= :email")
	public void allotPlayer(String email,String team);
	
	//@Query("from Player p where p.team= :team")
	public  List<Player> findByTeam(String team);
		// TODO Auto-generated method stub
	
	@Query("select p.team from Player p")
	public List<String>getAllTeam();

	
		

		
	


}

