package List;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class LoadImages {
	
	
	static final String[] EXTENSIONS = new String[] {
			"png", "jpg", "JPG"
	};
	
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext: EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return true;
				}
			}
			return false;
			
		}
	};
	

	private static ImagesLinkedList list;
	
	public static void load(File address) {
		if (address.isDirectory()) {
			list = new ImagesLinkedList();
			for (final File f: address.listFiles(IMAGE_FILTER)) {
				try {
					list.add(new Image(f.toURI().toString()));
				} catch (Exception e) {
					System.exit(1);
					System.out.println("Invalid Input");
				}
			}
		} else {
			System.out.println("ERROR OCCURRED");
		}
	}
	
	public static ImagesLinkedList getList() {
		return list;
	}


	
	public static ImagesLinkedList getArrayList() {
		return null;
	}
}
