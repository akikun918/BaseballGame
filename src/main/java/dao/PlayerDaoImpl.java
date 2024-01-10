package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel, " + " teams.name AS team_name,"
					+ " teams.place, teams.established, " + " teams.victory, teams.win" + " FROM players JOIN teams"
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
		Integer defense = (Integer) rs.getObject("defense");
		Integer salary = (Integer) rs.getObject("salary");
		String feel = rs.getString("feel");
		String team_name = rs.getString("team_name");
		String place = rs.getString("place");
		Date established = rs.getTimestamp("established");
		int victory = rs.getInt("victory");
		int win = rs.getInt("win");

		Team team = new Team(teamId, team_name, place, established, victory, win);
		Player player = new Player(id, name, teamId, team, birthday, position, battingAverage, stamina, salary, feel,
				defense);
		return player;

	}

	@Override
	public List<Player> findPlayersByName(String name) {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " players.id, players.name, players.teamId,  players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.name LIKE ? ";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
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
	public List<Player> findPlayersByTeam(Integer teamId) {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.id, teams.name AS team_name,"
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

			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.id, teams.name AS team_name,"
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

	// @Override
	// public List<Team> findTeam() {
	// List<Team> teams = new ArrayList<>();
	//
	// try (Connection con = ds.getConnection()) {
	// // SQLの準備
	//
	// String sql = "SELECT" + " teams.id, teams.name ," + " teams.victory,
	// teams.win" + " FROM teams";
	// PreparedStatement stmt = con.prepareStatement(sql);
	// // SQLの実行
	// ResultSet rs = stmt.executeQuery();
	// // ResultSetからの変換
	// while (rs.next()) {
	//
	// Integer teamId = (Integer) rs.getObject("id");
	// String name = rs.getString("name");
	// int victory = rs.getInt("victory");
	// int win = rs.getInt("win");
	// Team team = new Team();
	// team.setId(teamId);
	// team.setName(name);
	// team.setVictory(victory);
	// team.setWin(win);
	//
	// teams.add(team);
	// }
	// } catch (Exception e) {
	// System.out.println("1");
	// e.printStackTrace();
	// }
	// return teams;
	//
	// }

	@Override
	public List<Player> findPitchersInTheTeam(Integer teamId) {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備

			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.position = 'P' AND players.teamId = ?";

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
			e.printStackTrace();
		}
		return players;

	}

	@Override
	public Player findPlayerById(Integer playerId) {
		Player player = new Player();

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.name AS team_name,"
					+ " teams.place, teams.established, " + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, playerId, Types.INTEGER);
			// SQLの実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			if (rs.next()) {
				player = mapToPlayer(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public List<Player> findAllExceptMyTeam() {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.name AS team_name,"
					+ " teams.place, teams.established, " + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.id = 1 OR players.teamId = 2 OR players.teamId = 3 OR players.teamId = 4 ORDER BY position ";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return players;
	}

	@Override
	public List<Player> findMyTeamPlayers() {
		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.name AS team_name,"
					+ " teams.place, teams.established, " + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.teamId = 5 ORDER BY position ";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return players;
	}

	// @Override
	// public void reset() {
	// try (Connection con = ds.getConnection()) {
	// String sql = "TRUNCATE players";
	// PreparedStatement stmt = con.prepareStatement(sql);
	// stmt.executeUpdate();
	// String sql2 = "INSERT INTO players SELECT * FROM players2";
	// PreparedStatement stmt2 = con.prepareStatement(sql2);
	// stmt2.executeUpdate();
	// String sql3 = "TRUNCATE teams";
	// PreparedStatement stmt3 = con.prepareStatement(sql3);
	// stmt3.executeUpdate();
	// String sql4 = "INSERT INTO teams SELECT * FROM teams2";
	// PreparedStatement stmt4 = con.prepareStatement(sql4);
	// stmt4.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	@Override
	public void trade(Integer teamId, Integer id) {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE players SET teamId = ? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, teamId, Types.INTEGER);
			stmt.setObject(2, id, Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Override
	// public void addWin(Integer teamId) {
	//
	// try (Connection con = ds.getConnection()) {
	// // SQLの準備
	// String sql = "UPDATE teams SET win = win + 1 WHERE id = ? ";
	// PreparedStatement stmt = con.prepareStatement(sql);
	// // SQLの実行
	// stmt.setObject(1, teamId, Types.INTEGER);
	// stmt.executeUpdate();
	// } catch (Exception e) {
	// System.out.println("1");
	// e.printStackTrace();
	// }
	//
	// }

	// @Override
	// public void save() {
	// try (Connection con = ds.getConnection()) {
	// String sql = "TRUNCATE players4";
	// PreparedStatement stmt = con.prepareStatement(sql);
	// stmt.executeUpdate();
	// String sql1 = "TRUNCATE teams4";
	// PreparedStatement stmt1 = con.prepareStatement(sql1);
	// stmt1.executeUpdate();
	// String sql2 = "INSERT INTO players4 SELECT * FROM players";
	// PreparedStatement stmt2 = con.prepareStatement(sql2);
	// stmt2.executeUpdate();
	// String sql3 = "INSERT INTO teams4 SELECT * FROM teams";
	// PreparedStatement stmt3 = con.prepareStatement(sql3);
	// stmt3.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// @Override
	// public void load() {
	// try (Connection con = ds.getConnection()) {
	// String sql = "TRUNCATE players";
	// PreparedStatement stmt = con.prepareStatement(sql);
	// stmt.executeUpdate();
	// String sql1 = "TRUNCATE teams";
	// PreparedStatement stmt1 = con.prepareStatement(sql1);
	// stmt1.executeUpdate();
	// String sql2 = "INSERT INTO players SELECT * FROM players4";
	// PreparedStatement stmt2 = con.prepareStatement(sql2);
	// stmt2.executeUpdate();
	// String sql3 = "INSERT INTO teams SELECT * FROM teams4";
	// PreparedStatement stmt3 = con.prepareStatement(sql3);
	// stmt3.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	@Override
	public List<Player> findFieldplayersByTeam(Integer teamId) {

		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			// SQLの準備
			String sql = "SELECT" + " players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel," + " teams.id, teams.name AS team_name,"
					+ " teams.place, teams.established," + " teams.victory, teams.win" + " FROM players JOIN teams"
					+ " ON players.teamId = teams.id WHERE players.position != 'P' AND players.teamId = ? ORDER BY position ";
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
	public void setFeel(Integer id) {
		double intFeel = Math.random();
		String feel = null;
		if (intFeel < 0.4) {
			feel = "普通";
		} else if (intFeel < 0.6) {
			feel = "好調";
		} else if (intFeel < 0.8) {
			feel = "不調";
		} else if (intFeel < 0.9) {
			feel = "絶好調";
		} else {
			feel = "絶不調";
		}
		// Random rand = new Random();
		// int intFeel = rand.nextInt(10);
		// String feel = null;
		// if (intFeel >= 0 && intFeel <= 3) {
		// feel = "普通";
		// } else if (intFeel <= 5) {
		// feel = "好調";
		// } else if ( intFeel <= 7) {
		// feel = "不調";
		// } else if (intFeel == 8) {
		// feel = "絶好調";
		// } else {
		// feel = "絶不調";
		// }
		try (Connection con = ds.getConnection()) {
			// String sql = "UPDATE players SET feel = " + feel + " WHERE id = ? ";
			String sql = "UPDATE players SET feel = '" + feel + "' WHERE id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);
			// SQLの実行
			stmt.setObject(1, id, Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("5");
			e.printStackTrace();
		}

	}

	@Override
	public void useDoping(Player player) {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE players SET battingAverage = battingAverage - 2 , defense = defense - 2  WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, player.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean createPlayer(Player player) {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO players (name, teamId, birthday, position, battingAverage, stamina , salary, defense) VALUES (?, 5, ?, ?, ?, ? , 500, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, player.getName());
			stmt.setTimestamp(2, new Timestamp(player.getBirthday().getTime()));
			stmt.setString(3, player.getPosition());
			stmt.setObject(4, player.getBattingAverage(), Types.INTEGER);
			stmt.setObject(5, player.getStamina(), Types.INTEGER);
			stmt.setObject(6, player.getDefense(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void setPlayer(Player player) {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE players SET battingAverage = ? , defense = ?  WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, player.getBattingAverage(), Types.INTEGER);
			stmt.setObject(2, player.getDefense(), Types.INTEGER);
			stmt.setObject(3, player.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePlayer(Player player) {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM players WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, player.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Player> findTradePlayers(String[] arrayPosition, int moneyB, int moneyT, int battingB, int battingT,
			int defenseB, int defenseT) {

		List<Player> players = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String position;
			if (arrayPosition == null) {
				position = "'%%'";
			} else {
				position = "?";
				for (int i = 1; i < arrayPosition.length; i++) {
					position += " OR players.position LIKE ? ";
				}
			}
			String sql = "SELECT players.id, players.name, players.teamId, players.defense,"
					+ " players.birthday, players.position, players.battingAverage,"
					+ " players.stamina, players.salary, players.feel, teams.name AS team_name,"
					+ " teams.place, teams.established, teams.victory, teams.win FROM players JOIN teams "
					// + " ON players.teamId = teams.id WHERE players.position LIKE ? ORDER BY
					// position ";
					+ " ON players.teamId = teams.id WHERE (players.position LIKE " + position
					+ " ) AND players.salary >= ? AND players.salary <= ? AND players.battingAverage >= ? "
					+ " AND players.battingAverage <= ? AND players.defense >= ? AND players.defense <= ? ORDER BY position ";

			PreparedStatement stmt = con.prepareStatement(sql);
			if (arrayPosition != null) {
				stmt.setString(1, arrayPosition[0]);
				for (int i = 1; i < arrayPosition.length; i++) {
					stmt.setString(i + 1, arrayPosition[i]);
				}
			}

			if (arrayPosition == null) {
				stmt.setObject(1, moneyB, Types.INTEGER);
				stmt.setObject(2, moneyT, Types.INTEGER);
				stmt.setObject(3, battingB, Types.INTEGER);
				stmt.setObject(4, battingT, Types.INTEGER);
				stmt.setObject(5, defenseB, Types.INTEGER);
				stmt.setObject(6, defenseT, Types.INTEGER);
			} else {
				stmt.setObject(arrayPosition.length + 1, moneyB, Types.INTEGER);
				stmt.setObject(arrayPosition.length + 2, moneyT, Types.INTEGER);
				stmt.setObject(arrayPosition.length + 3, battingB, Types.INTEGER);
				stmt.setObject(arrayPosition.length + 4, battingT, Types.INTEGER);
				stmt.setObject(arrayPosition.length + 5, defenseB, Types.INTEGER);
				stmt.setObject(arrayPosition.length + 6, defenseT, Types.INTEGER);
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player player = mapToPlayer(rs);
				players.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return players;

	}
}
