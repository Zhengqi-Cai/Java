package NewChap13Exercise;

import acm.program.*;
import java.util.*;

public class Exercise13_8_2 extends ConsoleProgram{
	
	private static final int MAX_LENGTH = 3;
	
	public void run() {
		initLetterArray();
		String now = "";
		combineAndRecord(now);
		printOverlapWord();
		
	}
	
	private void printOverlapWord() {
		for(Long currentCode:hashCodeOfoverlapWord) {
			HashSet<String> currentSet = hashCode_word.get(currentCode);
			String summary = currentCode+": ";
			for(String currentWord:currentSet) {
				summary = summary + currentWord+" ";
			}
			println(summary);
		}
	}
	
	private void combineAndRecord(String now) {
		String last = now;
		for(int i=0;i<allLetter.length;i++) {
			now = last + allLetter[i];
			println(now);
			if(now.length()<MAX_LENGTH) {
				combineAndRecord(now);
			}
		}
	}
	
	private void addWord(String L1) {
		
		long currentHashCode = L1.hashCode();
		HashSet<String> currentWordList;
		if(hashCode_word.containsKey(currentHashCode)) {
			hashCodeOfoverlapWord.add(currentHashCode);
			currentWordList = hashCode_word.get(currentHashCode);
			
		}else {
			currentWordList = new HashSet<String>();
		}
		currentWordList.add(L1);
	}
	
	private void initLetterArray() {
		for(int i=0;i<26;i++) {
			allLetter[i] = (char)('a'+i);
		}
		for(int i=0;i<26;i++) {
			allLetter[i+26] = (char)('A'+i);
		}
	}
	
	
	private int i=0;
	private char[] allLetter=new char[52];

	private HashSet<Long> hashCodeOfoverlapWord = new HashSet<Long>();//因为这个hashcode不能重复；
	private HashMap<Long,HashSet<String>> hashCode_word = new HashMap<Long,HashSet<String>>();

}
