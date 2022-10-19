package com.Ordina.CodeChallenge.service;

import java.util.Comparator;
import java.util.Map;


//Custom comparator for sorting the records
public class MapSort implements Comparator<Map.Entry<String, Integer>>{
	public int compare(Map.Entry<String, Integer> obj1
            , Map.Entry<String, Integer> obj2) {
		int comp;
		int freq1 = obj1.getValue();
		int freq2 = obj2.getValue();
		if(freq1 < freq2) //in case of different frequencies, higher frequency will be placed first
			comp = 1;
		else if(freq1 > freq2)
			comp = -1;
		else //in case of same frequencies, comparison is done by word alphabetically
			comp = obj1.getKey().compareTo(obj2.getKey());
		return comp;
	}
}
