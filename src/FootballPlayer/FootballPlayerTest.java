package FootballPlayer;

public class FootballPlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FootballPlayer alex = new FootballPlayer();
		alex.no =10;
		alex.minutes = 0;
		alex.name = "Alex de Souza";
		alex.inPlay = true;
		alex.numberOfGoals = 0;
		alex.play(90);
		alex.score(1);
		
		System.out.println("Alex Gol Sayýsý: "+alex.numberOfGoals);
		System.out.println("Alexin aldýðý süre: "+alex.minutes);
	}

}
