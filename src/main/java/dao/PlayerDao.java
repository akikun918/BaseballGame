package dao;

import java.util.List;

import domain.Player;

public interface PlayerDao {

	List<Player> findAll();

	List<Player> findPlayersByTeam(Integer teamId);

	List<Player> findPlayersByPosition(String position);

//	List<Team> findTeam();

	List<Player> findPitchersInTheTeam(Integer teamId);

	Player findPlayerById(Integer playerId);

	List<Player> findAllExceptMyTeam();

	List<Player> findMyTeamPlayers();

	List<Player> findFieldplayersByTeam(Integer teamId);

//	void reset();

	void trade(Integer teamId, Integer id);

//	void addWin(Integer teamId);

//	void save();

//	void load();

	void setFeel(Integer id);

	List<Player> findPlayersByName(String name);

	void useDoping(Player player);

	boolean createPlayer(Player player);

	void setPlayer(Player player);
	
	void deletePlayer(Player player);
	
	List<Player> findTradePlayers(String[] arrayPosition, int moneyB , int moneyT, int battingB, int battingT, int defenseB, int defenseT);


}
