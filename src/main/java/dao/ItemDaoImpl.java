package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Item;

public class ItemDaoImpl implements ItemDao {
	DataSource ds;

	public ItemDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Item> findAllItems() {
		List<Item> items = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " id,  name,  price, detail FROM items ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//	int id = rs.getInt("id");
				//	String name = rs.getString("name");
				//	int price = rs.getInt("price");
				//	String detail = rs.getString("detail");
				//item = new Item(id, name, price, detail, 0);
				//Itemのint unitには何も入れないように、builder()を使用
				Item item = Item.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.price(rs.getInt("price"))
						.detail(rs.getString("detail"))
						.build();
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item findItemByName(String name) {
		Item item = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " id,  name,  price, detail FROM items WHERE name = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				//				int id = rs.getInt("id");
				//				int price = rs.getInt("price");
				//				String detail = rs.getString("detail");
				//				item = new Item(id, name, price, detail, 0);
				//Itemのint unitには何も入れないように、builder()を使用
				item = Item.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.price(rs.getInt("price"))
						.detail(rs.getString("detail"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item findItemById(int id) {
		Item item = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " id,  name,  price, detail FROM items WHERE id = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id,  Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				//Itemのint unitには何も入れないように、builder()を使用
				item = Item.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.price(rs.getInt("price"))
						.detail(rs.getString("detail"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
