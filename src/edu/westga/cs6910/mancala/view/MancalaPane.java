package edu.westga.cs6910.mancala.view;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;
import edu.westga.cs6910.mancala.model.strategies.FarStrategy;
import edu.westga.cs6910.mancala.model.strategies.NearStrategy;
import edu.westga.cs6910.mancala.model.strategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Mancala game.
 * Started by CS6910.  Fill your name into Javadoc below
 * 
 * @author Alyssa Harris
 * @version 06/07/2022
 * 
 */
public class MancalaPane extends BorderPane {
	private Game theGame;
	private GridPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	private Pane pnChooseNumberOfStones;
	private MenuPane menuPane;
	
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
		this.addMenuPane(theGame);
		this.addNumberOfStonesPane();
	
		this.pnComputerPlayer = new ComputerPane(theGame);
		this.pnComputerPlayer.setDisable(true);
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");
		leftBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.add(leftBox, 0, 2);
		
		this.pnHumanPlayer = new HumanPane(theGame);
		this.pnHumanPlayer.setDisable(true);
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");
		rightBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.add(rightBox, 0, 3);
		
		this.pnGameInfo = new StatusPane(theGame);
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("pane-border");
		bottomBox.getChildren().add(this.pnGameInfo);
		this.pnContent.add(bottomBox, 0, 4);
		
		this.setCenter(this.pnContent);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		this.pnChooseFirstPlayer.setDisable(true);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.add(topBox, 0, 1);
	}
	
	private void addMenuPane(Game theGame) {
		HBox menuBox = new HBox();
		this.menuPane = new MenuPane(this, theGame);
		menuBox.getChildren().add(this.menuPane);
		menuBox.prefWidthProperty().bind(this.widthProperty());
		this.setTop(menuBox);
	}
	
	private void addNumberOfStonesPane() {
		HBox topRightBox = new HBox();
		topRightBox.getStyleClass().add("pane-border");	
		this.pnChooseNumberOfStones = new NumberOfStonesPane();
		topRightBox.getChildren().add(this.pnChooseNumberOfStones);
		this.pnContent.add(topRightBox, 0, 0);
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
			
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			ToggleGroup buttonGroup = new ToggleGroup();
			this.radComputerPlayer.setToggleGroup(buttonGroup);
			this.radHumanPlayer.setToggleGroup(buttonGroup);
			
			this.add(this.radHumanPlayer, 0, 0);
			this.add(this.radComputerPlayer, 1, 0);
			
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
				
				MancalaPane.this.theGame.startNewGame(NewGamePane.this.theComputer, NewGamePane.this.theGame.getNumberOfStartingStones());
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
				MancalaPane.this.pnHumanPlayer.setDisable(false);
				MancalaPane.this.pnChooseFirstPlayer.setDisable(true);
				MancalaPane.this.theGame.startNewGame(NewGamePane.this.theHuman, NewGamePane.this.theGame.getNumberOfStartingStones());

			}
		}
	}
	
	/**
	 * Defines the panel in which the user inputs how many stones per pit.
	 */
	private final class NumberOfStonesPane extends GridPane {
		private Label stones;
		private TextField numberOfStones;
		private Button setButton;
		
		private NumberOfStonesPane() {
			this.stones = new Label("Number of Stones:");
			this.numberOfStones = new TextField();
			this.setButton = new Button("SET");
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(10);
			
			this.add(this.stones, 2, 0);
			this.add(this.numberOfStones, 3, 0);
			this.add(this.setButton, 4, 0);
			
			this.setButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						int stones = Integer.parseInt((NumberOfStonesPane.this.numberOfStones.getText()));
						MancalaPane.this.theGame.setNumberOfStartingStones(stones);
						MancalaPane.this.pnChooseNumberOfStones.setDisable(true);
						MancalaPane.this.pnChooseFirstPlayer.setDisable(false);
					} catch (IllegalArgumentException ex) {
						Alert noStonesAlert = new Alert(AlertType.ERROR);
						noStonesAlert.setTitle("Mancala");
						noStonesAlert.setHeaderText("Please enter a valid number greater than 0.");
						noStonesAlert.showAndWait();
						NumberOfStonesPane.this.numberOfStones.clear();
					}
				}
			});
		}
	}
	
	/*
	 * Defines the menu bar where players can chose the ComputerPlayer's strategy or exit.
	 */
	private final class MenuPane extends GridPane {
		private MenuBar menuBar;
		private Game theGame;
		private MancalaPane theMancalaPane;
		private Menu gameMenu;
		private Menu computerPlayerMenu;
		
		private MenuItem exit;
		private RadioMenuItem nearStrategy;
		private RadioMenuItem farStrategy;
		private RadioMenuItem randomStrategy;
		
		private MenuPane(MancalaPane theMancalaPane, Game theGame) {
			this.theGame = theGame;
			this.menuBar = new MenuBar();
			this.gameMenu = new Menu("_Game");
			this.computerPlayerMenu = new Menu("_Computer Player");
			this.theMancalaPane = theMancalaPane;
			
			this.buildMenuPane();
		}
		
		private void buildMenuPane() {
			this.exit = new MenuItem("E_xit");
			this.exit.setAccelerator(KeyCombination.keyCombination("shortcut + X"));
			this.gameMenu.getItems().add(this.exit);
			this.gameMenu.setMnemonicParsing(true);
			this.exit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
				}
			});
			
			this.getNearStrategy();
			this.getFarStrategy();
			this.getRandomStrategy();
			
			this.getToggleGroup(this.nearStrategy, this.farStrategy, this.randomStrategy);
			
			this.computerPlayerMenu.getItems().addAll(this.nearStrategy, this.farStrategy, this.randomStrategy);
			this.computerPlayerMenu.setMnemonicParsing(true);
			this.menuBar.getMenus().addAll(this.gameMenu, this.computerPlayerMenu);
			this.menuBar.prefWidthProperty().bind(this.theMancalaPane.widthProperty());
			this.add(this.menuBar, 0, 0);
		}
		
		private ToggleGroup getToggleGroup(RadioMenuItem strategy1, RadioMenuItem  strategy2, RadioMenuItem strategy3) {
			ToggleGroup toggleGroup = new ToggleGroup();
			strategy1.setToggleGroup(toggleGroup);
			strategy1.setSelected(true);
			strategy2.setToggleGroup(toggleGroup);
			strategy3.setToggleGroup(toggleGroup);
			
			return toggleGroup;
		}
		
		private void getRandomStrategy() {
			this.randomStrategy = new RadioMenuItem("_Random");
			this.randomStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + R"));
			this.randomStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new RandomStrategy());
				}
			});
		}
		
		private void getNearStrategy() {
			this.nearStrategy = new RadioMenuItem("_Near");
			this.nearStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + N"));
			this.nearStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new NearStrategy());
				}
			});
		}
		
		private void getFarStrategy() {
			this.farStrategy = new RadioMenuItem("F_ar");
			this.farStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + A"));
			this.farStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new FarStrategy());
				}
			});
		}
	}
}
