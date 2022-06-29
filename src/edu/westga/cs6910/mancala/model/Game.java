package edu.westga.cs6910.mancala.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Mancala game.  
 * Started by CS6910.  Fill your name into Javadoc below
 * 
 * @author Alyssa Harris	
 * @version 06/07/2022
 */
public class Game implements Observable {
	private int[] theBoard;

	private ObjectProperty<Player> currentPlayerObject;
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private Player theWinner;
	private boolean isGameOver;
	private String turnStatusUpdate;
	private int startingStones;

	/**
	 * Creates a Mancala Game with the specified Players
	 * 
	 */
	public Game() {
		this.theHuman = new HumanPlayer("Human", this);
		this.theComputer = new ComputerPlayer(this);

		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.theBoard = new int[8];
		this.turnStatusUpdate = "";
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer the Player who takes the first turn
	 * @param numberOfStones number of stones to start with
	 * 
	 * @require firstPlayer != null && numberOfStones > 0
	 * 
	 * @ensures whoseTurn().equals(firstPlayer)
	 */
	public void startNewGame(Player firstPlayer, int numberOfStones) {
		this.startingStones = numberOfStones;
		this.resetBoard(this.startingStones);
		this.currentPlayerObject.setValue(firstPlayer);
	}

	/**
	 * Distributes the stones located in pitNumber to all subsequent pits, one at a
	 * time in counter-clockwise order
	 * 
	 * @param pitNumber The pit number where the stones are to be taken
	 */
	public void distributeStonesFrom(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		int amountOfStones = this.theBoard[pitNumber];
		this.theBoard[pitNumber] = 0;
		int stonesPlaced = 0;
		for (int index = 0; stonesPlaced < amountOfStones; stonesPlaced++) {
			if (pitNumber + index + 1 < this.getBoardSize()
                    && !((this.getCurrentPlayer().equals(this.theHuman) && pitNumber + index + 1 == this.getBoardSize() - 1)
                            || (this.getCurrentPlayer().equals(this.theComputer)
                                    && pitNumber + index + 1 == this.theBoard.length / 2 - 1))) {
                this.theBoard[pitNumber + index + 1]++;
                index++;
            } else if (((this.getCurrentPlayer().equals(this.theHuman) && pitNumber + index + 1 == this.getBoardSize() - 1)
                    || (this.getCurrentPlayer().equals(this.theComputer)
                            && pitNumber + index + 1 == this.theBoard.length / 2 - 1))) {
                stonesPlaced--;
                index++;
            } else {
                pitNumber = 0;
                index = 0;
                this.theBoard[pitNumber + index]++;
            } 
			
			this.determineTurnStatusUpdate(pitNumber, index, stonesPlaced, amountOfStones);
		}
	}

	/**
	 * Returns the number of slots (pits and stores) on the board
	 * 
	 * @return The number of slots on the board
	 */
	public int getBoardSize() {
		return this.theBoard.length;
	}
	
	/**
	 * Returns a message if the player gets a free turn or captures
	 * opponents stones
	 * 
	 * @return The turn status
	 */
	public String getTurnStatusUpdate() {
		return this.turnStatusUpdate;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns whether the game has completed yet or not
	 * 
	 * @return true iff the game is over; false otherwise
	 */
	public boolean getIsGameOver() {
		return this.isGameOver;
	}

	/**
	 * Returns the number of stones in the specified pit
	 * 
	 * @param pitNumber The pit location that is potentially holding stones
	 * @return The number of stones in the specified pit
	 */
	public int getStones(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		return this.theBoard[pitNumber];
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a turn.
	 * Has no effect if the game is over.
	 * 
	 * @param pitChoice The pit number where the stones will be taken from
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play(int pitChoice) {
		Player currentPlayer = this.currentPlayerObject.getValue();
		currentPlayer.takeTurn(pitChoice);

		this.determineIfGameIsOver();
		
		if (this.isGameOver) {
			this.determineWinner();
			this.currentPlayerObject.setValue(null);
		} else {
			this.swapWhoseTurn();
		}
	}
	
	private boolean determineIfGetExtraTurn(int pitNumber, int index) {
		boolean extraTurn;
		if ((this.getCurrentPlayer().equals(this.theComputer) && pitNumber + index == this.getBoardSize() - 1)
                || (this.getCurrentPlayer().equals(this.theHuman)
                        && pitNumber + index == (this.theBoard.length / 2) - 1)) {
			extraTurn = true;
		} else {
			extraTurn = false;
		}
		return extraTurn;
	}
	
	private void determineTurnStatusUpdate(int pitNumber, int index, int stonesPlaced, int amountOfStones) {
		
		if (this.determineIfGetExtraTurn(pitNumber, index) && stonesPlaced + 1 == amountOfStones) {
			this.turnStatusUpdate = this.currentPlayerObject.getValue().getName() + " gets a free turn for landing in the store!";
			this.swapWhoseTurn();
			
		} else if (!this.determineIfGetExtraTurn(pitNumber, index) && stonesPlaced + 1 == amountOfStones
                && this.theBoard[pitNumber + index] == 1 && this.getCurrentPlayer().equals(this.theHuman)
                && this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)] != 0 && (pitNumber + index) < this.getBoardSize() / 2 - 1) {
			this.humanCapture(pitNumber, index);
			
        } else if (!this.determineIfGetExtraTurn(pitNumber, index) && stonesPlaced + 1 == amountOfStones
                && this.theBoard[pitNumber + index] == 1 && this.getCurrentPlayer().equals(this.theComputer)
                && this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)] != 0 && (pitNumber + index) > this.getBoardSize() / 2 - 1) {
            this.computerCapture(pitNumber, index);  
            
        } else {
            this.turnStatusUpdate = "";
        }
	}
	
	private void humanCapture(int pitNumber, int index) {
        this.theBoard[(this.getBoardSize() / 2) - 1] += this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)];
        this.theBoard[(this.getBoardSize() / 2) - 1]++;
        this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)] = 0;
        this.theBoard[pitNumber + index] = 0;
        this.turnStatusUpdate = this.theHuman.getName() + " captured all the stones in pit " 
        		+ ((this.getBoardSize() - 2) - (pitNumber + index)) + "!";
	}
	
	private void computerCapture(int pitNumber, int index) {
		this.theBoard[this.getBoardSize() - 1] += this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)];
		this.theBoard[this.getBoardSize() - 1]++;
		this.theBoard[(this.getBoardSize() - 2) - (pitNumber + index)] = 0;
		this.theBoard[pitNumber + index] = 0;
		this.turnStatusUpdate = this.theComputer.getName() + " captured all the stones in pit "
				+ ((this.getBoardSize() - 2) - (pitNumber + index)) + "!";
	}

	private void determineIfGameIsOver() {
		int humanStoneCount = 0;
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			humanStoneCount += this.theBoard[index];
		}

		int computerStoneCount = 0;
		for (int index = this.theBoard.length / 2; index < this.theBoard.length - 1; index++) {
			computerStoneCount += this.theBoard[index];
		}

		if (humanStoneCount == 0 || computerStoneCount == 0) {
			this.isGameOver = true;
		} else {
			this.isGameOver = false;
		}
	}

	private void determineWinner() {
		int humanStore = this.theBoard[this.theBoard.length / 2 - 1];
		int computerStore = this.theBoard[this.theBoard.length - 1];

		if (humanStore > computerStore) {
			this.theWinner = this.theHuman;
		} else if (humanStore < computerStore) {
			this.theWinner = this.theComputer;
		} else {
			this.theWinner = null;
		}
	}

	/**
	 * Returns a copy of the game board keeping track of the number of stones in
	 * each pit
	 * 
	 * @return The game board
	 */
	public int[] getGameBoard() {
		return this.theBoard.clone();
	}
	
	/**
	 * Sets the number of stones in each pit
	 * 
	 * @param numberOfStones number of stones to start with
	 * 
	 * @requires numberOfStones > 0
	 */
	public void setNumberOfStartingStones(int numberOfStones) {
		if (numberOfStones <= 0) {
			throw new IllegalArgumentException("Please enter a valid number.");
		}
		this.startingStones = numberOfStones;
	}
	
	/**
	 * Returns number of stones the user would like in each pit
	 * 
	 * @return numberOfStones
	 */
	public int getNumberOfStartingStones() {
		return this.startingStones;
	}

	/**
	 * Sets up the board such that there is exactly 1 stone in each pit
	 * 
	 * @param numberOfStones number of stones to start with
	 */
	private void resetBoard(int numberOfStones) {
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			this.theBoard[index] = numberOfStones;
			this.theBoard[index + this.theBoard.length / 2] = numberOfStones;
		}
	}

	private void swapWhoseTurn() {

		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else {
			this.currentPlayerObject.setValue(this.theHuman);
		}
	}

	/**
	 * Returns a String showing the current score, or, if the game is over, the name
	 * of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {
		String result = this.theHuman.getName() + ": " + this.theBoard[this.theBoard.length / 2 - 1]
				+ System.getProperty("line.separator");
		result += this.theComputer.getName() + ": " + this.theBoard[this.theBoard.length - 1]
				+ System.getProperty("line.separator");
		if (this.isGameOver && this.theWinner != null) {
			result += this.theWinner.getName() + " wins";
		} else if (this.isGameOver && this.theWinner == null) {
			result += "Tie game";
		}

		return result;
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
}
