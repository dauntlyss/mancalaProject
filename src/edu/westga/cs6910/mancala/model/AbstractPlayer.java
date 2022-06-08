package edu.westga.cs6910.mancala.model;

/**
 * Represents the available behavior of a Player in the game mancala.
 * Implements the previously shared code of the Player classes. 
 * 
 * @author Alyssa Harris
 * @version 06/07/2022
 *
 */
public abstract class AbstractPlayer implements Player {
	
	private Game theGame;
	private String name;
	private boolean isMyTurn;
	
	/**
	 * Creates a new Player object with the specified name
	 * @param name	this Player's name
	 * @param theGame	The Game that this player represents
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer(String name, Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		if (name == null) {
			throw new IllegalArgumentException("Invalid player name");
		}
		this.name = name;
		this.theGame = theGame;
	}

	@Override
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setIsMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
		
	}

	@Override
	public void takeTurn(int pitChoice) {
		Player simpleComputer = this.theGame.getComputerPlayer();
		
		if (this.theGame.getCurrentPlayer() == simpleComputer) {
			pitChoice = this.theGame.getBoardSize() - 2;
		}
		
		while (this.theGame.getStones(pitChoice) == 0) {
			pitChoice--;
		}
		this.theGame.distributeStonesFrom(pitChoice);

		this.isMyTurn = false;
	}

}
