/**
 * Objective: Create a Simple Calculator following the demo video that was given.
 * Created by: Kevin Tran
 * Date: 03/26/2022
 * Version: jre1.8.0_281
 */


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

	public void start(Stage primaryStage) {
		//making it horizontally spaced
		FlowPane pane = new FlowPane();
		//space to put gaps between components
		pane.setHgap(2);
		
		//create 3 text fields for entry and result
		TextField tfNumber1 = new TextField();
		TextField tfNumber2 = new TextField();
		TextField tfResult = new TextField();
		
		//column for the text field
		tfNumber1.setPrefColumnCount(3);
		tfNumber2.setPrefColumnCount(3);
		tfResult.setPrefColumnCount(3);
		
		//adding labels
		pane.getChildren().addAll(new Label("Number 1: "), tfNumber1,
				new Label("Number 2: "), tfNumber2,
				new Label("Result: "), tfResult);

		//Adding the buttons to do math
		HBox hBox = new HBox(5);
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		
		//align them to be even in the program
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btAdd,btSubtract,btMultiply,btDivide);
		
		//setting border panes
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		
		//setting scene and stage
		Scene scene = new Scene(borderPane, 250, 150);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//action list to calculate results
		btAdd.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) + 
					Double.parseDouble(tfNumber2.getText()) + "");
		});
		btSubtract.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) - 
					Double.parseDouble(tfNumber2.getText()) + "");
		});		
		btMultiply.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) * 
					Double.parseDouble(tfNumber2.getText()) + "");
		});
		btDivide.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) / 
					Double.parseDouble(tfNumber2.getText()) + "");
		});
		
	}
	
	//launching the program
	public static void main(String[] args) {
		launch(args);
	}

}
