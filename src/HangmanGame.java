import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Hangman hangman = new Hangman();
		boolean winFlag = false;

		System.out.println("************");
		System.out.println("* Hangman *");
		System.out.println("************");
		System.out.println("");
		Hangman.printMenu();
		System.out.println("");

		// ADD YOUR IMPLEMENTATION HERE
		hangman.printWord();
		for (int i = 1; i <= 6; i++) {
			System.out.println("Please guess");
			char guessCharacter = Character.toLowerCase(reader.next().charAt(0));
			if (!hangman.storeGuess(guessCharacter)) {
				if (hangman.guess(guessCharacter)) {
					System.out.println("Letter present");
					i--;
				} else {
					System.out.println("Letter not present");
				}
			}
			else {
				System.out.println("Letter already asked");
				i--;
			}
			System.out.println("Word is now " + hangman.printWord());
			if (hangman.status()) {
				System.out.println("YOU WIN !!");
				winFlag = true;
				break;
			}
			hangman.printMan(7 - i);
			System.out.println("\nYou have " + (6 - i) + " guesses left!");
		}
		if (!winFlag) {
			System.out.println("YOU LOSE !!");
		}
		System.out.println("Thank you for playing!");
	}
}
