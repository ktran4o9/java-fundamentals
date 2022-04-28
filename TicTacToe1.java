/**
 * Objective: Create a TicTacToe board following the demo video that was given.
 * Created by: Kevin Tran
 * Date: 03/26/2022
 * Version: jre1.8.0_281
 */
//all javafx settings needed to make tictactoe
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class TicTacToe1 extends Application {
	//making the 3x3 square
	private Cell[][] cell = new Cell[3][3];
	private Label lblStatus = new Label ("X's turn to play"); //status to see who's turn goes
	private char whoseTurn = 'X';
	//making the grid with the borders
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane ();
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				pane.add(cell[i][j] = new Cell(), j, i);
			}
		}

		//making the borders
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		Scene scene = new Scene(borderPane,450,170);
		primaryStage.setTitle("TicTacToe1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//determines if all cells are occupied
	public boolean isFull() {
		for (int i=0; i<3; i++) 
			for (int j=0; j<3; j++)
				if (cell[i][j].getToken() == ' ')
					return false;
		return true;
	}
	
	// true or false to determine if a player wins
	public boolean isWon(char token) {
		for (int i=0; i<3; i++) 
			if (cell[i][0].getToken() == token 
			&& cell[i][1].getToken() == token 
			&& cell[i][2].getToken() == token)
		{
		return true;
		} 
		for (int j=0; j<3; j++) 
			if (cell[0][j].getToken() == token
			&& cell[1][j].getToken() == token
			&& cell[2][j].getToken() == token) {
				return true;
			}
		if (cell[0][0].getToken() == token
			&& cell[1][1].getToken() == token
			&& cell[2][2].getToken() == token) {
			return true;
		}
		if (cell[0][2].getToken() == token
			&& cell[1][1].getToken() == token
			&& cell[2][0].getToken() == token) {
			return true;
		}
		return false;
		}
	
	public class Cell extends Pane {
		private char token = ' ';
		//size and color of the tictactoe
		public Cell() {
			setStyle("-fx-border-color:black");
			this.setPrefSize(800, 800);
			this.setOnMouseClicked(e->handleMouseClick()); //handle mouse click method
		}
		//setters and getters
		public char getToken() {
			return token;
		}
		
		public void setToken(char c) {
			token = c;
			
			//making X token
			if(token =='X') {
				Line line1 = new Line(10,10,this.getWidth()-10, this.getHeight()-10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10,this.getHeight()-10, this.getWidth()-10,10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
				this.getChildren().addAll(line1,line2);
			}
			//making O token
			else if (token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth()/2,this.getHeight()/2,
						this.getWidth()/2-10,this.getHeight()/2-10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				this.getChildren().add(ellipse);
			}
		}
		//mouse click method
		private void handleMouseClick() {
			if(token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn);
				if (isWon(whoseTurn)) {
					lblStatus.setText(whoseTurn + " won!  The game is over"); //tells you who wins
					whoseTurn = ' ';
				}
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over"); //tells you it is a draw if no more spots left
					whoseTurn = ' ';
				}
				else {
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X'; // setting it to take turns between X and O
					lblStatus.setText(whoseTurn + "'s turn");
				}
			}
		}
	}
	//launching tictactoe
	public static void main (String[] args) {
		launch(args);
		
	}
}
