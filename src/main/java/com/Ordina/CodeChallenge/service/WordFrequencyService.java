package com.Ordina.CodeChallenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.Ordina.CodeChallenge.interfaces.WordFrequency;
import com.Ordina.CodeChallenge.interfaces.WordFrequencyAnalyzer;
import com.Ordina.CodeChallenge.model.WordFrequencyClass;

@Component
public class WordFrequencyService implements WordFrequencyAnalyzer{
	
	private static final Comparator<Map.Entry<String, Integer>> SORT = new MapSort();
	
	Logger logger = LoggerFactory.getLogger(WordFrequencyService.class);
	
	public int calculateHighestFrequency(String text) {
		logger.info("Entering function calculateHighestFrequency");
		
		int high = 0;
		
		Map <String,Integer> map = getWords(text);  //Getting the word map with frequencies
		
		Set<Map.Entry<String, Integer>> s = map.entrySet(); 
		
		for(Map.Entry<String,Integer> it: s) {
			int val = it.getValue();
			if (val > high) //Maintaining highest frequency value
				high = val;
		}
		
		logger.info("Returning from function calculateHighestFrequency");
		return high;
	}
	
	public int calculateFrequencyForWord (String text, String word) {
		logger.info("Entering function calculateFrequencyForWord");
		
		Map<String, Integer> map = getWords(text); //Getting the word map with frequencies
		
		word = word.toLowerCase(); 
		
		if(map.containsKey(word)) { //To avoid error in case word is not found
			logger.info("Returning from function calculateFrequencyForWord");
			return map.get(word);
		}
		
		logger.info("Returning from function calculateFrequencyForWord");
		return 0; //returning 0 when word is not found
	}
	public List<WordFrequency> calculateMostFrequentNWords (String text, int n){
		logger.info("Entering function calculateMostFrequentNWords");
		
		Map<String,Integer> map = getWords(text); //Getting the word map with frequencies
		
		ArrayList<Map.Entry<String, Integer>> words = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //To store and sort the word map
        
		Collections.sort(words, SORT); //Using custom comparator to sort according to frequency,alphabetical order
		
		if(n>words.size())  
			n=words.size(); //To avoid error in case N is greater than total number of words. All records will be shown in this case
		
		List<WordFrequency> result = new ArrayList<>();
		
		int i=0;
		for(Map.Entry<String, Integer> it : words) {
			if(i==n)
				break; 
			WordFrequency word = new WordFrequencyClass(it.getKey(),it.getValue()); //Storing the words in desired output format
			result.add(word);
			i++; //to maintain count of records while iterating the map
		}
		
		logger.info("Returning from function calculateMostFrequentNWords");
		return result;
	}
	
	private Map<String,Integer> getWords(String text){
		logger.info("Entering function getWords");
		
		String word = "";
		
		Map <String,Integer> wordmap = new HashMap<String,Integer>();
		
		for(int i=0; i<text.length(); i++) {
			char ch=text.charAt(i);
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z')) //Adding to word variable as long as we encounter alphabets
				word+=ch;
			else if(word!=""){ //if condition added to avoid null pointer exception in case of multiple consecutive non-alphabet characters
				word = word.toLowerCase();
				if(wordmap.containsKey(word)) { //Incrementing counter in case word already exists in map
					int n = wordmap.get(word);
					n++;
					wordmap.put(word, n);
					word="";
				}
				else { //Creating a new record in case word is absent
					wordmap.put(word, 1);
					word = "";
				}
			}
		}
		
		if(word!=""){ //Loop code repeated once to account for the last word in case the text ends with alphabet
			word = word.toLowerCase();
			if(wordmap.containsKey(word)) {
				int n = wordmap.get(word);
				n++;
				wordmap.put(word, n);
				word="";
			}
			else {
				wordmap.put(word, 1);
				word = "";
			}
		}
		
		logger.info("Returning from function getWords");
		return wordmap;
	}
}
