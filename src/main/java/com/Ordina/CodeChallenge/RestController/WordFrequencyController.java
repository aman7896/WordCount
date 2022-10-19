package com.Ordina.CodeChallenge.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ordina.CodeChallenge.interfaces.WordFrequency;
import com.Ordina.CodeChallenge.service.WordFrequencyService;



@RestController
public class WordFrequencyController {
	
	@Autowired
	private WordFrequencyService service;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to WordCounter.";
	}
	
	@PostMapping("/getHighestFrequency") //This service will accept plain text input
	public int calculateHighestFrequency(@RequestBody String text) {
		return service.calculateHighestFrequency(text);
	}
	
	@PostMapping("/getWordFrequency") //This service will accept JSON input in the format {"text":"<Some text>","word":"<word to be searched>"}
	public int calculateFrequencyForWord (@RequestBody Map<String, String> request) {
		return service.calculateFrequencyForWord(request.get("text"), request.get("word"));
	}
	
	@PostMapping("/getNFreqWords") //This service will accept JSON input in the format {"text":"<Some text>","number":"<number of records>"}
	public List<WordFrequency> calculateMostFrequentNWords (@RequestBody Map<String, String> request){
		return service.calculateMostFrequentNWords(request.get("text"), Integer.parseInt(request.get("number")));
	}
}
