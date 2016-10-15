package GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import List.LoadImages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;

public class Controller implements Initializable {
	
	@FXML
	private TextField textfield;
	@FXML
	private Button back;
	@FXML
	private Button pause;
	@FXML
	private Button forward;
	@FXML
	private ImageView image;
	@FXML
	private Button load;
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		image.setImage(new Image("data/default.png"));
		load.setOnAction(e-> {
			final DirectoryChooser directoryChooser =
	                new DirectoryChooser();
	            final File selectedDirectory =
	                    directoryChooser.showDialog(image.getScene().getWindow());
	            if (selectedDirectory != null) {
	                LoadImages.load(new File(selectedDirectory.getAbsolutePath()));
		    		image.setImage(LoadImages.getRandomImage());
	            }
	            


		});
	}
	

}
