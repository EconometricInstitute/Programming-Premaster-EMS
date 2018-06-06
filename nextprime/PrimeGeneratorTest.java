import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Class that runs some tests on an implementation of the PrimeGenerator class
 * as described in the example assignment.
 * 
 * @author Paul Bouman
 *
 */

public class PrimeGeneratorTest {

	public static void main(String [] args) {
		try
		{
			testFirstTen();
			testNegativeStart();
			testSkipCurrent();
			testSetStart();
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
	
	public static void testFirstTen() {
		ArrayList<Integer> answer = runCode(0,10);
		ArrayList<Integer> expected = makeList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		assertEq("Testing whether the first ten prime numbers are correctly generated", expected, answer);
	}

	public static void testNegativeStart() {
		ArrayList<Integer> answer = runCode(-10,1);
		ArrayList<Integer> expected = makeList(2);
		assertEq("Testing whether two is given as the first prime when the start value is negative", expected, answer);
		
	}
	
	public static void testSkipCurrent() {
		ArrayList<Integer> answer = runCode(2,1);
		ArrayList<Integer> expected = makeList(3);
		assertEq("Testing whether the starting value is not returned if it turns out to be prime", expected, answer);
	}
	
	public static void testSetStart() {
		PrimeGenerator gen = new PrimeGenerator(0);
		
		Integer answer, expected;
		
		answer = gen.nextPrime();
		expected = 2;
		assertEq("Testing whether the setStart() method works as expected", expected, answer);

		gen.setStart(7);
		answer = gen.nextPrime();
		expected = 11;
		assertEq("Testing whether the setStart() method works as expected", expected, answer);

		gen.setStart(17);
		answer = gen.nextPrime();
		expected = 19;
		assertEq("Testing whether the setStart() method works as expected", expected, answer);

		gen.setStart(22);
		answer = gen.nextPrime();
		expected = 23;
		assertEq("Testing whether the setStart() method works as expected", expected, answer);

		gen.setStart(0);
		answer = gen.nextPrime();
		expected = 2;
		assertEq("Testing whether the setStart() method works as expected", expected, answer);
	}

	public static void testMultiInstance() {
		
		String msg = "Testing whether two separate PrimeGenerator objects do not interfere with each other.";
		msg += " If this test fails, make sure to declare your instance variables in a non-static fashion.";

		
		PrimeGenerator gen1 = new PrimeGenerator(0);
		Integer ans1 = gen1.nextPrime();
		Integer exp1 = 2;
		assertEq(msg, exp1, ans1);
		
		PrimeGenerator gen2 = new PrimeGenerator(10);
		Integer ans2 = gen2.nextPrime();
		Integer exp2 = 11;
		assertEq(msg, exp2, ans2);
		
		Integer ans3 = gen1.nextPrime();
		Integer exp3 = 3;
		assertEq(msg, exp3, ans3);
		
		Integer ans4 = gen2.nextPrime();
		Integer exp4 = 13;
		assertEq(msg, exp4, ans4);
		
		gen1.setStart(21);
		Integer ans5 = gen2.nextPrime();
		Integer exp5 = 17;
		assertEq(msg, exp5, ans5);
		
		Integer ans6 = gen1.nextPrime();
		Integer exp6 = 23;
		assertEq(msg, exp6, ans6);
	}
	
	public static ArrayList<Integer> makeList(Integer ... args)
	{
		return new ArrayList<>(Arrays.asList(args));
	}
	
	public static ArrayList<Integer> runCode(int start, int length)
	{
		PrimeGenerator gen = new PrimeGenerator(start);
		ArrayList<Integer> answer = new ArrayList<>();
		for (int t=0; t < length; t++) {
			answer.add(gen.nextPrime());
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
