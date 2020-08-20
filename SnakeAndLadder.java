class SnakeAndLadder {
	//Initialising Constant
	public static final int START_POSITION = 0;
	public static final int END_POSITION = 100;

	//Global variables
	private static int currentPosition = START_POSITION;
	private static int numOnDice = 0;
	private static int selectedOption = 0;

	//Method to get number on dice
	public static int throwDice() {
		return (int) (Math.floor(Math.random()*10)%6)+1;
	}

	//Method to get option for every new position
	public static int checkOptions() {
		return (int) Math.floor(Math.random()*10)%3+1;
	}

	public static void main(String[] args) {
		numOnDice = throwDice();
		selectedOption = checkOptions();
		if (selectedOption == 2)
			currentPosition += numOnDice;
		else if (selectedOption == 3)
			currentPosition -= numOnDice; 
		else
			;//do nothing
		System.out.println("Current Position : "+ currentPosition);
	}
}