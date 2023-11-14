package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scores {

	public static Random rand = new Random();

	public static int getScore() {
		int score = rand.nextInt(25);
		if (score <= 20 && score >= 6) {
			score = 0;
		} else if (score >= 20 && score <= 23) {
			score = 1;
		} else if (score >= 24) {
			score = 2;
		}
		return score;
	}

	public static List<Integer> scores = new ArrayList<>();

	public static void addScore(int score) {
		if (scores.size() > 9) {
			scores.clear();
		}
		scores.add(score);
	}

	public static List<Integer> comScores = new ArrayList<>();

	public static void addComScore(int comScore) {
		if (comScores.size() > 9) {
			comScores.clear();
		}
		comScores.add(comScore);
	}

	public static int getTotal() {
		int total = 0;
		for (int score : scores) {
			total += score;
		}
		return total;
	}
	
	public static int getComTotal() {
		int comTotal = 0;
		for (int comScore : comScores) {
			comTotal += comScore;
		}
		return comTotal;
	}
	
	

}
