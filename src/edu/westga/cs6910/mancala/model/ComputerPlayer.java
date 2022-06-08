package edu.westga.cs6910.mancala.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Mancala.
 * It always selects the closest pit for stones to be distributed
 * 
 * @author 	Alyssa Harris CS6910
 * @version Summer 2022
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame	The Game that this player represents
	 * 
	 */
	public ComputerPlayer(Game theGame) {
		super(NAME, theGame);
	}	

}
