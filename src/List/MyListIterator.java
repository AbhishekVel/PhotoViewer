package List;

public interface MyListIterator<T> {
	
	public boolean hasNext();
	public boolean hasPrev();
	public T next();
	public T prev();
	public void reset();

}
