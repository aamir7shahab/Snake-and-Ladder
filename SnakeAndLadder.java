class SnakeAndLadder {
	//Initialising Constant
	public static final int START_POSITION = 0;
	public static final int END_POSITION = 100;

	//Global variables
	private static int currentPosition = 0;

	public static int throwDice() {
		return (int) (Math.floor(Math.random()*10)%6)+1;
	}

	public static void main(String[] args) {
		currentPosition += throwDice();
		System.out.println("Current Position : "+ currentPosition);
	}
}