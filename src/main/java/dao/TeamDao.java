package dao;

import java.util.List;

import domain.Team;

public interface TeamDao {

	Team findTeamByTeamId(int teamId);

	List<Team> findTeam();

	void addWin(Integer teamId);

	
}
