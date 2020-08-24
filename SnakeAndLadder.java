import java.util.*;

class SnakeAndLadder {
	//Initialising Constant
	public static final int START_POSITION = 0;
	public static final int END_POSITION = 100;

	//Global variables
	private static int currentPosition = START_POSITION;
	private static int numOnDice = 0;
	private static int selectedOption = 0;
	private static String optionStatus = "";
	private static String turnMessage = "";
	private static int diceThrown = 0;
	private static int whoseTurn = 0; // 0 --> player1 and 1 --> player2
	private static int repeatTurnFlag = 0;
	private static int checkWin = 0;
	private static ArrayList<ArrayList<Integer> > players;

	//Method to get number on dice
	public static int throwDice() {
		++diceThrown;
		return (int) (Math.floor(Math.random()*10)%6)+1;
	}

	//Method to get option for every new position
	public static int checkOptions() {
		return (int) Math.floor(Math.random()*10)%3+1;
	}

	//Method to change players
	public static void changePlayer() {
		if (whoseTurn == 0)
			whoseTurn = 1;
		else
			whoseTurn = 0;
	}

	//Method to act according to option
	public static void playAsOption(int whoseTurn){

		//getting dice_roll_count and current position of current player from array_list
		diceThrown = players.get(whoseTurn).get(0);
		currentPosition = players.get(whoseTurn).get(1);

		numOnDice = throwDice();
		selectedOption = checkOptions();

		if (selectedOption == 2) {
			optionStatus = "Ladder";
			turnMessage = "Hurray! You climbed a ladder.";
			if ((currentPosition+numOnDice) > END_POSITION)
				;
			else{
				currentPosition += numOnDice;
				if (currentPosition == END_POSITION)
					checkWin = 1;
			}
			repeatTurnFlag = 1;
		}
		else if (selectedOption == 3) {
			optionStatus = "Snake";
			turnMessage = "Oops! You got bitten by snake.";
			currentPosition -= numOnDice;
			if (currentPosition < 0)
				currentPosition = 0;
			repeatTurnFlag = 0;
		} 
		else {
			optionStatus = "No Play";
			turnMessage = "Sorry! No play for you.";//do nothing
			repeatTurnFlag = 0;
		}

		// setting dice_roll_count and current position of current player into array_list
		players.get(whoseTurn).set(0, diceThrown);
		players.get(whoseTurn).set(1, currentPosition);
		
	}

	//main function
	public static void main(String[] args) {

		//Creating a ArrayList to record dice_roll_count and current position of both players
		players = new ArrayList<ArrayList<Integer>>();
		players.add(new ArrayList<Integer>(Arrays.asList(0,0)));
		players.add(new ArrayList<Integer>(Arrays.asList(0,0)));

		//looping till someone wins 
		while (players.get(0).get(1) <= END_POSITION-1 && players.get(1).get(1) <= END_POSITION-1){
			do{
				playAsOption(whoseTurn);
				System.out.println("Player "+ (whoseTurn+1) +" turn:- Option: "+ selectedOption + " (" +optionStatus+ ")\t" + "Number on Dice: "
									+ numOnDice +" Current Position : "+ currentPosition +"  \t"+"Message : " + turnMessage);
			} while(repeatTurnFlag == 1 && checkWin == 0);
			changePlayer();
		}
		changePlayer();
		System.out.println("Congrats winner : Player "+ (whoseTurn+1));
		System.out.println("Player 1 dice count  : "+players.get(0).get(0));
		System.out.println("Player 2 dice count  : "+players.get(1).get(0));
		System.out.println("Full game dice count : "+(players.get(0).get(0)+players.get(1).get(0)));
	}
}