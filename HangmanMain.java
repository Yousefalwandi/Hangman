import java.util.ArrayList;
import java.util.Scanner;

public class HangmanMain {

	private static class Hangman {

		private String word; // The right word
		private int maxTries = 9; // Max tries for the player.
		private int count = 0; // Count the tries for the player.
		private boolean wordFind = false; // Boolean check if the word is found
		private ArrayList<String> hint = new ArrayList<>();
		private String stringHint = "";

		// Constructor function
		public Hangman(String word) {
			this.word = word;
		}

		// Check if the word is found else if the input char is found in the word.
		public void checkString(String input) {
			input = input.toLowerCase();

            System.out.println();
            if (input.equals(this.word) || this.stringHint.equals(this.word)){
                this.wordFind = true;
                System.out.println("Congratulations!");
                System.exit(0);
            }
            else if(input.length() == 1){
                String stringInput = Character.toString(input.charAt(0));
                    for (int i = 0; i < this.word.length(); i++) {

                        if(input.charAt(0) == this.word.charAt(i)){
                            this.hint.set(i,stringInput);
                        }
                    }
                this.stringHint = "";
                for(int i = 0; i < this.hint.size(); i++){
                    this.stringHint += this.hint.get(i);

                }
                if(this.stringHint.equals(this.word)){
                    System.out.println("Congratulations!");
                    System.exit(1);
                }

            }
            this.displayHangMan();
            this.showMenu();
        }

		// Shows for the player how many tries left.
		public void showGameStatus() {
			System.out.println("You have made " + (this.count) + " guesses, and have " + (this.maxTries - (this.count))
					+ " tries left");
			this.showMenu();
		}

		// Let the player type in a word.
		public void wordInput() {
			Scanner scan = new Scanner(System.in);
			if (this.count < maxTries && this.wordFind == false) {
				System.out.print("Guess a word: ");
				String input = scan.nextLine();
				this.count++;
				this.checkString(input);
			}
			scan.close();
		}

		// Let the play type in a char.
		 public void charInput(){

	            Scanner scan = new Scanner(System.in);
	            if(this.count < maxTries && this.wordFind == false){

	                String input = "dasdas";
	                while(input.length() > 1){
	                    System.out.print("Guess a character: ");
	                    input = scan.nextLine();
	                   if(input.length() > 1){
	                       System.out.print("Only one character! ");
	                   }
	                }
	                this.count++;
	                this.checkString(input);
	            }

	        }

		// Shows a figure depending on how many tries is left.
		public void displayHangMan() {
			switch (this.count) {
			case 1:
				System.out.println("|");
				break;
			case 2:
				System.out.println("|");
				System.out.println("|");
				break;
			case 3:
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 4:
				System.out.println();
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 5:
				System.out.println("---------");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 6:
				System.out.println("---------");
				System.out.println("|      |");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 7:
				System.out.println("---------");
				System.out.println("|     |");
				System.out.println("|     o");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				break;
			case 8:
				System.out.println("---------");
				System.out.println("|     |");
				System.out.println("|     o");
				System.out.println("|    -|-");
				System.out.println("|");
				System.out.println("|");
				break;
			case 9:
				System.out.println("---------");
				System.out.println("|     |");
				System.out.println("|     o");
				System.out.println("|    -|-");
				System.out.println("|     x");
				System.out.println("|");
				System.out.println("| GAME OVER");
				System.exit(0);
				break;
			}
		}

		// Shows the menu for the player.
		public void showMenu() {

            Scanner scan = new Scanner(System.in);
            System.out.println("choose alternative");
            System.out.println("(1) Game status");
            System.out.println("(2) Guess char");
            System.out.println("(3) Guess word");


            for(int i = 0; i < this.word.length(); i++){
                System.out.print(this.hint.get(i) + " ");
            }
           // System.out.println(this.stringHint);
            int alternative = scan.nextInt();

            switch (alternative){

                case 1:
                    this.showGameStatus();
                    break;
                case 2:
                    this.charInput();
                    break;

                case 3:
                    this.wordInput();
                    break;
            }
        }

		// Shows how many char for the word.
		public void createHints() {
			for (int i = 0; i < this.word.length(); i++) {
				this.hint.add("__");
			}
		}

	}

	public static void main(String[] args) {

		Hangman man = new Hangman("java");

		man.createHints();

		man.showMenu();
	}
}