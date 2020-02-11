package co.grandcircus;


import java.util.ArrayList;
import java.util.List;

/**
 * An interface that represents the ability to convert objects
 * to and from lines in a file. You should implement this interface
 * to define how the conversion in each direction is done.
 *
 * @param <T> This interface has a generic type just like List<T>.
 *        When you implement this interface use this to specify what
 *        type of object you are converting to and from.
 */
public interface LineConverter<T> {
	
	/**
	 * Defines how to convert an object to a line in the file
	 * using the appropriate delimiter
	 * @param object the object to convert to a line
	 * @return the line to write, as a string
	 */
	String toLine(T object);
	
	/**
	 * Defines how to convert a line in the file to an object
	 * using the appropriate delimiter
	 * @param line a line from the file as a String
	 * @return the object converted from that line
	 */
	T fromLine(String line);
	
	
	
	// NOTE: the next two methods are "default" methods, an advanced feature
	// interfaces can have "default" methods that are pre-written.
	// You do not need to implement these.
	
	/**
	 * Handy method for using {@link #toLine(Object)} to convert a list of objects.
	 * @param objects list of objects to convert to a list of lines
	 * @return a list of lines converted from the list of objects
	 */
	default List<String> toLines(List<T> objects) {
		List<String> lines = new ArrayList<>();
		for (T object : objects) {
			lines.add(toLine(object));
		}
		return lines;
	}
	
	/**
	 * Handy method for using {@link #fromLine(String)} to convert a list of lines.
	 * @param lines list of lines to convert to objects
	 * @return a list of objects converted form the list of lines
	 */
	default List<T> fromLines(List<String> lines) {
		List<T> objects = new ArrayList<>();
		for (String line : lines) {
			objects.add(fromLine(line));
		}
		return objects;
	}

}


