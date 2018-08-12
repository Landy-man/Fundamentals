package tst;

import game.FizzBuzz;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
	private FizzBuzz game = new FizzBuzz();
	
	private static final String gameTill15 = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz";
	
	private static final String gameTill100 = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, "
			+ "Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, "
			+ "Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61, 62, "
			+ "Fizz, 64, Buzz, Fizz, 67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz, Fizz, 82, 83, Fizz, Buzz, 86, "
			+ "Fizz, 88, 89, FizzBuzz, 91, 92, Fizz, 94, Buzz, Fizz, 97, 98, Fizz, Buzz";
	
	
	
	@Test 
	public void testNormalNum(){
		assertEquals("1", game.playTurn(1));
		assertEquals("2" , game.playTurn(2));
	}
	
	@Test
	public void testFizzNum(){
		assertEquals("Fizz" , game.playTurn(3));
		assertEquals("Fizz" , game.playTurn(9));
		assertEquals("Fizz" , game.playTurn(33));
	}
	
	@Test
	public void testBuzzNum(){
		assertEquals("Buzz" , game.playTurn(5));
		assertEquals("Buzz" , game.playTurn(20));
		assertEquals("Buzz" , game.playTurn(50));
	}
	
	@Test
	public void testFizzBuzzNum(){
		assertEquals("FizzBuzz" , game.playTurn(15));
		assertEquals("FizzBuzz" , game.playTurn(45));
		assertEquals("FizzBuzz" , game.playTurn(90));
	}
	

	
	@Test
	public void testSequence(){
		assertEquals("1, 2" , game.play(2));

	}
	
	
	@Test
	public void testFizzBuzzSequence(){
		assertEquals("1, 2, Fizz" , game.play(3));
		assertEquals("1, 2, Fizz, 4, Buzz" , game.play(5));
		assertEquals(gameTill15 , game.play(15));
	}
	
	@Test
	public void testOutExtremPointBoundrySequence(){
		assertEquals("", game.play(0));
		assertEquals("", game.play(101));
	}
	
	@Test
	public void testInExtremPointBoundrySequence(){
		assertEquals("1" , game.play(1));
		assertEquals(gameTill100 , game.play(100));
	}
	
	
	

	
}
