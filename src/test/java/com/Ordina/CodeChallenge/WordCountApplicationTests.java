package com.Ordina.CodeChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.Ordina.CodeChallenge.service.WordFrequencyService;

@SpringBootTest
class WordCountApplicationTests { //Cover controller as well

	@Autowired
	private WordFrequencyService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getHighestFrequencyTestCase1() {
		String testcase="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		Assertions.assertEquals(3,service.calculateHighestFrequency(testcase));
	}
	
	@Test
	public void getHighestFrequencyTestCase2() {
		String testcase="Multiple random words to calculate1word2word and check whether the1word output is correct$word";
		Assertions.assertEquals(4,service.calculateHighestFrequency(testcase));
	}
	
	@Test
	public void getHighestFrequencyTestCase3() {//Same case as before just ending with non alphabet character and having two words with same frequency
		String testcase="Multiple random words to calculate1word2word the the the and check whether the1word output is correct$word88";
		Assertions.assertEquals(4,service.calculateHighestFrequency(testcase));
	}
	
	@Test
	public void calculateFrequencyForWordTestCase1() {
		String testcase="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		Assertions.assertEquals(1,service.calculateFrequencyForWord(testcase, "Lorem"));
	}
	
	@Test
	public void calculateFrequencyForWordTestCase2() {
		String testcase="Apart from counting words and characters, our online editor can help you to improve word choice and writing style, and, optionally, help you to detect grammar mistakes and plagiarism. To check word count, simply place your cursor into the text box above and start typing. You'll see the number of characters and words increase or decrease as you type, delete, and edit them. You can also copy and paste text from another program over into the online editor above. The Auto-Save feature will make sure you won't lose any changes while editing, even if you leave the site and come back later. Tip: Bookmark this page now.\n"
				+ "\n"
				+ "Knowing the word count of a text can be important. For example, if an author has to write a minimum or maximum amount of words for an article, essay, report, story, book, paper, you name it. WordCounter will help to make sure its word count reaches a specific requirement or stays within a certain limit.\n"
				+ "\n"
				+ "In addition, WordCounter shows you the top 10 keywords and keyword density of the article you're writing. This allows you to know which keywords you use how often and at what percentages. This can prevent you from over-using certain words or word combinations and check for best distribution of keywords in your writing.\n"
				+ "\n"
				+ "In the Details overview you can see the average speaking and reading time for your text, while Reading Level is an indicator of the education level a person would need in order to understand the words you’re using.\n"
				+ "\n"
				+ "Disclaimer: We strive to make our tools as accurate as possible but we cannot guarantee it will always be so.";
		Assertions.assertEquals(3,service.calculateFrequencyForWord(testcase, "KeYwOrdS"));
	}
	
	@Test
	public void calculateMostFrequentNWordsTestCase() {
		String testcase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		Assertions.assertEquals(3, service.calculateMostFrequentNWords(testcase, 3).size());
	}
}
