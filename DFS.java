package assignment3;

import java.util.*;

public class DFS 
{	
	private ArrayList<String> wordLadder;
	private Set<String> visited;
	
	public DFS(){}
	
	public DFS(ArrayList<String> wordLadder)
	{
		this.wordLadder = wordLadder;
		visited = new HashSet<String>();
	}
	
	public ArrayList<String> createWordLadder(String end, Set<String> dict, int pos)
	{	
		String lastWord = wordLadder.get(wordLadder.size()-1);
		if(lastWord.equals(end))
		{
			return wordLadder;
		}
		
		int changedLetter = -1;
		//Set<Node> possibleWords = new HashSet<Node>();
		for(int i = 0; i < lastWord.length() ;i++)
		{
			char[] tempStr = lastWord.toCharArray();
			if(i != pos)
			{
				for(char c = 'A'; c <= 'Z'; c++)
				{
					if(tempStr[i] != c)
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
		
//		for(String word: dict)
//		{
//			if(isDiffOne(word,lastWord) && !wordLadder.contains(word))
//			{
//				changedLetter = letterPosChanged(word,lastWord);
//				if(changedLetter != pos)
//				{
//					//possibleWords.add(new Node(word,letterMatchWithEnd(word,end)));
//					wordLadder.add(word);
//					createWordLadder(end,dict,changedLetter);
//					if(wordLadder.get(wordLadder.size()-1).equals(end))
//					{
//						return wordLadder;
//					}
//					wordLadder.remove(wordLadder.size()-1);
//				}
//			}
//		}
		
//		for(Node cand: possibleWords)
//		{
//			wordLadder.add(cand.getWord());
//			createWordLadder(end,dict,changedLetter);
//			if(wordLadder.get(wordLadder.size()-1).equals(end))
//			{
//				return wordLadder;
//			}
//			wordLadder.remove(wordLadder.size()-1);
//		}
//		
		return null;
	}
	


}

