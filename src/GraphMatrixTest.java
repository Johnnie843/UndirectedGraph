import java.util.Random;
import java.util.Scanner;

public class GraphMatrixTest {
	public static void runTest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many tables would you like to test?");
		int numberOfTablesToTest = scan.nextInt();

		for (int i = 0; i < numberOfTablesToTest; i++) {
			System.out.println("Undirected Graph Test Number " + (i + 1) + ":");
			Random random = new Random();
			int greaterThen = 0;
			int lessThen = 10;
			int randomNumber = random.nextInt(lessThen - greaterThen) + greaterThen;
			Graphmu myGraph = new Graphmu(randomNumber);

			for (int j = 0; j < myGraph.n() - 1; j++) {
				greaterThen = 0;
				lessThen = myGraph.n() - 1;
				int randowWeight = random.nextInt(lessThen - greaterThen) + greaterThen;
				int randomRow = random.nextInt(lessThen - greaterThen) + greaterThen;
				int randomCol = random.nextInt(lessThen - greaterThen) + greaterThen;
				myGraph.setEdge(randomCol, randomRow, randowWeight);
			}
			myGraph.printMatrix();
		}

	}
}
