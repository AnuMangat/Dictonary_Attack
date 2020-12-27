# Dictonary_Attack
2.	Dictionary Attack
Requirements:
-	IntelliJ IDE
-	Jdk 1.8

	How to execute the program:
	Steps: 
	i) Unzip the DictionaryAttack.zip file
	ii) In the IntelliJ IDE, import the project DictionaryAttack
	iii) Set the configuration as Application -> Main class -> com.nsa.DictionaryAttack
	iv) Go to src->com.nsa->GenerateHash.java file and update line #41 to your local path directory for dict.csv file.
	v) Go to src->com.nsa->DictionaryAttack.java file and update line#22 & #23 to your local path directory for users.csv & dict.csv files respectively.
	vi) Run the program DictionaryAttack
	v) The main function or the driver program is provided.

Notes:
1)	GenerateHash.java file generates SHA1 hash value for a list of hardcoded common English words setup on line # 35. The output is written as a key-value delimited with comma to file dict.csv.
2)	DictionaryAttack.java file reads the user info as key-value of user name & hashed password into a hashtable. 
3)	Then, the data from the dict.csv file is read and compared to the hash table from 2).
4)	When a match is found the output is printed.
