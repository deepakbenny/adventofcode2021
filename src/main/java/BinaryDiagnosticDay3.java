import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author dbenny
 */
public class BinaryDiagnosticDay3 implements AdvofCode2021{

	private static final String INPUT_FILE = "src/main/resources/BinarySweepInput.txt";

	@Override
	public void process() {

		try {
			List<String> fileLines = Files.readAllLines(Paths.get(INPUT_FILE));
			int lineLength = fileLines.get(0).split("").length;

			Pair<String, String> gammaEpsilon = IntStream.range(0, lineLength).boxed()
					.map(index -> (int) countOne(fileLines, index))
					.map(sum -> findCommonBit(sum))
					.reduce(new ImmutablePair<>("", ""), (curr, next) -> new ImmutablePair<>(curr.getLeft() + next.getLeft(), curr.getRight() + next.getRight()));


			System.out.println("answer is " + Integer.valueOf(gammaEpsilon.getLeft()) * Integer.valueOf(gammaEpsilon.getRight()));

		} catch (Exception e) {
			System.out.println("exception is " + e);
		}
	}

	private Pair<String, String> findCommonBit(long sum) {
		if (sum >= 0) {
			return new ImmutablePair<>("1", "0");
		}
		return new ImmutablePair<>("0", "1");
	}

	private long countOne(List<String> lines, int index) {
		return lines.stream()
					   .mapToLong(bit -> bit.charAt(index) == '1' ? 1 : -1)
					   .sum();
	}
}