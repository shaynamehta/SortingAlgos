package defaultt;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SpellChecker
{
    private ArrayList<String> dictionary;

    /* Constructor populates the dictionary ArrayList from the file dictionary.txt*/
    public SpellChecker() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("words.txt"));
        dictionary = new ArrayList<String>(lines);
    }

    /**
     * Write a linearSearch(word) method that finds a word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int linearSearch(String word)
    { 
    	
    	for (int i = 0 ; i < dictionary.size() ; i++) {
    		
    		if (word.equals(dictionary.get(i))) {
    			
    			System.out.println(word + " has been found linearly");
    			return i + 1;
    		} 
    	}
    	
    	return dictionary.size(); //went through for loop for each iteration without success
    }

    /**
     * Write a binarySearch(word) method that finds the word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int binarySearch(String word)
    {
    	//search space is initially the entire list
    	int left = 0;
    	int right = dictionary.size()-1;
    	int count = 0; 
    	
    	while (left <= right) {
    		count++;
    		int middle = (left+right)/2;
    		
    		System.out.println("Step: " + count );
    			
    		 //if the target - word - happens to be in the middle
    		
    		if (word.compareTo(dictionary.get(middle)) == 0) { //change to use CompareTO method 
    												// negative --> s1 is sorter before s2
    												//positive --> s1 is sorted after s2
    												//0-s1 == s2;
    			
    				
    			
    			System.out.println("word found at index: " + middle);
    			System.out.println("total steps taken: " + count);
    			return count;
    			
    		} else if (word.compareTo(dictionary.get(middle)) < 0) { //negative int 
    			right = middle - 1;
    		} else if (word.compareTo(dictionary.get(middle))  > 0){
    			
    			//search side 2
    			left = middle + 1;
    		}
    	}
    	return count;
    }

    public static void main(String[] args) throws IOException
    {
        SpellChecker checker = new SpellChecker();
        String word = "penneeck";
        int i = checker.linearSearch(word);
        System.out.println("Linear search steps for " + word + " = " + i);
        int counter = checker.binarySearch(word);
        System.out.println("Binary search steps for " + word + " = " + counter);
    }
}

