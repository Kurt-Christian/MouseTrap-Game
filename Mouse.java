/**
 * @author kurtkrenz
 * 
 * .:: Algorithm Summary ::.
 * location() 
 * Creates a new Integer array called positionOfMouseWidthHeight and sets the size to 2.
 * Sets the 0 index of positionOfMouseWidthHeight to the calling object's positionOfMouseWidth.
 * Sets the 1 index of positionOfMouseWidthHeight to the calling object's positionOfMouseHeight.
 * returns the Integer array positionOfMouseWidthHeight.
 * 
 * arrayListOfMouseLocationsArray(Integer[] mouseLocation)
 * Adds the 0 index of the parameter Integer array to the next index of the global Integer ArrayList pathOfMouse.
 * Adds the 1 index of the parameter Integer array to the next index of the global Integer ArrayList pathOfMouse.
 * Returns the updated pathOfMouse.
 * 
 * walk() 
 * Creates and sets an int distanceToWalk to 1.
 * Returns distanceToWalk.
 * 
 * mouseLocationString(int[] locationOfMouse)
 * toString method for the output of the locations of the Mouse object.
 * Creates a String called mouseLocationString and sets it equal to " " + locationOfMouse[0] + " " + locationOfMouse[1]
 * Returns mouseLocationString
 * 
 * die()
 * Sets the calling Mouse object's positionOfMouseWidth equal to 0.
 * Sets the calling Mouse object's positionOfMouseHeight equal to 0.
 * Clears the pathOfMouse ArrayList which has been built with the path that the Mouse object has taken thus far through the playing field.
 * 
 * generateRandomNumber()
 * Generates a random number 0-9.
 * Will select a new random number if a number higher than 7 is chosen.
 * This is done because this method is specifically for the generation of numbers which will be used for the Mouse object's movement.
 * There are only 8 directions to be moved in. 
 * Therefore anything over 7, bc we include 0, is not useful for us.
 * Returns the random number.
 * 
 * pickDirectionToMoveMouseAndWalk()
 * Random number is generated and is assigned to the int directionToMoveMouse.
 * Enters into a switch statement with cases for each potentially picked random number.
 * In each switch statement, depending on which one is entered, the String variable movementDirection will be set to a compass direction (e.g. North, South, East, etc.).
 * Then the program will enter into the corresponding method for that compass directional movement where the correction numbers are added to the mouses current
 * location to arrive at the new location.
 * The program then pops into a method which will check if this new movement is legal.
 * 
 * mouseMovementNorth()
 * Is considered an illegal movement and the Mouse object's position is set to [0][0], the beginning of the board.
 * The mouse does not die!
 * The die() method sets the Mouse object's position to [0][0] and clears the pathOfMouse ArrayList that was getting built with its movements.
 * 
 * mouseMovementNorthWest()
 * Is considered an illegal movement and the Mouse object's position is set to [0][0], the beginning of the board.
 * The mouse does not die!
 * The die() method sets the Mouse object's position to [0][0] and clears the pathOfMouse ArrayList that was getting built with its movements.
 * 
 * mouseMovementNorthEast()
 * Adds walk() to positionOfMouseWidth.
 * Subtracts walk() from positionOfMouseHeight.
 * 
 * mouseMovementWest()
 * Is considered an illegal movement and the Mouse object's position is set to [0][0], the beginning of the board.
 * The mouse does not die!
 * The die() method sets the Mouse object's position to [0][0] and clears the pathOfMouse ArrayList that was getting built with its movements.
 * 
 * mouseMovementEast()
 * Adds walk() to positionOfMouseWidth.
 * positionOfMouseHeight remains unchanged.
 * 
 * mouseMovementSouth()
 * positionOfMouseWidth remains unchanged.
 * Adds walk() to positionOfMouseHeight.
 * 
 * mouseMovementSouthWest()
 * Subtracts walk() from positionOfMouseWidth.
 * Adds walk() to positionOfMouseHeight.
 * 
 * mouseMovementSouthEast()
 * Adds walk() to positionOfMouseWidth.
 * Adds walk() to positionOfMouseHeight.
 * 
 * checkIfMoveIsLegal()
 * Checks if the new position of the Mouse object is legal.
 * Will die() the mouse if either position is negative.
 * Also will use the movementDirection String and compare it to the location of the Mouse object to determine if the move has put the mouse over the edge of the 
 * board.
 */

import java.util.ArrayList;
public class Mouse implements AnimalInterface
{
	int positionOfMouseWidth = 0;
	int positionOfMouseHeight = 0;
	String movementDirection = null;
	ArrayList<Integer> pathOfMouse = new ArrayList<Integer>();
	
