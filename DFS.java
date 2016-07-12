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
	
	public ArrayList<String> createWordLadder(String end, Set<String> dict, int pos)
	{	
		String lastWord = wordLadder.get(wordLadder.size()-1);
		if(lastWord.equals(end))
		{
			return wordLadder;
		}
		
		int changedLetter = -1;
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

