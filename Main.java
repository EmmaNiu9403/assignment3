/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Kassandra Perez
 * Kap2589
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2015
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Please enter Start and End words with a space seperating the two words (Ex. Hello Apple)");
		System.out.println("or /quit to terminate the program");
		Scanner kb = new Scanner(System.in);
		String tempAnswer = kb.nextLine();
		String[] tempStArr = tempAnswer.trim().split(" ");
		tempStArr = tempAnswer.trim().split(" ");
		ArrayList<String> words = getWords(tempStArr);

		while(!(words.get(0).equals("/quit")))
		{
			if(words.size() == 1 && !isCommand(words.get(0)))
			{
				System.out.println("Invalid Command: " + words.get(0));
			}
			else
			{
//				ArrayList<String> wordLadder1 = getWordLadderBFS(words.get(0).toUpperCase(), words.get(1).toUpperCase());
				ArrayList<String> wordLadder1 = getWordLadderDFS(words.get(0).toUpperCase(),words.get(1).toUpperCase()); 
				
				printWordLadder(words.get(0).toUpperCase(), words.get(1).toUpperCase(),wordLadder1);
			}
				System.out.println("Please enter Start and End words with a space seperating the two words (Ex. Hello Apple)");
				System.out.println("or /quit to terminate the program");
				kb = new Scanner(System.in);
				tempAnswer = kb.nextLine();
				tempStArr = tempAnswer.trim().split(" ");
				words = getWords(tempStArr);
		}
		
		System.out.println("Program terminated");
		kb.close();
	}
	
	/**
	 * DFS method for finding a word ladder
	 * @param start -- starting word for the word ladder
	 * @param end - goal for the word ladder
	 * @return  word ladder between start and end word
	 * 			null - if no word ladder is found
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) 
	{
		if(start == null || end == null) return null;
		
		Set<String> dict = makeDictionary(); 
		
		start = start.toUpperCase();
		end = end.toUpperCase();
	
		if(dict.contains(start) && dict.contains(end))
		{
			if(start.equals(end))
			{
				return null;
			}
			ArrayList<String> wordLadder = new ArrayList<String>();
			wordLadder.add(start);
			DFS dfs = new DFS(wordLadder,start);
			wordLadder = dfs.createWordLadder(end, dict, -1);
			
			return wordLadder;
		}
		return null; 
		
	}
	
	/**
	 *  BFS method
	 * @param start - starting word for the word ladder
	 * @param end - goal for the word ladder
	 * @return  word ladder between start and end word
	 * 			null - if no word ladder is found	
	 */
    public static ArrayList<String> getWordLadderBFS(String start, String end)
    {
    	if(start == null || end == null) return null;
    	
    	start = start.toUpperCase();
    	end = end.toUpperCase();
    	
    	if(start.equals(end)) return null;
    	
    	Set<String> dict = makeDictionary();
    	if(!dict.contains(start) || !dict.contains(end))
    	{
    		return null;
    	}
    	
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    	LinkedList<WordNode> queue = new LinkedList<WordNode>();
    	queue.add(new WordNode(start, 1, null));

    	dict.add(end);

    	int minStep = 0;

    	HashSet<String> visited = new HashSet<String>();
    	HashSet<String> unvisited = new HashSet<String>();
    	unvisited.addAll(dict);

    	int preNumSteps = 0;

    	while (!queue.isEmpty()) {
    		WordNode top = queue.remove();
    		String word = top.word;
    		int currNumSteps = top.numSteps;

    		if (word.equals(end)) {
    			if (minStep == 0) {
    				minStep = top.numSteps;
    			}

    			if (top.numSteps == minStep && minStep != 0) {
    				// nothing
    				ArrayList<String> t = new ArrayList<String>();
    				t.add(top.word);
    				while (top.pre != null) {
    					t.add(0, top.pre.word);
    					top = top.pre;
    				}
    				result.add(t);
    				continue;
    			}

    		}

    		if (preNumSteps < currNumSteps) {
    			unvisited.removeAll(visited);
    		}

    		preNumSteps = currNumSteps;

    		char[] arr = word.toCharArray();
    		for (int i = 0; i < arr.length; i++) {
    			for (char c = 'A'; c <= 'Z'; c++) {
    				char temp = arr[i];
    				if (arr[i] != c) {
    					arr[i] = c;
    				}

    				String newWord = new String(arr);
    				if (unvisited.contains(newWord)) {
    					queue.add(new WordNode(newWord, top.numSteps + 1, top));
    					visited.add(newWord);
    				}

    				arr[i] = temp;
    			}
    		}
    	}
    	
    	//Select the shortest word ladder 
      	ArrayList<String> temp = new ArrayList<String>();
    	int min = 0;
    	for (int i = 0; i < result.size(); i++) {
    		if (result.get(i).size() < result.get(min).size()) {
    			min = i;
    		}

    	}
    	if (!result.isEmpty()) {
    		temp = result.get(min);
    		return temp;
    	} else
    		return null;
    }

    /**
     * Creates a dictionary using the txt file five_letter_words.txt
     * @return dict - a HashSet of strings
     */
	public static Set<String> makeDictionary ()
	{
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
//			infile = new Scanner (new File("short_dict.txt"));
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	/**
	 * converts a string into an arrayList of strings
	 * @param words - array of strings
	 * @return an arrayList of strings
	 */
	public static ArrayList<String> getWords(String[] words)
	{
		ArrayList<String> newWord = new ArrayList<String>();
		for(String s: words)
		{
			if(!(s.trim().isEmpty()))
			{
				newWord.add(s);
			}
		}
		return newWord;
	}
	
	/**
	 * Prints a given wordLadder
	 * @param start - a string of where the wordLadder starts at
	 * @param end - a string of where the wordLadder ends at
	 * @param wordLadder - the wordLadder, can be null if there was no wordLadder found
	 */
	public static void printWordLadder(String start, String end, ArrayList<String> wordLadder)
	{
		if(wordLadder ==  null)
		{
			System.out.println("No word ladder can be found between " + start + " and " + end);
		}
		else
		{
			System.out.println("a " + (wordLadder.size() - 2)+ "-rung word ladder exists between " + start + " and " + end +".");

			for(String s: wordLadder)
			{
				System.out.println(s);
			}
		}
		
	}
	
	/**
	 * 
	 * @param word - a String to test weather 
	 * @return  True - if the word is a command
	 * 			False - if the word is not a command
	 */
	public static boolean isCommand(String word)
	{
		return word.equals("/quit");
	}
}
