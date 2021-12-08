import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dbenny
 */
public class SonarSweepDay1 implements AdvofCode2021 {

	private static final String INPUT_FILE = "src/main/resources/SonarSweepInput.txt";

	public void process() {

		try {

			List<String> fileLines = Files.readAllLines(Paths.get(INPUT_FILE));

			int previousIndex;
			int currentIndex;

			int previousEle;
			int currentEle;

			int counter = 0;
			for (int i = 0; i < fileLines.size(); i ++) {
				previousIndex = i - 1;
				currentIndex = i;

				if (previousIndex >= 0) {
					previousEle = Integer.parseInt(fileLines.get(previousIndex));
					currentEle = Integer.parseInt(fileLines.get(currentIndex));

					if (currentEle > previousEle) {
						counter ++;
					}
				}

			}
			System.out.println("number of increments="+ counter);

		} catch (Exception e) {
			System.out.println("failed to calculate answer, exception=" + e);
		}
	}
}
