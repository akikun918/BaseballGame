package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Player;

public class ScoresServise {
	public static Random rand = new Random();

	//相手と自分の強さを決めるのに使うフィールド
	public static int myOffense = 0;
	public static int comOffense = 0;
	public static int myDefense = 0;
	public static int comDefense = 0;
	public static int myFieldPlayersDefense = 0;
	//	public static int comFieldPlayersDefense = 0;

	//totalBatting()は上のフィールドに値を入れるメソッド
	public static void totalBatting(Player pitcher) {
		myDefense = (myFieldPlayersDefense + pitcher.getDefense() * 8) / 2;
	}

	public static void totalBatting(List<Player> myFieldPlayers, Player pitcher, List<Player> comFieldplayers,
			Player comPitcher) {
		myOffense = 0;
		comOffense = 0;
		myDefense = 0;
		comDefense = 0;
		myFieldPlayersDefense = 0;
		int comFieldPlayersDefense = 0;

		for (Player myFieldPlayer : myFieldPlayers) {
			myOffense += myFieldPlayer.getBattingAverage();
			if (myFieldPlayer.getFeel().equals("絶好調")) {
				myOffense += 2;
			} else if (myFieldPlayer.getFeel().equals("好調")) {
				myOffense += 1;
			} else if (myFieldPlayer.getFeel().equals("不調")) {
				myOffense -= 1;
			} else if (myFieldPlayer.getFeel().equals("絶不調")) {
				myOffense -= 2;
			}
		}
		for (Player comFieldplayer : comFieldplayers) {
			comOffense += comFieldplayer.getBattingAverage();
		}

		for (Player myFieldPlayer : myFieldPlayers) {
			myFieldPlayersDefense += myFieldPlayer.getDefense();

		}
		for (Player comFieldplayer : comFieldplayers) {
			comFieldPlayersDefense += comFieldplayer.getDefense();
		}

		myDefense = (myFieldPlayersDefense + pitcher.getDefense() * 8) / 2;
		comDefense = (comFieldPlayersDefense + comPitcher.getDefense() * 8) / 2;

	}

	// 自分のその回の得点をreturnするstaticメソッド
	//	public static int score() {
	//		int i = myOffense - comDefense;
	//		int score = rand.nextInt(100);
	//		if (score >= 0 && score < 60 - i) {
	//			score = 0;
	//		} else if (score >= 60 - i && score < 77 - i) {
	//			score = 1;
	//		} else if (score >= 77 - i && score < 87 - i) {
	//			score = 2;
	//		} else if (score >= 87 - i && score < 95 - i) {
	//			score = 3;
	//		} else {
	//			score = 4;
	//		}
	//		return score;
	//	}

	// 相手のその回の得点をreturnするstaticメソッド
	//	public static int comScore() {
	//		int i = comOffense - myDefense;
	//		int score = rand.nextInt(100);
	//		int d = 0;
	//		// 自分のピッチャーの体力が0以下になると、相手の得点力が上がる
	//		if (leftStamina < 0) {
	//			d = -10;
	//		}
	//		if (score >= 0 && score < 60 - i) {
	//			score = 0;
	//		} else if (score >= 60 - i + d && score < 77 - i + d) {
	//			score = 1;
	//		} else if (score >= 77 - i + d && score < 87 - i + d) {
	//			score = 2;
	//		} else if (score >= 87 - i + d && score < 95 - i + d) {
	//			score = 3;
	//		} else {
	//			score = 4;
	//		}
	//		return score;
	//	}

	//自分と相手のすべての回の得点を格納しているList
	public static List<Integer> scores = new ArrayList<>();
	public static List<Integer> comScores = new ArrayList<>();

	//上のリストに得点を入れるメソッド
	public static List<Integer> setScore() {
		int score = rand.nextInt(100);
		int i = myOffense - comDefense;
		if (score >= 0 && score < 60 - i) {
			score = 0;
		} else if (score >= 60 - (i / 2) && score < 77 - (i / 2)) {
			score = 1;
		} else if (score >= 77 - (i / 3) && score < 87 - (i / 3)) {
			score = 2;
		} else if (score >= 87 - (i / 4) && score < 95 - (i / 4)) {
			score = 3;
		} else {
			score = 4;
		}
		scores.add(score);
		return scores;
	}

	//上のリストに得点を入れるメソッド
	public static List<Integer> setComScore() {
		int i = comOffense - myDefense;
		int score = rand.nextInt(100);
		int d = 0;
		// 自分のピッチャーの体力が0以下になると、相手の得点力が上がる
		if (leftStamina < 0) {
			d = -10;
		}
		if (score >= 0 && score < 60 - i + d) {
			score = 0;
		} else if (score >= 60 - (i / 2) + (d / 2) && score < 77 - (i / 2) + (d / 2)) {
			score = 1;
		} else if (score >= 77 - (i / 3) + (d / 3) && score < 87 - (i / 3) + (d / 3)) {
			score = 2;
		} else if (score >= 87 - (i / 4) + (d / 4) && score < 95 - (i / 4) + (d / 4)) {
			score = 3;
		} else {
			score = 4;
		}
		comScores.add(score);
		return comScores;
	}

	// 自分の合計得点を返すstaticメソッド
	public static int getTotal() {
		int total = 0;
		for (int score : scores) {
			total += score;
		}
		return total;
	}

	// 相手の合計得点を返すstaticメソッド
	public static int getComTotal() {
		int comTotal = 0;
		for (int comScore : comScores) {
			comTotal += comScore;
		}
		return comTotal;
	}

	public static float leftStamina = 11;
	public static float minusStamina = 0;

	public static float getLeftStamina() {
		leftStamina = leftStamina - (1 / minusStamina) * 10;
		if (leftStamina < 0) {
			leftStamina = 0;
		}
		return leftStamina;
	}

	public static List<Player> pitchers = new ArrayList<>();

	public static boolean playedPitcher(Player pitcher) {
		for (Player playera : pitchers) {
			if (pitcher.getName().equals(playera.getName())) {
				return false;
			}
		}
		pitchers.add(pitcher);
		return true;
	}

	public static List<Player> dopingFieldPlayers = new ArrayList<>();

}
