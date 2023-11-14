package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Player;
import domain.Team;

public class PlayerDaoImpl implements PlayerDao {
	DataSource ds;

	public PlayerDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Player> findAll() {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "SELECT" + " players.id, players.name, players.teamId,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			System.out.println("raegaegareg");
			e.printStackTrace();
		}
		return players;
	}

	private Player mapToPlayer(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		Integer teamId = (Integer) rs.getObject("teamId");
		Date birthday = rs.getTimestamp("birthday");
		String position = rs.getString("position");
		int battingAverage = rs.getInt("battingAverage");
		Integer stamina = (Integer) rs.getObject("stamina");
		Integer salary = (Integer) rs.getObject("salary");
		String team_name = rs.getString("team_name");
		String place = rs.getString("place");
		Date established = rs.getTimestamp("established");
		int victory = rs.getInt("victory");
		int win = rs.getInt("win");
		Team team = new Team(team_name, place, established, victory, win);
		Player player = new Player(id, name, teamId, team, birthday, position, battingAverage, stamina, salary);
		return player;
	}

	@Override
	public List<Player> findPlayersByTeam(Integer teamId) {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " players.id, players.name, players.teamId,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.teamId = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			stmt.setObject(1, teamId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}
		return players;

	}

	@Override
	public List<Player> findPlayersByPosition(String position) {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " players.id, players.name, players.teamId,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.position = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			stmt.setString(1, position);
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}
		return players;

	}

}
