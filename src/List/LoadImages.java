package List;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class LoadImages {
	
	private static ArrayList<Image> imageBase = new ArrayList<>();
	
	static final String[] EXTENSIONS = new String[] {
			"png", "jpg"
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
	
	public static void load(File address) {
		if (address.isDirectory()) {
			for (final File f: address.listFiles(IMAGE_FILTER)) {
				try {
					imageBase.add(new Image(f.toURI().toString()));
					System.out.println(f.getAbsolutePath());
				} catch (Exception e) {
					System.exit(1);
					System.out.println("Invalid Input");
				}
			}
		}
	}
	
	public static Image getRandomImage() {
		return imageBase.get((int) (Math.random() * imageBase.size()));
	}
}
