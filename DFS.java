package assignment3;

import java.util.*;

public class DFS 
{	
	private ArrayList<String> wordLadder;
	
	public DFS(){}
	
	public DFS(ArrayList<String> wordLadder,String startWord)
	{
		this.wordLadder = wordLadder;
	}
	
	/**
	 * creates the word Ladder using DFS
	 * @param end - goal for the word ladder
	 * @param dict - Set of strings that contains the given dictionary for the word ladder
	 * @param pos - the position that was last changed
	 * @return  word ladder between start and end word
	 * 			null - if no word ladder is found
	 */
	public ArrayList<String> createWordLadder(String end, Set<String> dict, int pos)
	{	
		String lastWord = wordLadder.get(wordLadder.size()-1);
		if(lastWord.equals(end))
		{
			return wordLadder;
		}
		
		int changedLetter = -1;
		
		// goes through the goal word first and finds any words that can make a path to it
		for(int i = 0; i < lastWord.length(); i++)
		{
			char[] tempStr = lastWord.toCharArray();
			if(i != pos && tempStr[i] != end.charAt(i))
			{
				tempStr[i] = end.charAt(i);
				String newWord = new String(tempStr);
				if(dict.contains(newWord) && !wordLadder.contains(newWord))
				{
					changedLetter = i;
					wordLadder.add(newWord);
					createWordLadder(end,dict,changedLetter);
					if(wordLadder.get(wordLadder.size()-1).equals(end))
					{
						return wordLadder;
					}
					wordLadder.remove(wordLadder.size()-1);
				}
			}
		}
		
		// goes through all other possible words
		for(int i = 0; i < lastWord.length() ;i++)
		{
			char[] tempStr = lastWord.toCharArray();
			if(i != pos)
			{
				for(char c = 'A'; c <= 'Z'; c++)
				{
					if(tempStr[i] != c && c != end.charAt(i))
					{
						tempStr[i] = c;
						String newWord = new String(tempStr);
						if(dict.contains(newWord) && !wordLadder.contains(newWord))
						{
							changedLetter = i;
							wordLadder.add(newWord);
							createWordLadder(end,dict,changedLetter);
							if(wordLadder.get(wordLadder.size()-1).equals(end))
							{
								return wordLadder;
							}
							wordLadder.remove(wordLadder.size()-1);
						}
					}
					
				}
			}
			
		}
		
		return null;
	}
}

