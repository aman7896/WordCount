package com.Ordina.CodeChallenge.model;

import com.Ordina.CodeChallenge.interfaces.WordFrequency;

//Implementation class for WordFrequency interface
public class WordFrequencyClass implements WordFrequency{
	
	private int frequency;
	private String word;
	
	public int getFrequency(){
		return this.frequency;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public WordFrequencyClass(String word, int frequency) {
		this.frequency=frequency;
		this.word=word;
	}
}
