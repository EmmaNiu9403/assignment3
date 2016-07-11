package assignment3;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestCase
{

	//*************************** No Duplicates in Word Ladder Test *******************************//

	@Test
	public void testDuplicatesBFS() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderBFS(start, end);		
		Main.printWordLadder(start, end, wordLadder);
		boolean duplicates = isDuplicateWordInLadder(wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + duplicates);
		assertEquals(false,duplicates);
	}
	
	@Test
	public void testDuplicatesDFS() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderDFS(start, end);
		Main.printWordLadder(start, end, wordLadder);
		boolean duplicates = isDuplicateWordInLadder(wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + duplicates);
		assertEquals(false,duplicates);
	}
	
	@Test
	public void testDuplicateTestingMethod()
	{
		ArrayList<String> wordLadder = new ArrayList<String>();
		wordLadder.add("Heart");
		wordLadder.add("Hears");
		wordLadder.add("Heirs");
		wordLadder.add("Hears");
		wordLadder.add("Bears");
		Main.printWordLadder("Heart","Bears", wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + isDuplicateWordInLadder(wordLadder));
		assertEquals(true,isDuplicateWordInLadder(wordLadder));
	}
	
	private boolean isDuplicateWordInLadder(ArrayList<String> wordLadder)
	{
		Map<String,Integer> duplicates = new HashMap<String,Integer>();
		for(String s: wordLadder)
		{
			if(duplicates.containsKey(s))
			{
				duplicates.put(s, (duplicates.get(s).intValue()) + 1);
			}
			else
			{
				duplicates.put(s,1); 
			}
		}
		
		Set<String> keys = duplicates.keySet();
		for(String key: keys)
		{
			if(duplicates.get(key).intValue() > 1)
			{
				return true;
			}
		}
		return false;
	}
	
	//*************************** Same Letter Position Changed Test *******************************//

	@Test
	public void testSamePosChangeBFS() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderBFS(start, end);		
		Main.printWordLadder(start, end, wordLadder);
		boolean sameLetterPosChanged = isLetterPosChanged(wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + sameLetterPosChanged);
		assertEquals(false,sameLetterPosChanged);
	}
	
	@Test
	public void testSamePosChangeDFS() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderBFS(start, end);		
		Main.printWordLadder(start, end, wordLadder);
		boolean sameLetterPosChanged = isLetterPosChanged(wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + sameLetterPosChanged);
		assertEquals(false,sameLetterPosChanged);
	}
	
	@Test
	public void testSameLetterPosChangeTestingMethod()
	{
		ArrayList<String> wordLadder = new ArrayList<String>();
		wordLadder.add("Heart");
		wordLadder.add("Hears");
		wordLadder.add("Heirs");
		wordLadder.add("Heers");
		wordLadder.add("Bears");
		Main.printWordLadder("Heart","Bears", wordLadder);
		boolean sameLetterPosChanged = isLetterPosChanged(wordLadder);
		System.out.println("Does this wordLadder have duplicates? " + sameLetterPosChanged);
		assertEquals(true,sameLetterPosChanged);
	}
	
	private boolean isLetterPosChanged(ArrayList<String> wordLadder)
	{
		if(wordLadder == null)
		{
			return false;
		}
		
		int pos = -1;
		String word = wordLadder.get(0);
		for(int i = 1; i < wordLadder.size(); i++)
		{
			int tempPos = compareLetterPos(word, wordLadder.get(i));
			if(pos == tempPos)
			{
				return true;
			}
			pos = tempPos;
			word = wordLadder.get(i);
		}
		return false;
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
	//@Test
	public void testNoWordLadderBFS() 
	{
		// TODO what words do not have a word ladder
		// Use Short_dictionary to test
		assertEquals(null,Main.getWordLadderBFS(null, null));
	}
	
	//@Test
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

	//*************************** /quit Command Test *******************************//
	
	@Test
	public void testQuitCommand() 
	{
		// TODO 
		fail("Not yet implemented");
	}
	
}
