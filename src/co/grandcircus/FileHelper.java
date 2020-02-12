package co.grandcircus;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An instance of this class can be used to conveniently work with
 * a file that has a list of objects.
 *
 * @param <T> Just like List<T> has a generic type argument to specify
 *        what's in the list. This class has one to specify what kind of
 *        objects the file represents.
 */
public class FileHelper<T> {

	private Path filePath;
	private LineConverter<T> lineConverter;

	/**
	 * @param filePath path to the file
	 * @param lineConverter and instance of a line converter to convert
	 *        lines of the file to and from objects.
	 */
	public FileHelper(String filePath, LineConverter<T> lineConverter) {
		this.filePath = Paths.get(filePath);
		this.lineConverter = lineConverter;
	}
	
	/**
	 * Read a list of all the objects from the file.
	 */
	public List<T> readAll() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			return lineConverter.fromLines(lines);
		} catch (IOException e) {
			return new ArrayList<>();
		}
	}
	
	/**
	 * Add an object to the end of the file.
	 * @param object the object to append.
	 */
	public void append(T object) {
		String line = lineConverter.toLine(object);
		try {
			List<String> lines = Collections.singletonList(line);
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("Error. Unable to write to file.");
		}
	}
	
	/**
	 * Replace the contents of the file with a list of objects.
	 * @param objects the objects to put in the file
	 */
	public void rewrite(List<T> objects) {
		List<String> lines = lineConverter.toLines(objects);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.err.println("Error. Unable to write to file.");
		}
	}
}

