/**
 * @author Kurt Krenz
 * 
 * .::Algorithm Summary::.
 * introduction()
 * Welcomes the user to the mouse maze.
 * Asks for input, height and width of the playing board.
 * Calls a method to get height and width input, checks for correctness in input.
 * Thanks the lovely user.
 * Calls a method which asks for how many traps the user would like to set, checks for correctness in input, cannot be more than 25% of playing field.
 * 
 * setPlayingFieldHeight()
 * Asks the user for height of the playingboard, and checks for correctness, cannot be more than 20.
 * 
 * setPlayingFieldWidth()
 * Asks the user for width of the playing board and checks for correctness, cannot be more than 20.
 * 
 * setNumberOfMouseTraps()
 * Asks the user for how many mousetraps they would like to set, cannot be more than 25% of playing field.
 * 
 * createPlayingBoardArray(int width, int height) 
 * Creates the playing board, a two dimensional array of MouseTrap object, with the width and height being the input from the user in the parameters of the method.
 * returns the newly created 2 dimensional array of MouseTrap type.
 * 
 * populateMouseTrapArray(MouseTrap[][] mouseTrap)
 * Creates MouseTrap objects in each cell of the array.
 * 
 * displayMousePath(ArrayList<Integer> pathOfMouse)
 * This method is used to create a 2 dimensional boolean array where the cells of the array where the mouse has successfully landed will be turned to true.
 * As the parameter, the method uses the Integer arraylist of coordinates of where the mouse has successfully landed, meaning the mouse did not encounter any traps,
 * or fell off the edge of the playing board.
 * The boolean 2 dimensional array is returned.
 * 
 * setArmedMouseTraps(Double numberOfTraps2, MouseTrap[][] playingField)
 * This method creates the armed mouse traps in the MouseTrap object 2 dimensional array.
 * Creates a boolean 2 dimensional array whose cells will be turned true based on the traps that have been set already.
 * This is created so that no two cells will be armed.
 * enters a for loop which will be repeated for as many mousetraps the user has entered.
 * creates a new mousetrap object.
 * generates two random numbers with the height and width as inputs into the randomnumbergenerator method.
 * These will be used to pick the random cells to be armed.
 * Enters into a while loop which will make sure that cell [0][0] and the very last cell will not be armed.
 * Also checks if the newly randomly picked cell has been chosen already by checking the boolean two dimensional array in that particular cell.
 * if the while loop is entered, a fresh set of random coordinates will be chosen.
 * If the while loop is not entered, or once it has be exited, the randomly generated coordinate in the 2 dimensioanl playingboard array will be set to armed status.
 * Also, those particular coordinates will be set to true in the corresponding two dimensional boolean array.
 * the playingField (MouseTrap object) 2dim array is returned.
 * 
 * generateRandomNumberWidth(int maxWidth)
 * Will generate a random number in the range of the parameter.
 * 
 * generateRandomNumberHeight(int maxHeight)
 * Will generate a random number in the range of the parameter.
 * 
 * checkIfMouseHasCompletedMaze(Mouse mouse)
 * Checks if the mouse's coordinates are the last cell in the 2dim array, this would mean the mouse has won the maze.
 * Sets the boolean variable mouseHasReachedGoal to true if the if statement is entered.
 * 
 * String formatNumber(int number)
 * Formats the number in the parameter to have commas in the correct spots, ###,###,###,###
 * Returns the formatedNumberString.
 * 
 * toStringMethodForArray(MouseTrap[][] playingField)
 * Used to print out the map displaying the mousetraps and how many mice died in them.
 * Will print mTrap if there was a mousetrap where 0 mice died.
 * Will print the number of mice that died in the mouseTrap.
 * 
 * toStringMethodLocationOfMouse(ArrayList<Integer> arrayList)
 * Used to print the coordinates of the winning path of the mouse.
 * Will use the parameter, an Integer ArrayList, and get 2 coordinates each time, and put them in parentheses with a comma separating them.
 * 
 * choiceToPlayAgain()
 * Asks the user if they want to play again, if they do, will start the maze game over again, if not, exits the program.
 * 
 * toStringMethodForPathOfMouseDisplay(boolean[][] bs)
 * Used to display the map of the path that the winning mouse took.
 * Uses as a parameter the 2dim boolean array of coordinates which the mouse took to win the maze.
 * Will traverse that 2dim boolean array and set all falses to 0, designating a spot where the mouse did not go, and all trues to Mr. M designating
 * a spot where the mouse was.
 * 
 * printStringLeft(int size, String formatted)
 * Formats the entered string to be a specific amount of spaces to the left.
 * 
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class MouseMazeMain 
{
	private static Scanner keyboard = new Scanner(System.in);
	public static Integer boardHeight = 0;
	public static Integer boardWidth = 0;
	private static Double numberOfTraps = 0.0;
	private static String playAgainString = null;
	private static boolean playAgainBoolean = true;
	private static double maxNumberOfTrapsPercentage = .25;
	private static boolean mouseHasReachedGoal = false;
	
	public static void main(String[] args)
	{
		while (playAgainBoolean == true)
		{
			int mouseCount = 0;
			mouseHasReachedGoal = false;
			introduction();
			MouseTrap[][] playingBoard = null;
			playingBoard = createPlayingBoardArray(boardWidth, boardHeight);
			populateMouseTrapArray(playingBoard);
			setArmedMouseTraps(numberOfTraps, playingBoard);
			Mouse mouse = new Mouse();
			while (mouseHasReachedGoal  == false)
			{
				mouse.arrayListOfMouseLocationsArray(mouse.location());
				mouse.pickDirectionToMoveMouseAndWalk();
				if (playingBoard[mouse.positionOfMouseWidth][mouse.positionOfMouseHeight].isArmed)
				{
					playingBoard[mouse.positionOfMouseWidth][mouse.positionOfMouseHeight].numberOfPerishedMice++;
					mouse.die();
					mouseCount++;
				}
				mouse.checkIfMoveIsLegal();
				checkIfMouseHasCompletedMaze(mouse);
			}
			System.out.println((formatNumber(mouseCount)) + " mice died before mouse number " + formatNumber(mouseCount+1) + " made it!");
			System.out.println();
			System.out.println("Playing board displaying where each trap was located and how many mice perished there.");
			System.out.println("A \"mTrap\" designates a trap where no mice perished.");
			toStringMethodForArray(playingBoard);
			System.out.println();
			System.out.println("Coordinates of Mr. Mouse's escape route: ");
			toStringMethodLocationOfMouse(mouse.arrayListOfMouseLocationsArray(mouse.location()));
			System.out.println();
			System.out.println("Map of Mr. Mouse's escape route: ");
			toStringMethodForPathOfMouseDisplay(displayMousePath(mouse.pathOfMouse));
			System.out.println("\n\n\n");
			choiceToPlayAgain();
		}
	}
	/**
	 *  //welcomes the user to the mouse maze.
	 *  //asks for the user to enter a width and height.
	 *  //calls method that asks for width.
	 *  //calls method that asks for height.
	 *  //thanks the wonderful user.
	 *  //calls method that asks for how many traps the user would like to set.
	 * @pre -none-
	 * @post the variables responsible for holding the width and height of the maze will be set equal to what the user entered.
	 * @post the variable responsible for holding the amount of traps will be set equal to what the user entered.
	 * @param -none-
	 * @return -none-
	 */
	private static void introduction()
	{
		System.out.println("Welcome to the Mouse Maze!");
		System.out.println("Please enter a width and height for the torture ... I mean ... playing ... field.");
		setPlayingFieldWidth();
		setPlayingFieldHeight();
		System.out.println("Thanks...");
		setNumberOfMouseTraps();
	}
	/**
	 * @pre -none-
	 * @post the height of the playing field will be set
	 * @param -none-
	 * @return -none-
	 */
	private static void setPlayingFieldHeight()
	{
		try
		{
			System.out.println("Enter height (1-20): ");
			boardHeight = Integer.parseInt(keyboard.nextLine());
			if ((boardHeight > 20) || (boardHeight < 1))
			{
				throw new Exception();
			}
		}
		catch(Exception e3)
		{
			System.out.println("Please pick a height within the allowed range!");
			setPlayingFieldHeight();
		}
	}
	/**
	 * @pre -none-
	 * @post the width of the playing field will be set.
	 * @param -none-
	 * @return -none-
	 */
	private static void setPlayingFieldWidth()
	{
		try
		{
			System.out.println("Enter width (1-20): ");
			boardWidth = Integer.parseInt(keyboard.nextLine());
			if ((boardWidth > 20) || (boardWidth < 1))
			{
				throw new Exception();
			}
		}
		catch(Exception e2)
		{
			System.out.println("Please pick a width within the allowed range!");
			setPlayingFieldWidth();
		}
	}
	/**
	 * @pre -none-
	 * @post the number of mouse traps will be set.
	 * @param -none-
	 * @return -none-
	 */
	private static void setNumberOfMouseTraps()
	{
		double boardWidthDouble = (double)boardWidth;
		double boardHeightDouble = (double)boardHeight;
		try
		{
			System.out.println("How many traps you would like to set?");
			System.out.println("Enter number of traps (cannot exceed 25% of spaces on the board): ");
			numberOfTraps = Double.parseDouble(keyboard.nextLine());
			double percentageOfTraps = (numberOfTraps/(boardWidthDouble*boardHeightDouble));
			//number of traps must be 25% or less than cells on board
			if (percentageOfTraps > maxNumberOfTrapsPercentage)
			{
				throw new Exception();
			}
		}
		catch (Exception e0)
		{
			System.out.println("Pick a smaller number of traps!");
			setNumberOfMouseTraps();
		}
		try
		{
			//number of traps must be a positive number
			if (numberOfTraps < 0)
			{
				throw new Exception();
			}
		}
		catch (Exception e1)
		{
			System.out.println("Pick a positive number!");
			setNumberOfMouseTraps();
		}
	}
	/**
	 * //the playing board will be created (2 dimensional array of user set width and height)
	 * @pre -none-?
	 * @post an 2 dimensional array (which will be referred to as the "playing board") of width set by user and height set by user will be created.
	 * @param width
	 * @param height
	 * @return tempPlayingBoard
	 */
	private static MouseTrap[][] createPlayingBoardArray(int width, int height) 
	{
		MouseTrap[][] tempPlayingBoard = new MouseTrap[width][height];
		return tempPlayingBoard;
	}
	/**
	 *  //each cell of the playing board will be filled with 1 mouseTrap object, which is by default set to a "disabled" status.
	 * @pre the parameter 2 dimensional array of type MouseTrap must have been created and instantiated.
	 * @post each cell of the two dimensional array of type MouseTrap will be filled with one MouseTrap object and set to a "disabled" status by default.
	 * @param mouseTrap
	 * @return -none-
	 */
	private static void populateMouseTrapArray(MouseTrap[][] mouseTrap)
	{
		int i;
		int ii;
		for (i = 0; i < boardWidth; i++)
		{
			for (ii = 0; ii < boardHeight; ii++)
			{
				mouseTrap[i][ii] = new MouseTrap();
			}
		}
	}
	//method to take arraylist of mouse locations and make it into a two dimensional boolean array
		/**
		 * 
		 * @param pathOfMouse
		 * @return
		 */
		public static boolean[][] displayMousePath(ArrayList<Integer> pathOfMouse)
		{
			boolean[][] pathOfMouseDisplay = new boolean[boardWidth][boardHeight];
			int i;
			for (i = 0; i < pathOfMouse.size(); i++)
			{
				pathOfMouseDisplay[pathOfMouse.get(i)][pathOfMouse.get(i+1)] = true;
				i++;
			}
			return pathOfMouseDisplay;
		}
		
		
	/**
	 * //a number of MouseTrap objects, determined by the user, will be randomly chosen and set to an "armed" status inside the playing board array.
	 * @pre number of mouse traps must be set by user, two dimensional array of MouseTrap objects must be created.
	 * @param numberOfTraps2
	 * @param playingField
	 * @return playingField
	 */
	public static MouseTrap[][] setArmedMouseTraps(Double numberOfTraps2, MouseTrap[][] playingField)
	{
		//this array will store the cells which are armed and will be cross check in order to make sure there are no duplicates
		boolean[][] armedCellsArray = new boolean[boardWidth][boardHeight];
		int i;
		for (i = 0; i < numberOfTraps2; i++) 
		{
			MouseTrap mouseTrap = new MouseTrap();
			int randomWidthInt = generateRandomNumberWidth(boardWidth);
			int randomHeightInt = generateRandomNumberHeight(boardHeight);
			//making sure that cell[0][0] and cell[maxWidth][maxHeight] are not chosen
			//also checks if the cell chosen has not been previously chosen
			while ( ((randomWidthInt == 0) && (randomHeightInt == 0)) || ((randomWidthInt == (boardWidth-1)) && (randomHeightInt == (boardHeight-1))) 
					|| (armedCellsArray[randomWidthInt][randomHeightInt] == true) )
			{
				randomWidthInt = generateRandomNumberWidth(boardWidth);
				randomHeightInt = generateRandomNumberHeight(boardHeight);
			}
			//arm selected mouseTrap object
			playingField[randomWidthInt][randomHeightInt] = mouseTrap.armed();
			//sets boolean in corresponding location of armedCellsArray to true to make sure this cell while not be chosen again.
			armedCellsArray[randomWidthInt][randomHeightInt] = true;
		}
		return playingField;
	}
	/**
	 * //made specifically for generating random number in range of user entered boardWidth.
	 * @pre boardWidth must have been set by user.
	 * @post a random number within the range of the user entered boardWidth is returned.
	 * @param maxWidth
	 * @return randomNumber
	 */
	public static int generateRandomNumberWidth(int maxWidth)
	{
		double randNumDouble = Math.random();
		int randomNumber = 0;
		randNumDouble = (randNumDouble*(maxWidth));
		randomNumber = (int)randNumDouble;
		return randomNumber;
	}
	/**
	 *  //made specifically for generating random number in range of user entered boardHeight
	 * @pre boardHeight must have been set by the user.
	 * @post a random number within the range of the user entered boardHeight is returned.
	 * @param maxHeight
	 * @return randomNumber
	 */
	public static int generateRandomNumberHeight(int maxHeight)
	{
		double randNumDouble = Math.random();
		int randomNumber = 0;
		randNumDouble = (randNumDouble*(maxHeight));
		randomNumber = (int)randNumDouble;
		return randomNumber;
	}
	/**
	 *  //checks to see if the mouse has reached the very last cell of the playing board 2 dimensional array.
	 * @pre Mouse object must have been created, as well as the playing board 2 dimensional array.
	 * @post will change the boolean variable mouseHasReachedGoal to true if the mouse has reached the last cell of the playing board 2 dimensional array.
	 * @param mouse
	 * @return -none-
	 */
	private static void checkIfMouseHasCompletedMaze(Mouse mouse)
	{
		if ((mouse.positionOfMouseWidth == boardWidth-1) && (mouse.positionOfMouseHeight == boardHeight-1))
		{
			mouseHasReachedGoal = true;
		}
	}
	/**
	 * @pre an integer number must be declared and instantiated/have some value.
	 * @post an integer is returned which is formated as such: ###,###,###,###
	 * @param number
	 * @return formattedNumberString
	 */
	public static String formatNumber(int number)
	{
		String formattedNumberString;
		DecimalFormat formattedNumber = new DecimalFormat("###,###,###,###");
		formattedNumberString = formattedNumber.format(number);
		return formattedNumberString;
	}
	
	//@TODO
	/**
	 * 
	 * @param playingField
	 */
	public static void toStringMethodForArray(MouseTrap[][] playingField)
	{
		int largestNumberOfPerishedMice = 14;
		int i;
		int ii;
		for (i = 0; i < boardWidth; i++)
		{
			System.out.println("\n");
			for (ii = 0; ii < boardHeight; ii++)
			{
				if ((playingField[i][ii].numberOfPerishedMice == 0) && (playingField[i][ii].isArmed))
				{
					printStringLeft(largestNumberOfPerishedMice, "mTrap");
				}
				else
				{
					printStringLeft(largestNumberOfPerishedMice, formatNumber(playingField[i][ii].numberOfPerishedMice));
				}
			}
		}
		System.out.println("\n\n");
	}
	
	//@TODO
	/**
	 * @pre Parameter ArrayList needs to have been created.
	 * @post Prints out the coordinates of the path the mouse took to get to safety.
	 * @param arrayList
	 * @return -none-
	 */
	public static void toStringMethodLocationOfMouse(ArrayList<Integer> arrayList)
	{
		int lengthOfArrayList = arrayList.size();
		int i;
		for (i = 0; i < lengthOfArrayList-1; i++)
		{
			System.out.print("(" + arrayList.get(i+1) +",");
			System.out.println(arrayList.get(i) + ")");
			i++;
		}
	}

	/**
	 * @pre -none-
	 * @post will change the boolean variable playAgainBoolean to true if the user wants to play again, and to false if the user does not want to play again.
	 * @param -none-
	 * @return -none-
	 */
	private static void choiceToPlayAgain()
	{
		try
		{
			System.out.println("Would you like to play another round? (Y/N)");
			playAgainString = keyboard.nextLine();
			if (!(playAgainString.equalsIgnoreCase("Y")) && !(playAgainString.equalsIgnoreCase("N")))
			{
				throw new Exception();
			}
			if (playAgainString.equalsIgnoreCase("Y"))
			{
				playAgainBoolean = true;
			}
			else if (playAgainString.equalsIgnoreCase("N"))
			{
				playAgainBoolean = false;
				System.out.println("See ya!  Hope you had a mice ... I mean ... nice ... time!");
			}
		}
		catch(Exception eLast)
		{
			choiceToPlayAgain();
		}
	}
	/**
	 * @pre The parameter boolean[][] must have been created.
	 * @post Will print the board with the path the mouse took to reach the 
	 * @param bs
	 * @return -none-
	 */
	private static void toStringMethodForPathOfMouseDisplay(boolean[][] bs)
	{
		int largestNumberOfPerishedMice = 14;
		int i;
		int ii;
		for (i = 0; i < boardWidth; i++)
		{
			System.out.println("\n");
			for (ii = 0; ii < boardHeight; ii++)
			{
				if (bs[i][ii] == false)
				{
					printStringLeft(largestNumberOfPerishedMice, "0");
				}
				if (bs[i][ii] == true)
				{
					printStringLeft(largestNumberOfPerishedMice, "Mr.M");
				}
			}
		}
	}
	/**
	 * @pre -none-
	 * @post prints the string a specified amount of spaces to the left
	 * @param size
	 * @param formatted
	 * @return -none-
	 */
	public static void printStringLeft(int size, String formatted)
	// Blank fills and left justifies a string in a field of size characters
	{
		
		int length = formatted.length();
		System.out.print(formatted);
		while(size > length)
		{
			System.out.print(" ");
			size--;
		}
	} 
}
