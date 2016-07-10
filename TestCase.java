package assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase
{

	//*************************** No Duplicates in Word Ladder Test *******************************//

	@Test
	public void testDuplicatesBFS() 
	{
		// TODO Map to keep take of the words map<string, int>
		fail("Not yet implemented");
	}
	
	@Test
	public void testDuplicatesDFS() 
	{
		// TODO Map to keep take of the words map<string, int>
		fail("Not yet implemented");
	}
	
	//*************************** Same Letter Position Changed Test *******************************//

	@Test
	public void testSamePosChangeBFS() 
	{
		// TODO create a compare method that records the index of the changed letter position
		fail("Not yet implemented");
	}
	
	@Test
	public void testSamePosChangeDFS() 
	{
		// TODO create a compare method that records the index of the changed letter position
		fail("Not yet implemented");
	}
	
	private int compareLetterPos(String pre, String next)
	{
		for(int i = 0; i < pre.length(); i++)
		{
			if(pre.charAt(i) != next.charAt(i))
			{
				return i;
			}
		}
		return -1;
	}

	//*************************** No Word Ladder Test *******************************//
	@Test
	public void testNoWordLadderBFS() 
	{
		// TODO what words do not have a word ladder
		// Use Short_dictionary to test
		assertEquals(null,Main.getWordLadderBFS(null, null));
	}
	
	@Test
	public void testNoWordLadderDFS() 
	{
		// TODO what words do not have a word ladder
		assertEquals(null,Main.getWordLadderDFS(null, null));
	}

	//*************************** Normal Word Ladder Test *******************************//

	@Test
	public void testBFS() 
	{
		// TODO 
		fail("Not yet implemented");
	}
	
	@Test
	public void testDFS() 
	{
		// TODO 
		fail("Not yet implemented");
	}
	
	//*************************** Illegal Input Test *******************************//
	
	@Test
	public void testIllegalInputWordsNotInDict() 
	{
		// TODO run main code and see if it prints what it needs to print
		fail("Not yet implemented");
	}
	
	@Test
	public void testIllegalInputIllegalCommand() 
	{
		// TODO run main code and see if it prints what it needs to print
		fail("Not yet implemented");
	}

	//*************************** Illegal Input Test *******************************//
	
	@Test
	public void testQuitCommand() 
	{
		// TODO 
		fail("Not yet implemented");
	}
	
}
