package assignment3;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestCase
{

	//*************************** No Duplicates in Word Ladder Test *******************************//

	
	// NEED TO USE THE LARGE DICTIONARY FOR THESE TEST CASES
	// ---- Go to the makeDictionary method in Main and change which file is being read in
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
		if(wordLadder == null)
		{
			return false;
		}
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
	public void testSamePosChangeBFS1() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderBFS(start, end);		
		Main.printWordLadder(start, end, wordLadder);
		boolean sameLetterPosChanged = isLetterPosChanged(wordLadder);
		System.out.println("Does the word ladder have letters that changed the same position? " + sameLetterPosChanged);
		assertEquals(false,sameLetterPosChanged);
	}

	@Test
	public void testSamePosChangeBFS2() 
	{
		System.out.println("Please enter Start and End Words");
		Scanner kb = new Scanner(System.in);
		String temp = new String();
		temp = kb.nextLine();
		String[] t = temp.split(" ");
		String start = new String(t[0]);
		String end = new String(t[1]);
		ArrayList <String> test = new ArrayList <String> (Main.getWordLadderBFS(start, end));
		for(int i=0;i<test.size()-2;i++){
			if(compareLetterPos(test.get(i),test.get(i+1))==compareLetterPos(test.get(i+1),test.get(i+2))) 
				System.out.println("failed test cases");
		}
		
		kb.close();
	}
	
	@Test
	public void testSamePosChangeDFS1() 
	{
		String start = (new String("Stone")).toUpperCase();
		String end = (new String("Money")).toUpperCase();
		ArrayList<String> wordLadder = Main.getWordLadderBFS(start, end);		
		Main.printWordLadder(start, end, wordLadder);
		boolean sameLetterPosChanged = isLetterPosChanged(wordLadder);
		System.out.println("Does the word ladder have letters that changed the same position? " + sameLetterPosChanged);
		assertEquals(false,sameLetterPosChanged);
	}
	
	@Test
	public void testSamePosChangeDFS2() 
	{
		System.out.println("Please enter Start and End Words");
		Scanner kb = new Scanner(System.in);
		String temp = new String();
		temp = kb.nextLine();
		String[] t = temp.split(" ");
		String start = new String(t[0]);
		String end = new String(t[1]);
		ArrayList <String> test = new ArrayList <String> (Main.getWordLadderDFS(start, end));
		for(int i=0;i<test.size()-2;i++){
			if(compareLetterPos(test.get(i),test.get(i+1))==compareLetterPos(test.get(i+1),test.get(i+2))) 
				System.out.println("failed test cases");
		}
		kb.close();
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
		System.out.println("Does the word ladder have letters that changed the same position? " + sameLetterPosChanged);
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
	
	
	//NEED TO USE SHORT_DICTIONARY FOR THESE TEST CASES
	// ---- Go to the makeDictionary method in Main and change which file is being read in
	// If you use the large dictionary there will be a wordLadder from heart to twain
	@Test
	public void testNoWordLadderBFS() 
	{	
		ArrayList<String> wordLadder = Main.getWordLadderBFS("Heart".toUpperCase(), "Twain".toUpperCase());
		Main.printWordLadder("Heart".toUpperCase(),"Twain".toUpperCase(), wordLadder);
		assertEquals(null,wordLadder);
	}
	
	@Test
	public void testNoWordLadderDFS() 
	{
		ArrayList<String> wordLadder = Main.getWordLadderDFS("heart".toUpperCase(), "Twain".toUpperCase());
		Main.printWordLadder("heart".toUpperCase(),"Twain".toUpperCase(), wordLadder);
		assertEquals(null,wordLadder);
	}
	
	@Test
	public void testNoWordLadderWithNullInputBFS() 
	{
		assertEquals(null,Main.getWordLadderBFS(null, null));
	}
	
	@Test
	public void testNoWordLadderWithNullInputDFS() 
	{
		assertEquals(null,Main.getWordLadderDFS(null, null));
	}

	//*************************** Illegal Input Test *******************************//
	
	@Test
	public void testNoInputBFS()
	{
		assertEquals(null,Main.getWordLadderBFS("",""));
	}
	
	@Test
	public void testNoInputDFS()
	{
		assertEquals(null,Main.getWordLadderDFS("",""));
	}
	
	@Test
	public void testIllegalInputWordsNotInDictDFS() 
	{
		String start = "APPLES";
		String end = "HELLO";
		assertEquals(null, Main.getWordLadderDFS(start, end));
	}

	@Test
	public void testIllegalInputWordsNotInDictBFS() 
	{
		String start = "APPLES";
		String end = "HELLO";
		assertEquals(null, Main.getWordLadderBFS(start, end));
	}
}
