package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admin;
import domain.Item;

public class AdminDaoImpl implements AdminDao {

	DataSource ds;

	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Admin findByLoginIdAndLoginPass(String loginId, String loginPass) {

		Admin admin = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM admins WHERE loginId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			if (rs.next()) {
				if (BCrypt.checkpw(loginPass, rs.getString("loginPass"))) {
					admin = new Admin(loginId, loginPass, rs.getInt("point"), rs.getInt("エナジードリンク"),
							rs.getInt("ドーピング"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean register(Admin admin) {
		if (admin.getLoginId().isBlank() || admin.getLoginPass().isBlank()) {
			return false;
		}
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO admins (loginId, loginPass , point, エナジードリンク, ドーピング) VALUES (?, ?, 100, 2, 2 )";
			PreparedStatement stmt = con.prepareStatement(sql);
			String hashed = BCrypt.hashpw(admin.getLoginPass(), BCrypt.gensalt());
			stmt.setString(1, admin.getLoginId());
			stmt.setString(2, hashed);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public int getPoint(String loginId) {
		int point = 0;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM admins WHERE loginId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			// ResultSetからの変換
			if (rs.next()) {
				point = rs.getInt("point");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return point;
	}

//	@Override
//	public void setPoint(Admin admin) {
//		try (Connection con = ds.getConnection()) {
//			String sql = "UPDATE admins SET point = ? WHERE loginId = ? ";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setObject(1, admin.getPoint(), Types.INTEGER);
//			stmt.setString(2, admin.getLoginId());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println("1");
//			e.printStackTrace();
//		}
//	}

//	@Override
//	public void usePoint(Admin admin) {
//
//		try (Connection con = ds.getConnection()) {
//			String sql = "UPDATE admins SET point = ? WHERE loginId = ? ";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setObject(1, admin.getPoint(), Types.INTEGER);
//			stmt.setString(2, admin.getLoginId());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println("1");
//			e.printStackTrace();
//		}
//		
//	}

	@Override
	public void setAll(Admin admin) {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE admins SET point = ? , エナジードリンク = ? , ドーピング = ? WHERE loginId = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, admin.getPoint(), Types.INTEGER);
			stmt.setObject(2, admin.getDrink(), Types.INTEGER);
			stmt.setObject(3, admin.getDope(), Types.INTEGER);
			stmt.setString(4, admin.getLoginId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("1");
			e.printStackTrace();
		}

	}

	@Override
	public void createData(String loginId) {
		try (Connection con = ds.getConnection()) {
			String sql = "CREATE TABLE " + loginId + "players LIKE defaultPlayers;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			String sql1 = "INSERT INTO " + loginId + "players SELECT * FROM defaultPlayers";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.executeUpdate();
			String sql2 = "CREATE TABLE " + loginId + "teams LIKE defaultteams;";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.executeUpdate();
			String sql3 = "INSERT INTO " + loginId + "teams SELECT * FROM defaultteams";
			PreparedStatement stmt3 = con.prepareStatement(sql3);
			stmt3.executeUpdate();

		} catch (Exception e) {
			System.out.println(1111);
			e.printStackTrace();
		}

	}

	@Override
	public void load(String loginId) {
		try (Connection con = ds.getConnection()) {
			String sql = "TRUNCATE players";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			String sql1 = "TRUNCATE teams";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.executeUpdate();
			String sql2 = "INSERT INTO players SELECT * FROM " + loginId + "players ";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.executeUpdate();
			String sql3 = "INSERT INTO teams SELECT * FROM " + loginId + "teams ";
			PreparedStatement stmt3 = con.prepareStatement(sql3);
			stmt3.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(String loginId) {
		try (Connection con = ds.getConnection()) {
			String sql = "TRUNCATE " + loginId + "players ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			String sql1 = "TRUNCATE " + loginId + "teams";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.executeUpdate();
			String sql2 = "INSERT INTO " + loginId + "players  SELECT * FROM players";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.executeUpdate();
			String sql3 = "INSERT INTO " + loginId + "teams SELECT * FROM teams";
			PreparedStatement stmt3 = con.prepareStatement(sql3);
			stmt3.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reset(String loginId) {
		try (Connection con = ds.getConnection()) {
			String sql = "TRUNCATE " + loginId + "players";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			String sql2 = "INSERT INTO " + loginId + "players " + " SELECT * FROM defaultPlayers";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.executeUpdate();
			String sql3 = "TRUNCATE players";
			PreparedStatement stmt3 = con.prepareStatement(sql3);
			stmt3.executeUpdate();
			String sql4 = "INSERT INTO players SELECT * FROM defaultPlayers";
			PreparedStatement stmt4 = con.prepareStatement(sql4);
			stmt4.executeUpdate();

			String sql5 = "TRUNCATE " + loginId + "teams";
			PreparedStatement stmt5 = con.prepareStatement(sql5);
			stmt5.executeUpdate();
			String sql6 = "INSERT INTO " + loginId + "teams " + " SELECT * FROM defaultteams";
			PreparedStatement stmt6 = con.prepareStatement(sql6);
			stmt6.executeUpdate();
			String sql7 = "TRUNCATE teams";
			PreparedStatement stmt7 = con.prepareStatement(sql7);
			stmt7.executeUpdate();
			String sql8 = "INSERT INTO teams SELECT * FROM defaultteams";
			PreparedStatement stmt8 = con.prepareStatement(sql8);
			stmt8.executeUpdate();

			String sql9 = "UPDATE admins SET point = 0 , エナジードリンク = 2 , ドーピング = 2 WHERE loginId = ? ";
			PreparedStatement stmt9 = con.prepareStatement(sql9);
			stmt9.setString(1, loginId);
			stmt9.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setUnit(String loginId, Item item ) {
		try (Connection con = ds.getConnection()) {
			String sql = null;
			if(item.getName().equals("エナジードリンク")) {
				sql = "UPDATE admins SET エナジードリンク = エナジードリンク + ? WHERE loginId = ? ";
			}else {
				sql = "UPDATE admins SET ドーピング = ドーピング + ? WHERE loginId = ? ";
			}
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, item.getUnit(), Types.INTEGER);
			stmt.setString(2, loginId);
			stmt.executeUpdate();
			
//			String sql = "UPDATE admins SET " + item.getName() + " = " + item.getName() + "  + ? WHERE loginId = ? ";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setObject(1, item.getName(), Types.INTEGER);
//			stmt.setObject(2, item.getName(), Types.INTEGER);
//			stmt.setObject(3, item.getUnit(), Types.INTEGER);
//			stmt.setString(4, loginId);
//			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
