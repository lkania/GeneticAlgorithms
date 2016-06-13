package examples.tpe.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import examples.tpe.Item;

public class ItemsReader {

	private static Pattern newLinePattern = Pattern.compile("\\n");
	private static Pattern TAB_PATTERN = Pattern.compile("\\s+");

	public static Map<Integer, Item> interpreter(String pathString) throws IOException {

		Map<Integer, Item> items = new HashMap<Integer, Item>();

		Path path = Paths.get(pathString);
		Scanner scanner = new Scanner(path);

		scanner.useDelimiter(newLinePattern);

		boolean firstLine = true;

		while (scanner.hasNext()) {

			String line = scanner.next();
	
			if (firstLine) {
				firstLine = false;
				continue;
			}
			
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(TAB_PATTERN);

			int id = lineScanner.nextInt();
			
			
			Item item = new Item(Double.parseDouble(lineScanner.next()),Double.parseDouble(lineScanner.next()), Double.parseDouble(lineScanner.next()),
					Double.parseDouble(lineScanner.next()),Double.parseDouble(lineScanner.next()));

			items.put(id, item);

			lineScanner.close();

		}

		scanner.close();

		return items;

	}

}
