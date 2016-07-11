package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class TestCase
{

	//*************************** No Duplicates in Word Ladder Test *******************************//

	@Test
	public void testDuplicatesBFS() 
	{
		// TODO Map to keep take of the words map<string, int>
	}
	
	@Test
	public void testDuplicatesDFS() 
	{
		// TODO Map to keep take of the words map<string, int>
	}
	
	//*************************** Same Letter Position Changed Test *******************************//

	@Test
	public void testSamePosChangeBFS() 
	{
		// TODO create a compare method that records the index of the changed letter position
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
		
	}
	
	@Test
	public void testSamePosChangeDFS() 
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
	}
	
	@Test
	public void testDFS() 
	{
		// TODO 
	}
	
	//*************************** Illegal Input Test *******************************//
	
	@Test
	public void testIllegalInputWordsNotInDict() 
	{
		// TODO run main code and see if it prints what it needs to print
		String start = "APPLES";
		String end = "HELLO";
		assertEquals(null, Main.getWordLadderDFS(start, end));
		
	}
	

	//*************************** Illegal Input Test *******************************//
	
	
}
