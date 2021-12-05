import jdk.internal.util.xml.impl.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;

/**
 * @author dbenny
 */
public class DiveDay2 {

	private static final String INPUT_FILE = "src/main/resources/DiveInput.txt";

	public void process() throws IOException {

		List<String> fileLines = Files.readAllLines(Paths.get(INPUT_FILE));


		int horizontal = 0;
		int vertical = 0;
		for (String line : fileLines) {

			String[] lineArr = line.split(" ");
			String direction = lineArr[0];
			Integer units = Integer.valueOf(lineArr[1]);

			if (direction.equalsIgnoreCase("forward")) {
				horizontal += units;
			} else if (direction.equalsIgnoreCase("up")) {
				vertical -= units;
			} else if (direction.equalsIgnoreCase("down")) {
				vertical += units;
			}
		}
		System.out.println("hori " + horizontal + " vertical " + vertical);

		System.out.println(horizontal*vertical);
	}

}
