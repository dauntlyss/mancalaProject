package edu.westga.cs6910.mancala.model;

import edu.westga.cs6910.mancala.model.strategies.NearStrategy;
import edu.westga.cs6910.mancala.model.strategies.SelectStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Mancala.
 * It always selects the closest pit for stones to be distributed
 * 
 * @author 	Alyssa Harris CS6910
 * @version Summer 2022
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private SelectStrategy strategy;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame	The Game that this player represents
	 */
	public ComputerPlayer(Game theGame) {
		super(NAME, theGame);	
		this.strategy = new NearStrategy();
		this.setStrategy(this.strategy);
	}
	
	@Override
	/**
	 * @see Player#takeTurn(int)
	 */
	public void takeTurn(int pitChoice) {
		pitChoice = this.strategy.selectPit(this.getGame().getGameBoard());
		
		this.getGame().distributeStonesFrom(pitChoice);

		this.setIsMyTurn(false);
	}
	
	/**
	 * Sets which strategy the player will use
	 * 
	 * @param someStrategy
	 * 
	 * @requires	someStrategy != null
	 * @ensures	specified strategy will determine how the player will play
	 */
	public void setStrategy(SelectStrategy someStrategy) {
		if (someStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy.");
		}
		this.strategy = someStrategy;
	}

}
