import java.util.Scanner;

class Guesser {
	int guessNum;

	public int guessNumber() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Guesser kindly guess the number");
//		guessNum = scan.nextInt();
		
		guessNum = scan.nextInt();
		while (guessNum < 0 || guessNum > 10) {
			System.out.println("Please guess the number between range from 0 to 10");
			guessNum = scan.nextInt();
		}

		return guessNum;

	}

}

class Player {
	int pguessNum;

	public int guessNumber(int player) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player "+(player+1)+" kindly guess the number");
		pguessNum = scan.nextInt();
		while (pguessNum < 0 || pguessNum > 10) {
			System.out.println("Please guess the number between range from 0 to 10");
			pguessNum = scan.nextInt();
		}

		return pguessNum;
	}
}

class Umpire {
	int numOfallowedPlayersToPlay = 5;
	int numFromGuesser;
	int numFromPlayers[];
	Player[] Players;
	int[] winners;
	int[] losers;

	public void collectNumFromGuesser() {
		Guesser g = new Guesser();
		numFromGuesser = g.guessNumber();

	}

	public void collectNumFromPlayer() {

		int numberOfPlayers = 0;
		do {
			System.out.println("Enter number of players(Max 5 Players):");
			numberOfPlayers = new Scanner(System.in).nextInt();
			if (numberOfPlayers <= numOfallowedPlayersToPlay && numberOfPlayers > 0) {
				numFromPlayers = new int[numberOfPlayers];
				Players = new Player[numberOfPlayers];
				winners = new int[numberOfPlayers];// expecting scenario that all players guessed right
				losers = new int[numberOfPlayers];// expecting scenario that all players guessed wrong

				for (int i = 0; i < numberOfPlayers; i++) {
					Players[i] = new Player();
				}
				for (int i = 0; i < numberOfPlayers; i++) {
					numFromPlayers[i] = Players[i].guessNumber(i);
				}
			} else {
				System.out.println("Max 5 players can play");
			}
		} while (!(numberOfPlayers <= numOfallowedPlayersToPlay && numberOfPlayers > 0));

	}

	void compare() {
		for (int i = 0; i < Players.length; i++) {
			if (numFromPlayers[i] == numFromGuesser) {
				winners[i] = i + 1;
			}

			else {
				losers[i] = i + 1;
			}
		}
		System.out.print("Winner players are: ");
		int flag = 0;
		for (int i : winners) {
			if (i != 0) {
				System.out.print(i + ",");
				flag++;
			}
		}
		System.out.println((flag == 0) ? "No one is winner" : "");
		flag = 0;
		System.out.print("Loser players are: ");
		for (int i : losers) {
			if (i != 0) {
				System.out.print(i + ",");
				flag++;
			}
		}
		System.out.println((flag == 0) ? "No one is Loser" : "");

	}
}

public class LaunchGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(	"\n\n");
			System.out.println(	"Welcome to Guess the Number\n1.Press 1 to continue \n2.Press any other key then 1 to exit");
			if (sc.nextInt() == 1) {
				Umpire u = new Umpire();
				u.collectNumFromGuesser();
				u.collectNumFromPlayer();
				u.compare();
			} else {
				System.out.println("Game Over!...");
				System.exit(0);
			}
		}

	}

}