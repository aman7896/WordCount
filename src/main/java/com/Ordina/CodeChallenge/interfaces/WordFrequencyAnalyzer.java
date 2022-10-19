package com.Ordina.CodeChallenge.interfaces;

import java.util.List;

//Given Interface for Word Frequency Services
public interface WordFrequencyAnalyzer {
	int calculateHighestFrequency(String text);
	int calculateFrequencyForWord (String text, String word);
	List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
