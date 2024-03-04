package application;
	
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	//Declare field for output text
	private TextField dateTimeField;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			GridPane root = new GridPane();				//Positions components within scene
			Scene scene = new Scene(root);				//Scene contains all content
			Label dateLabel = new Label("Date & Time:");	//Label for Date and Time field
			dateLabel.setLabelFor(dateTimeField);
			dateTimeField = new TextField();		//Field for Date and Time
			
			//Create random
			Random random = new Random();
			
			//Generate random number for hue. Green is between 81 and 140. 140 - 81 = 59 so that is the range for our hue value
			int hue = random.nextInt(59);
			
			//Set title of stage
			primaryStage.setTitle("Module 3");
			
			//Create MenuBar
			MenuBar menuBar = new MenuBar();
			
			//Create menu and menu items
			Menu menu = new Menu("Menu");
			MenuItem dateTime = new MenuItem("Date & Time");
			MenuItem saveText = new MenuItem("Save Text to Log");
			MenuItem randomGreen = new MenuItem("Change Background Color to Green");
			MenuItem exit = new MenuItem("Exit");
			
			//Add menu items to menu
			menu.getItems().addAll(dateTime, saveText, randomGreen, exit);
			
			//Add menu to menubar
			menuBar.getMenus().addAll(menu);
			
			//Add ActionEvent handling to menu items FIXME create methods for actions
			dateTime.setOnAction(e -> printDateTime());
			saveText.setOnAction(e -> writeToFile());
			randomGreen.setOnAction(e -> changeBackgroundColor(root, hue));
			exit.setOnAction(e -> primaryStage.close());
			
			//Configure text area
			dateTimeField.setEditable(false);
			dateTimeField.setPrefHeight(100);
			
			//Add MenuBar and dateTimeField to root layout
			root.add(menuBar, 0, 0);
			root.add(dateTimeField, 1, 1);
			root.add(dateLabel, 0, 1);
			root.setPadding(new Insets(10));
			
			
			//Set scene and show
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method for printing local date and time
	private void printDateTime() {
		//Save local date and time
		LocalDateTime now = LocalDateTime.now();
		
		//Create formatter with desired style
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		
		//Save formatted dateTime string 
		String formattedDateTime = now.format(formatter);
		
		//Output formatted date time in dateTimeField
		dateTimeField.appendText(formattedDateTime + "\n");
	}
	
	//Method for writing text area to file
	private void writeToFile() {
		try {
			//Write contents of dateTimeField to log.txt
			FileWriter writer = new FileWriter("log.txt", true);
			writer.write(dateTimeField.getText());
			writer.close();
			Alert alert = new Alert(AlertType.INFORMATION, "Contents written to log.txt");
			alert.showAndWait();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Method for changing background color
	private void changeBackgroundColor(GridPane root, int hue) {
		//Create color object with hue + 81.0 to encompass all hue degrees for green
		Color color = Color.hsb(hue + 81.0, 1.0, 0.50);
		
		//Set style of GridPane to change color
		root.setStyle("-fx-background-color: " + color.toString().replace("0x", "#") + ";");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
