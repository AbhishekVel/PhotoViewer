package List;

import javafx.scene.image.Image;

public class ImagesLinkedList {

	private class ImageNode {
		private Image data;
		private ImageNode prev, next;

		public ImageNode(Image data) {
			this.data = data;
		}

	}

	private ImageNode head;

	public ImagesLinkedList add(Image data) {
		ImageNode newNode = new ImageNode(data);
		if (head == null) {
			head = newNode;
		} else {
			ImageNode curr = head;
			while (curr != null) {
				if (curr.next == null) {
					newNode.prev = curr;
					curr.next = newNode;
					break;
				}
				curr = curr.next;
			}
		}
		return this;
	}

	public MyListIterator<Image> iterator() {
		return new MyListIterator<Image>() {

			ImageNode curr = head;

			@Override
			public boolean hasNext() {
				return (curr != null);
			}

			@Override
			public Image next() {
				Image data = curr.data;
				curr = curr.next;
				return data;
			}

			@Override
			public boolean hasPrev() {
				if (curr == null)
					return false;
				return (curr != null);
			}

			@Override
			public Image prev() {
				Image data = curr.data;
				curr = curr.prev;
				return data;
			}

			@Override
			public void reset() {
				curr = head;
			}

		};
	}

}
