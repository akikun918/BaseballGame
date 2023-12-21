package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Team;

public class TeamDaoImpl implements TeamDao{


	DataSource ds;

	public TeamDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	
	@Override
	public Team findTeamByTeamId(int teamId) {
		Team team =  new Team();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " teams.id, teams.name ," + " teams.victory, teams.win" + " FROM teams WHERE teams.id = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, teamId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int victory = rs.getInt("victory");
				int win = rs.getInt("win");
				team.setId(teamId);
				team.setName(name);
				team.setVictory(victory);
				team.setWin(win);
			}
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}
		return team;

	}

	
	@Override
	public List<Team> findTeam() {
		List<Team> teams = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " teams.id, teams.name ," + " teams.victory, teams.win" + " FROM teams";
			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {

				Integer teamId = (Integer) rs.getObject("id");
				String name = rs.getString("name");
				int victory = rs.getInt("victory");
				int win = rs.getInt("win");
				Team team = new Team();
				team.setId(teamId);
				team.setName(name);
				team.setVictory(victory);
				team.setWin(win);

				teams.add(team);
			}
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}
		return teams;

	}
	
	
	@Override
	public void addWin(Integer teamId) {

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "UPDATE teams SET win = win + 1 WHERE id = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			stmt.setObject(1, teamId, Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}

	}
	
	
	
	
}
