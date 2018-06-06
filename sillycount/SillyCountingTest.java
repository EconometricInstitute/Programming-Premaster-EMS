import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Class that runs some tests on an implementation of the SillyCounting class
 * as described in the example assignment.
 * 
 * @author Paul Bouman
 *
 */

public class SillyCountingTest {

	public static void main(String [] args) {
	
		// This methods just runs the tests
		try
		{
			testExample();
			testFrom75();
			testFrom85();
			testCombinations();
			testMultiInstance();
			// If all tests succeed, print this.
			System.out.println("Congratulations, your program seems to work as intended!");
			System.out.println();
			printSuccess();
		}
		catch (TestFailedException tfe) {
			// If a test fails, print this with information on what went wrong.
			System.out.println("Something is wrong with your program. The following test failed:");
			System.out.println(tfe.getMessage());
		}
		
	}
		
	public static void testExample() {
		ArrayList<String> answer = runCode(6,6);
		ArrayList<String> expected = makeList("6", "NOSE", "8", "9", "10", "BARS");
		assertEq("Testing the example from the assignment document", expected, answer);
	}
	
	public static void testFrom75() {
		ArrayList<String> answer = runCode(75,4);
		ArrayList<String> expected = makeList("NOSE", "NOSE", "BARS NOSE", "NOSE");
		assertEq("Testing four numbers starting at 75, which includes a 'BARS NOSE'", expected, answer);
	}
	
	public static void testFrom85() {
		ArrayList<String> answer = runCode(85,5);
		ArrayList<String> expected = makeList("85","86","NOSE","BARS","YUMMY");
		assertEq("Testing five numbers starting at 85", expected, answer);
	}

	/**
	 * This test checks whether some combinations of the two words are properly generated
	 */
	public static void testCombinations() {
		ArrayList<String> answer, expected;
		
		int num = 711;
		answer = runCode(num,1);
		expected = makeList("BARS NOSE");
		assertEq("Testing whether "+num+" gives 'BARS NOSE'", expected, answer);
		
		num = 789;
		answer = runCode(num,1);
		expected = makeList("NOSE YUMMY");
		assertEq("Testing whether "+num+" gives 'NOSE YUMMY'", expected, answer);
		
		num = 7 * 89;
		answer = runCode(num,1);
		expected = makeList("NOSE YUMMY");
		assertEq("Testing whether "+num+" gives 'NOSE YUMMY'", expected, answer);
		
		num = 1189;
		answer = runCode(num,1);
		expected = makeList("BARS YUMMY");
		assertEq("Testing whether "+num+" gives 'BARS YUMMY'", expected, answer);

		num = 11*4*89;
		answer = runCode(num,1);
		expected = makeList("BARS YUMMY");
		assertEq("Testing whether "+num+" gives 'BARS YUMMY'", expected, answer);

		num = 11 * 89;
		answer = runCode(num,1);
		expected = makeList("BARS NOSE YUMMY");
		assertEq("Testing whether "+num+" gives 'BARS NOSE YUMMY'", expected, answer);

		
		num = 71189;
		answer = runCode(num,1);
		expected = makeList("BARS NOSE YUMMY");
		assertEq("Testing whether "+num+" gives 'BARS NOSE YUMMY'", expected, answer);

		num = 7 * 11 * 89;
		answer = runCode(num,1);
		expected = makeList("BARS NOSE YUMMY");
		assertEq("Testing whether "+num+" gives 'BARS NOSE YUMMY'", expected, answer);
	}

	/**
	 * This test checks whether two separate objects do not interfere with each other.
	 * This can happen if the instance variable of the counter is declared in a 
	 * static fashion.
	 */
	public static void testMultiInstance() {
		
		ArrayList<String> answer1 = new ArrayList<>();
		ArrayList<String> answer2 = new ArrayList<>();
		
		SillyCounting sc1 = new SillyCounting(1);
		answer1.add(sc1.getNextCount());
		SillyCounting sc2 = new SillyCounting(9);
		answer2.add(sc2.getNextCount());
		answer1.add(sc1.getNextCount());
		answer2.add(sc2.getNextCount());
		
		ArrayList<String> expected1 = makeList("1", "2");
		ArrayList<String> expected2 = makeList("9", "10");
		
		String msg = "Testing whether two separate SillyCounting objects do not interfere with each other.";
		msg += " If this test fails, make sure to declare your instance variables in a non-static fashion.";
		
		assertEq(msg, expected1, answer1);
		assertEq(msg, expected2, answer2);
	}

	
	public static ArrayList<String> makeList(String ... args)
	{
		return new ArrayList<>(Arrays.asList(args));
	}
	
	public static ArrayList<String> runCode(int start, int length)
	{
		SillyCounting sc = new SillyCounting(start);
		ArrayList<String> answer = new ArrayList<>();
		for (int t=0; t < length; t++) {
			answer.add(sc.getNextCount());
		}
		return answer;
	}
	
	private static TreeMap<String,Integer> success = new TreeMap<>();
	
	private static void printSuccess()
	{
		System.out.println("**************************************************");
		System.out.println("* The following tests were completed succesfully *");
		System.out.println("**************************************************");
		for (Entry<String,Integer> e : success.entrySet()) {
			System.out.println("("+e.getValue()+" times) "+e.getKey());
		}
	}
	
	private static void assertEq(String msg, Object exp, Object ans)
	{
		if (exp == null) {
			if (ans == null) {
				success.merge(msg, 1, Integer::sum);
				return;
			}
			throw new TestFailedException(msg, exp, ans);
		}
		if (ans == null) {
			throw new TestFailedException(msg, exp, ans);
		}
		if (!exp.equals(ans)) {
			throw new TestFailedException(msg, exp, ans);
		}
		success.merge(msg, 1, Integer::sum);
	}
	
	private static String makeMessage(String msg, Object expectation, Object answer)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(msg);
		sb.append("\nThe given answer was: ");
		sb.append(answer.toString());
		sb.append("\nThe expected/correct answer is: ");
		sb.append(expectation.toString());
		return sb.toString();
	}
	
	@SuppressWarnings("serial")
	public static class TestFailedException extends RuntimeException
	{
		TestFailedException(String msg, Object expectation, Object answer)
		{
			super(makeMessage(msg, expectation, answer));
		}
	}
	
}
