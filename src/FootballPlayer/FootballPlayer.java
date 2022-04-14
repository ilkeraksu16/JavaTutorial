package FootballPlayer;

public class FootballPlayer {
	int no, minutes, numberOfGoals;
	String name;
	boolean inPlay;
	
	void play(int minutesToPlay) {
		minutes+=minutesToPlay;
	}
	
	void score(int goals) {
	numberOfGoals += goals;	
	}
}
