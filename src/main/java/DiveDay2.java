import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dbenny
 */
public class DiveDay2 {

	private static final String INPUT_FILE = "src/main/resources/DiveInput.txt";

	public enum Directions {

		FORWARD {
			@Override
			public int getAbsoluteValue(int num) {
				return num;
			}
		},
		UP {
			@Override
			public int getAbsoluteValue(int num) {
				return -num;
			}

		},
		DOWN {
			@Override
			public int getAbsoluteValue(int num) {
				return num;
			}
		};

		public int getAbsoluteValue(int num) {
			return num;
		}
	}

	public void process() throws IOException {

		List<String> fileLines = Files.readAllLines(Paths.get(INPUT_FILE));

		List<Pair<Directions, Integer>> directionUnits = fileLines.stream()
																 .map(line -> line.split(" "))
																 .map(this::createDirectionPair)
																 .collect(Collectors.toList());

		System.out.println("part one answer is " + calculatePartOneAnswer(directionUnits));
	}

	private int calculatePartOneAnswer(List<Pair<Directions, Integer>> directionUnits) {

		EnumSet<Directions> horizontalE = EnumSet.of(Directions.FORWARD);
		EnumSet<Directions> verticalE = EnumSet.of(Directions.UP, Directions.DOWN);

		int horizontalSum = calculateSumByDirection(directionUnits, horizontalE);
		int verticalSum = calculateSumByDirection(directionUnits, verticalE);

		return horizontalSum * verticalSum;
	}

	private int calculateSumByDirection(List<Pair<Directions, Integer>> directionUnits, EnumSet<Directions> directionSet) {

		return directionUnits.stream()
				.filter( i -> directionSet.contains(i.getKey()))
				.mapToInt(i -> i.getValue())
				.sum();
	}

	private Pair<Directions, Integer> createDirectionPair(String[] splitLine) {

		Directions directions = Directions.valueOf(splitLine[0].toUpperCase());
		Integer unit = directions.getAbsoluteValue(Integer.parseInt(splitLine[1]));
		return new ImmutablePair<Directions, Integer>(directions, unit);
	}
}
