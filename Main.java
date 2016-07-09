/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
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
import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		// TODO methods to read in words, output ladder
		String start = new String();
		String end = new String();
		System.out.println("please enter start and end words");
		start = kb.nextLine();
		char [] arr = start.toCharArray();
		char [] arr1 = new char[start.toCharArray().length];
		char [] arr2 = new char[arr1.length];
		int i=0;
		while(arr[i]!=' '){
			arr1[i]=arr[i];
			i++;
		}
		i++;
		int temp=i-1;
		for(int j=0;j<start.toCharArray().length-temp;j++){
			arr2[j]=arr[i];
			i++;
		}
		start=arr1.toString();
		end = arr2.toString();
		
		getWordLadderBFS(start, end);

	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
    	LinkedList <WordNode> quene = new LinkedList <WordNode>();
    	ArrayList <String> WordLadder=new ArrayList <String>();
		Set<String> dict = makeDictionary();
		if(!dict.contains(start)) throw new IllegalArgumentException("Error: illegal Input");
		if(!dict.contains(end)) throw new IllegalArgumentException("Error: illegal Input");
		// TODO more code
		quene.add(new WordNode(start));
		WordLadder.add(start);
		while(!quene.isEmpty()){
			WordNode word = quene.remove();
			word.SetFlag();
			if(word.GetString().equals(end))
				return WordLadder;
			if(word.GetFlag()==true);
			else{
				word.SetFlag();
				WordLadder.add(word.GetString());
				char [] arr = word.GetString().toCharArray();
				for(int i=0;i<arr.length;i++){
					char temp = arr[i];
					for(char c='a';c<='z';c++){
						if(arr[i]!=c) arr[i]=c;
						String newWord = new String(arr);
						if(dict.contains(newWord)) quene.add(new WordNode(newWord));
						
					}
					arr[i]=temp;
				}
			}
		}
		
		
		
		return null; // replace this line later with real return
	}
    
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
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
}
