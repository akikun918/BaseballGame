package dao;

import domain.Admin;
import domain.Item;

public interface AdminDao {

	Admin findByLoginIdAndLoginPass(String loginId, String loginPass);

	boolean register(Admin admin);

	int getPoint(String loginId);

//	void setPoint(Admin admin);

	void createData(String loginId);

	void load(String loginId);

	void save(String loginId);

	void reset(String loginId);

	void setUnit(String loginId, Item item);

//	void usePoint(Admin admin);

	void setAll(Admin admin);
}
