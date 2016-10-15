package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserInterface extends Application{

	private Stage primaryStage;
	private AnchorPane anchorPane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PhotoViewer");
		loadView();
	}
	
	private void loadView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserInterface.class.getResource("View.fxml"));
		anchorPane = loader.load();
		
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
