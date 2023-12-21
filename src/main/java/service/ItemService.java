package service;

import java.util.ArrayList;
import java.util.List;

import domain.Item;

public class ItemService {
	
	public static List<Item> items = new ArrayList<>();
	
	public static List<Item> getItemList(Item item){
		for(Item item1 : items ) {
			if(item1.getName().equals(item.getName())) {
				item1.setUnit(item.getUnit());
				return items;
			}			
		}
		items.add(item)	;	
		return items;
	}
	
	
	
	
	
	
}
