package GUI;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import List.ImagesLinkedList;
import List.MyListIterator;
import List.LoadImages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
	private ImageView imageView;
	@FXML
	private Button load;
	@FXML
	private TitledPane listPane;
	
	
	private MyListIterator<Image> iterator;

	

	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imageView.setImage(new Image("data/default.png"));
		load.setOnAction(e -> loadImagesClick());
		back.setOnAction(e -> backFunction());
		forward.setOnAction(e-> forward());
		
	}
	

	private void forward() {
		if (iterator.hasNext()) {
		Image img = iterator.next();
		imageView.setImage(img);
		textfield.setText(getShortenedName(img.impl_getUrl()));
		} else {
			iterator.reset();
			forward();
		}
	}
	
	private void backFunction() {
		if (iterator.hasPrev()) {
			Image img = iterator.prev();
			
		}
	}

	private void loadImagesClick() {
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		final File selectedDirectory = directoryChooser.showDialog(imageView.getScene().getWindow());
		if (selectedDirectory != null) {
			LoadImages.load(new File(selectedDirectory.getAbsolutePath()));
			iterator = LoadImages.getList().iterator();
			setupListPane(selectedDirectory.getName());
			forward();
		}
	}

	private void setupListPane(String folderName) {
		listPane.setText(folderName);		
		VBox vbox = new VBox();
		iterator.reset();
		while (iterator.hasNext()) {
			Image img = iterator.next();
			Label name = new Label(getShortenedName(img.impl_getUrl()));
			name.setMaxWidth(100);
			name.setEllipsisString("...");
			vbox.getChildren().add(name);
		}
		listPane.setContent(vbox);
	}
	
	private String getShortenedName(String name) {
		String toret = name.substring(name.lastIndexOf("/")+1);
		return toret;
	}

}
