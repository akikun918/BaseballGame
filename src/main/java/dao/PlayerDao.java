package dao;

import java.util.List;

import domain.Player;


public interface PlayerDao {
	
	List<Player> findAll();
	List<Player> findPlayersByTeam(Integer teamId);
	List<Player> findPlayersByPosition(String position);

}
