package dao;

import java.util.List;

import domain.Item;

public interface ItemDao {
	
	
	List<Item> findAllItems();
	
	Item findItemByName(String name);
	
	Item findItemById(int id);
	
	
	
	
	
	
}
