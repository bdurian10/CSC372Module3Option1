package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			GridPane gridPane = new GridPane();				//Positions components within scene
			Scene scene = new Scene(gridPane);				//Scene contains all content
			Label dateLabel = new Label("Date & Time:");	//Label for Date and Time field
			TextField dateTimeField = new TextField();		//Field for Date and Time
			
			//Set title of stage
			primaryStage.setTitle("Module 3");
			
			//Create MenuBar
			MenuBar menuBar = new MenuBar();
			
			/*final VBox vbox = new VBox();
			*vbox.setAlignment(Pos.CENTER);
			*vbox.setSpacing(10);
			*vbox.setPadding(new Insets(0, 10, 0, 10));
			*vbox.getChildren().addAll(null
			*/
			//Create menu and menu items
			Menu menu = new Menu("Menu");
			MenuItem dateTime = new MenuItem("Date & Time");
			dateTime.setOnAction((ActionEvent t) -> {
				
			});
			MenuItem saveText = new MenuItem("Save Text to Log");
			MenuItem randomGreen = new MenuItem("Change Hue of Green");
			MenuItem exit = new MenuItem("Exit");
			
			menu.getItems().addAll(dateTime, saveText, randomGreen, exit);
			
			
			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
