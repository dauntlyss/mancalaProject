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
	private int currentPit;

	/**
	 * Creates a Mancala Game with the specified Players
	 * 
	 */
	public Game() {
		this.theHuman = new HumanPlayer("Human", this);
		this.theComputer = new ComputerPlayer(this);

		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.theBoard = new int[8];
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer the Player who takes the first turn
	 * 
	 * @require firstPlayer != null &&
	 * 
	 * @ensures whoseTurn().equals(firstPlayer)
	 */
	public void startNewGame(Player firstPlayer, int numberOfStones) {
		this.resetBoard(numberOfStones);
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
		int pitToSkip = 0;
		
		if (pitNumber < this.theBoard.length / 2) {
			pitToSkip = this.theBoard.length - 1;
		} else {
			pitToSkip = this.theBoard.length / 2 - 1;
		}
		
		int currentPit = pitNumber + 1;
		
		while (amountOfStones > 0) {
			if (currentPit % this.theBoard.length != pitToSkip) {
				int[] theBoard = this.theBoard;
				int place = currentPit % this.theBoard.length;
				theBoard[place] += 1;
				amountOfStones -= 1;
			}
			currentPit += 1;
		}
		this.currentPit = currentPit % this.theBoard.length;
		System.out.println(this.currentPit);
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
			this.determineIfGetExtraTurn();
		}
	}
	
	public void determineIfGetExtraTurn() {
		if (this.currentPit == 4 || this.currentPit == 8) {
			this.addListener(null);
			this.keepCurrentPlayer();
			System.out.println("extraTurn!");
		} else {
			this.swapWhoseTurn();
		}
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
	 * Sets up the board such that there is exactly 1 stone in each pit
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
	
	private void keepCurrentPlayer() {
		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.currentPlayerObject.setValue(this.theHuman);
		} else {
			this.currentPlayerObject.setValue(this.theComputer);
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
