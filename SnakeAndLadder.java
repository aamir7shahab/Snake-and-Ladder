class SnakeAndLadder {
	//Initialising Constant
	public static final int START_POSITION = 0;
	public static final int END_POSITION = 100;

	//Global variables
	private static int currentPosition = START_POSITION;
	private static int numOnDice = 0;
	private static int selectedOption = 0;
	private static int diceThrown = 0;

	//Method to get number on dice
	public static int throwDice() {
		++diceThrown;
		return (int) (Math.floor(Math.random()*10)%6)+1;
	}

	//Method to get option for every new position
	public static int checkOptions() {
		return (int) Math.floor(Math.random()*10)%3+1;
	}

	public static void main(String[] args) {
		while (currentPosition <= END_POSITION-1) {
			numOnDice = throwDice();
			selectedOption = checkOptions();
			if (selectedOption == 2) {
				if ((currentPosition+numOnDice) > END_POSITION)
					;
				else
					currentPosition += numOnDice;
			}
			else if (selectedOption == 3) {
				currentPosition -= numOnDice;
				if (currentPosition < 0)
					currentPosition = 0;
			} 
			else
				;//do nothing
			System.out.println("Option: "+ selectedOption +" Number on Dice: "+ numOnDice +" Current Position : "+ currentPosition);
		}
		System.out.println("Total number of times dice was thrown : "+diceThrown);
	}
}