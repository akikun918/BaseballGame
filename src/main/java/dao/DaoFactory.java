package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static PlayerDao createMemberDaoImpl() {

		return new PlayerDaoImpl(getDataSource());

	}

	public static AdminDao createAdminDaoImpl() {

		return new AdminDaoImpl(getDataSource());

	}
	
	public static ItemDao createItemDaoImpl() {

		return new ItemDaoImpl(getDataSource());

	}
	
	public static TeamDao createTeamDaoImpl() {

		return new TeamDaoImpl(getDataSource());

	}
	
	
	public static DataSource getDataSource() {
		DataSource ds = null;
		InitialContext ctx = null;

		// try(ctx = new InitialContext()) {
		try {
			System.out.println("DaoFactoryのtry内のds = (DataSource)前");
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/baseball_db");
			System.out.println("DaoFactoryのtry内のds = (DataSource)後");
		} catch (NamingException e) {
			System.out.println("DaoFactoryのcatch内");
			e.printStackTrace();
		} finally {
			try {
				if (ctx != null) {
					ctx.close();
				}
			} catch (NamingException e) {
				System.out.println("ctx.close()のcatch内");
				e.printStackTrace();
			}
		}
		return ds;

	}

}
