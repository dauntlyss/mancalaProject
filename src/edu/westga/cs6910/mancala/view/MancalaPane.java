package edu.westga.cs6910.mancala.view;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Mancala game.
 * Started by CS6910.  Fill your name into Javadoc below
 * 
 * @author Alyssa Harris
 * @version 099/07/2022
 * 
 */
public class MancalaPane extends BorderPane {
	private Game theGame;
	private GridPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param 	theGame		the domain model object representing the Mancala game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public MancalaPane(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		
		this.theGame = theGame;
		this.pnContent = new GridPane();		
		this.addFirstPlayerChooserPane(theGame);		
	
		this.pnComputerPlayer = new ComputerPane(theGame);
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");
		leftBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.add(leftBox, 0, 1);
		
		this.pnHumanPlayer = new HumanPane(theGame);
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");
		rightBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.add(rightBox, 0, 2);
		
		this.pnGameInfo = new StatusPane(theGame);
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("pane-border");
		bottomBox.getChildren().add(this.pnGameInfo);
		this.pnContent.add(bottomBox, 0, 3);
		
		this.setCenter(this.pnContent);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.add(topBox, 0, 0);
	}
	
	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			// TODO: Instantiate the computer player button and add 
			//		 ComputerFirstListener as its action listener.
			
			// TODO: Create a ToggleGroup and add the 2 radio buttons to it.
			
			// TODO: Add the 2 radio buttons to this pane.
			
		}
		
		/* 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				MancalaPane.this.pnComputerPlayer.setDisable(false);
				MancalaPane.this.pnChooseFirstPlayer.setDisable(true);
				MancalaPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/* 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/* 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				MancalaPane.this.pnChooseFirstPlayer.setDisable(true);
				// TODO: Enable the human player panel and start a game
				//		 with the human playing first.

			}
		}
	}
}
