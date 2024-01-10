package service;

import java.util.ArrayList;
import java.util.List;

public class TrainningServise {

	
	public static List<String> results = new ArrayList<>();
	
	public static List<String> returnResults(){
		double ofense = Math.random();
		String result = null;		
		if (ofense < 0.5) {
			result = "成功";
		} else {
			result = "失敗";
		}
		results.add(result);
		return results;
	}
	
	
}