	/**
	 * @pre -none-
	 * @post Mouse object will have width and height position of (0,0).
	 * @post Mouse object will have an ArrayList which will holds the coordinates of the mouse's current path in the form of a
	 * 2 celled array.
	 * @param -none-
	 * @return -none-
	 */
	public Mouse()
	{
		positionOfMouseWidth = 0;
		positionOfMouseHeight = 0;
	}
	/**
	 * @pre Mouse object must have been created.
	 * @post Will return true if the animal is asleep.
	 * @param -none-
	 * @return isAsleep
	 */
	//will not be using this, but still create and make available to other programmer
	public boolean isAsleep() 
	{
		boolean isAsleep = false;
		return isAsleep;
	}
	/**
	 * @pre There must be a Mouse object created.
	 * @post Will return a new 2 celled Integer array with the mouse's location.
	 * @param -none-
	 * @return positionOfMouseWidthHeight
	 */
	public Integer[] location() 
	{
		Integer[] positionOfMouseWidthHeight = new Integer[2];
		positionOfMouseWidthHeight[0] = this.positionOfMouseWidth;
		positionOfMouseWidthHeight[1] = this.positionOfMouseHeight;
		return positionOfMouseWidthHeight;
	}
	/**
	 * @pre Calling ArrayList must have been instantiated, initialized, and have Integer array objects in each cell.
	 * @post Returns the calling ArrayList with the parameter array added to its next index.
	 * @param mouseLocation
	 * @return pathOfMouse
	 */
	public ArrayList<Integer> arrayListOfMouseLocationsArray(Integer[] mouseLocation)
	{
		pathOfMouse.add(mouseLocation[0]);
		pathOfMouse.add(mouseLocation[1]);
		return pathOfMouse;	
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Returns the value of how many spaces the mouse may move in one turn.
	 * @param -none-
	 * @return distanceToWalk
	 */
	public int walk() 
	{
	    int distanceToWalk = 1;
		return distanceToWalk;
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Returns the value of how many spaces the mouse can move in one turn.
	 * @param -none-
	 * @return distanceToRun
	 */
	//will not be using this, but still create and make available to other programmer
	//make it so the mouse can only be run in straight line, not diagonally.
	public int run() 
	{
		int distanceToRun = 3;
		return distanceToRun;
	}
	/**
	 *@pre Mouse object must be created.
	 *@post Puts the animal in a "has eaten" state and then calls sleep(int sleepPeriod) to put the animal to sleep for a number of periods.
	 *@param -none-
	 *@return -none-
	 */
	//will not be using this, but still create and make available to other programmer
	public void eat() 
	{
	}
	/**
	 * @pre  Mouse object must be created.
	 * @post Makes mouse stay at its current location for 1 movement turn.
	 * @param sleepPeriod
	 * @return -none-
	 */
	//will not be using this, but still create and make available to other programmer
	public void sleep(int sleepPeriod) 
	{
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Chooses if the mouse will run or walk (but for the purpose of this program the mouse will always walk).
	 * @param -none-
	 * @return choiceOfNextMove
	 */
	//will not be using this, but still create and make available to other programmer
	public int nextMove() 
	{
		int choiceOfNextMove = 0;
		return choiceOfNextMove;
	}
	/**
	 * @pre Mouse object must be created.
	 * @post ToString method for the output of the array holding the locations of the mouse.
	 * @param locationOfMouse
	 * @return mouseLocationString
	 */
	public String mouseLocationString(int[] locationOfMouse)
	{
		String mouseLocationString = " " + locationOfMouse[0] + " " + locationOfMouse[1];
		return mouseLocationString;
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Sets the location of the mouse back to the beginning, width,height (0,0).
	 * @param -none-
	 * @return -none
	 */
	public void die()
	{
		this.positionOfMouseWidth = 0;
		this.positionOfMouseHeight = 0;
		pathOfMouse.clear();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post A random number is generated within range [0,7].
	 * @param -none-
	 * @return randomNumber
	 */
	public int generateRandomNumber()
	{
		double randNumDouble = Math.random();
		int randomNumber = 0;
		try
		{
			randNumDouble = (randNumDouble*10);
			randomNumber = (int)randNumDouble;
			while (randomNumber > 7)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			randomNumber = generateRandomNumber();
		}
		return randomNumber;
	}
	
	/**
	 * @pre Mouse object must be created.
	 * @post Uses a randomly generated number in range [0,7] to decide which direction the mouse will move.
	 * Uses a switch statement to branch into according movement direction methods.
	 * @param -none-
	 * @return -none-
	 */
	//	.:: Mapping of directions mouse may move ::.
	//
	//        			  0  1  2
	// 
	//         			  3  M  4
	//
	//        			  5  6  7
	//
	//  		 Where, M = location of mouse;
	// 			 1 = movement North
	// 			 3 = movement West
	// 			 4 = movement East
	// 			 6 = movement South
	// 			 0 = movement NorthWest
	// 			 2 = movement NorthEast
	// 			 5 = movement SouthWest
	// 			 7 = movement SouthEast
	//
	//			 0,1,3 are considered to be illegal movements ALWAYS
	//			 Whether the rest of the numbers are legal movements is to be determined by the location of the mouse on the 
	//			 playing field.
	public void pickDirectionToMoveMouseAndWalk()
	{
		int directionToMoveMouse = generateRandomNumber();
		switch (directionToMoveMouse)
		{
			//illegal move, move mouse back to [0],[0]
			case 0:
				movementDirection = "NORTHWEST";
				mouseMovementNorthWest();
				checkIfMoveIsLegal();	
				break;
			//illegal move, move mouse back to [0],[0]
			case 1:
				movementDirection = "NORTH";
				mouseMovementNorth();
				checkIfMoveIsLegal();
				break;
			case 2:
				movementDirection = "NORTHEAST";
				mouseMovementNorthEast();
				checkIfMoveIsLegal();
				break;
			//illegal move, move mouse back to [0],[0]	
			case 3:
				movementDirection = "WEST";
				mouseMovementWest();
				checkIfMoveIsLegal();
				break;
			case 4:
				movementDirection = "EAST";
				mouseMovementEast();
				checkIfMoveIsLegal();
				break;
			case 5:
				movementDirection = "SOUTHWEST";
				mouseMovementSouthWest();
				checkIfMoveIsLegal();
				break;
			case 6:
				movementDirection = "SOUTH";
				mouseMovementSouth();
				checkIfMoveIsLegal();
				break;
			case 7:
				movementDirection = "SOUTHEAST";
				mouseMovementSouthEast();
				checkIfMoveIsLegal();
				break;
		}
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Considered an illegal move and mouse's position is set back to (0,0).
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementNorth()
	{
		die();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Considered an illegal move and mouse's position is set back to (0,0).
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementNorthWest()
	{
		die();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Adds integer to the width of the mouse's position, and subtracts integer from mouse's height.
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementNorthEast()
	{
		positionOfMouseWidth += walk();
		positionOfMouseHeight -= walk();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Considered an illegal move and mouse's position is set back to (0,0).
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementWest()
	{
		die();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Adds integer to mouse's width, mouse's height stays the same.
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementEast()
	{
		positionOfMouseWidth += walk();
		//height stays the same
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Adds integer to mouse's height, mouse's width stays the same.
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementSouth()
	{
		//width stays the same
		positionOfMouseHeight += walk();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Subtracts integer from mouse's width, adds integer to mouse's height.
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementSouthWest()
	{
		positionOfMouseWidth -= walk();
		positionOfMouseHeight += walk();
	}
	/**
	 * @pre Mouse object must be created.
	 * @post Adds integer to mouse's width, adds integer to mouse's height.
	 * @param -none-
	 * @return -none-
	 */
	private void mouseMovementSouthEast()
	{
		positionOfMouseWidth += walk();
		positionOfMouseHeight += walk();
	}	
	/**
	 * @pre Mouse object must have been created.
	 * @post Checks the mouse's location to see if the move it just made was legal or not.
	 * If its position is not legal, the mouse is set back to position (0,0).
	 * @param -none-
	 * @return -none-
	 */
	public void checkIfMoveIsLegal()
	{
		int widthMax = MouseMazeMain.boardWidth ;
		int heightMax = MouseMazeMain.boardHeight ;
		int widthMin = 0;
		int heightMin = 0;
		if (positionOfMouseHeight < 0)
		{
			this.die();
		}
		if (positionOfMouseWidth < 0)
		{
			this.die();
		}
		if ((positionOfMouseHeight == heightMin) && (movementDirection.equalsIgnoreCase("northeast")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMax) && (movementDirection.equalsIgnoreCase("east")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMax) && (movementDirection.equalsIgnoreCase("northeast")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMax) && (movementDirection.equalsIgnoreCase("southeast")))
		{
			this.die();
		}
		if ((positionOfMouseHeight == heightMax) && (movementDirection.equalsIgnoreCase("south")))
		{
			this.die();
		}
		if ((positionOfMouseHeight == heightMax) && (movementDirection.equalsIgnoreCase("southwest")))
		{
			this.die();
		}
		if ((positionOfMouseHeight == heightMax) && (movementDirection.equalsIgnoreCase("southeast")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMin) && (movementDirection.equalsIgnoreCase("west")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMin) && (movementDirection.equalsIgnoreCase("northwest")))
		{
			this.die();
		}
		if ((positionOfMouseWidth == widthMin) && (movementDirection.equalsIgnoreCase("southwest")))
		{
			this.die();
		}
	}
}
