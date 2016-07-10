/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Kassandra Perez
 * Kap2589
 * <Student1 5-digit Unique No.>
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
		Scanner kb = new Scanner(System.in);
		String tempAnswer = kb.nextLine();
		ArrayList<String> words = getWords(tempAnswer.trim().split(" "));
		
		// TODO methods to output ladder
		ArrayList<String> wordLadder1 = getWordLadderBFS(words.get(0).toUpperCase(), words.get(1).toUpperCase());
//		ArrayList<String> wordLadder1 = getWordLadderDFS(words.get(0).toUpperCase(),words.get(1).toUpperCase()); 
		
		printWordLadder(words.get(0).toUpperCase(), words.get(1).toUpperCase(),wordLadder1);
		
		kb.close();
	}
	
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) 
	{
		
		Set<String> dict = makeDictionary(); 
		
		if(dict.contains(start) && dict.contains(end))
		{
			ArrayList<String> wordLadder = new ArrayList<String>();
			wordLadder.add(start);
			DFS dfs = new DFS(wordLadder);
			wordLadder = dfs.createWordLadder(end, dict, -1);
			
			return wordLadder;
		}
		// TODO ask if i should have the error handling here or in main
		return null; 
		
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end)
    {
    	// TODO some code
    	Set<String> dict = makeDictionary();
    	ArrayList <ArrayList<String>> result = new ArrayList <ArrayList<String>> ();

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
    	
    	ArrayList <String> temp = new ArrayList <String> ();
    	int min = 0;
    	for(int i=0;i<result.size();i++){
    		if(result.get(i).size()<result.get(min).size()){
    			min=i;
    		}

    	}
    	temp = result.get(min);
    	return temp;
    }

    
	public static Set<String> makeDictionary ()
	{
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			//infile = new Scanner (new File("short_dict.txt"));
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
	
	public static void printWordLadder(String start, String end, ArrayList<String> wordLadder)
	{
		if(wordLadder ==  null)
		{
			System.out.println("No word ladder found!");
		}
		else
		{
			System.out.println("a " + wordLadder.size() + "-rung word ladder exists between " + start + " and " + end +".");

			for(String s: wordLadder)
			{
				System.out.println(s);
			}
		}
		
	}
	
}
