public class Hangman {
	private static String wordToBeGuessed = "hangman";
	private static StringBuilder lettersGuessed = new StringBuilder("");
	public static StringBuilder wordToBeDisplayed = new StringBuilder("");

	public Hangman() {
		for (int i = 0; i < wordToBeGuessed.length(); i++) {
			wordToBeDisplayed.append('?');
		}
	}

	public static void printMenu() {
		System.out.println(" * INSTRUCTIONS *");
		System.out.println("a single letter uses the letter as a guess");
		System.out.println("you have 5 guesses");
	}

	public boolean status() {
		if (!wordToBeDisplayed.toString().contains("?")) {
			return true;
		}
		return false;
	}

	public StringBuilder printWord() {
		return wordToBeDisplayed;
	}

	public boolean guess(char letter) {
		boolean flag = false;
		for (int i = 0; i < wordToBeGuessed.length(); i++) {
			if (wordToBeGuessed.charAt(i) == letter) {
				wordToBeDisplayed.setCharAt(i, letter);
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean storeGuess(char letter) {
		if(lettersGuessed.toString().indexOf(letter) < 0)
		{
			lettersGuessed.append(letter);
			return false;
		}
		return true;		
	}

	public void printMan(int guessNumber) {
		switch (guessNumber) {
		case 1:
			System.out.print(" ____\n" + 
					" |  |\n" + 
					" |  o\n" + 
					" | -+-\n" + 
					" |  ^\n/|\\");
			break;
		case 2:
			System.out.print(" ____\n" + 
					" |  |\n" + 
					" |  o\n" + 
					" | -+-\n" + 
					" |\n/|\\");
			break;
		case 3:
			System.out.print(" ____\n" + 
					" |  |\n" + 
					" |  o\n" + 
					" |\n" + 
					" |\n/|\\");
			break;
		case 4:
			System.out.print(" ____\n" + 
					" |  |\n" + 
					" |\n" + 
					" |\n" + 
					" |\n/|\\");
			break;
		case 5:
			System.out.print(" ____\n" + 
					" |\n" + 
					" |\n" + 
					" |\n" + 
					" |\n/|\\");
			break;
		case 6:
			System.out.print("\n" + 
					" |\n" + 
					" |\n" + 
					" |\n" + 
					" |\n/|\\");
			break;
		case 7:
			System.out.print("\n" + 
					" \n" + 
					" \n" + 
					" \n" + 
					" \n/|\\");
			break;
		default:
			System.out.println("You have run out of chances");
			break;
		}
	}
}
