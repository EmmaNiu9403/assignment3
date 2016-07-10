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
		String temp = kb.nextLine();
		String[] words = temp.split(" ");
		if (words.length == 2) {
			start = words[0];
			end = words[1];
		}
		ArrayList<String> ladder = getWordLadderBFS(start, end);
		System.out.println("word ladder is: ");
		if (ladder == null)
			System.out.println("null");
		else {
			for (String s : ladder) {
				System.out.println(s);

			}
		}
		kb.close();

	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {

		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code

		return null; // replace this line later with real return
	}

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		// TODO some code
		Set<String> dict = makeDictionary();
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
		ArrayList<String> temp = new ArrayList<String>();
		int min = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).size() < result.get(min).size()) {
				min = i;
			}

		}
		if (result != null) {
			temp = result.get(min);
			return temp;
		} else
			return null;
	}

	public static Set<String> makeDictionary() {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			// infile = new Scanner(new File("five_letter_words.txt"));
			infile = new Scanner(new File("short_dict.txt"));
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
