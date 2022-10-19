Service usage guide:

	Service: Get highest frequency of a word in the text
	Path:"/getHighestFrequency"
	Request format: Plain text
	Expected Response: Highest frequency in integer format


	Service: Get frequency of a particular word in the text
	Path:"/getHighestFrequency"
	Request format: JSON input in the format {"text":"<Some text>","word":"<word to be searched>"}
	Expected Response: Frequence of the word in integer format

	Service: Get n records with highest frequencies
	Path:"/getHighestFrequency"
	Request format: JSON input in the format {"text":"<Some text>","number":"<number of records>"}
	Expected Response: List of n records with highest frequencies

	
The services have been deployed to AWS EC2 instance. 
Append http://3.110.84.206:8080 to the paths to use the services
