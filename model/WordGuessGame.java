package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordGuessGame 
{
    private ArrayList<String> wordPool = new ArrayList<String>
    (
        Arrays.asList("communication", "science", "programming", "language", "difficulty", "artificial", "intelligence", "attempts",
        "screenshot", "baseball", "windows", "learning", "electronics", "beautiful", "internet", "database", "organization",
        "application", "network", "friendly", "validation", "attempts", "statistics", "physics", "chemistry", "engineering", "school",
        "industry", "revolution", "progress", "characters", "heavily", "graphics")
    );

    

    private String key;
    private int health;
    private String guess;

    public WordGuessGame()
    {
        GenerateKey();
    }

    
    private void GenerateKey()
    {
        Random r = new Random();
        key = wordPool.get(r.nextInt(wordPool.size()));
        health = 5;
    }
    
    public boolean checkGuess(String guess)
    {
        boolean match = false;
        if(key.contains(guess))
        {
            match = true;
        }
        else{
            health-=1;
        }
        return match;
    }

    public String hideKey()
    {
        return key.replaceAll("[a-z]", "*");
    }

    public ArrayList<Integer> findGuessInKey(String guess, String key)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean match = checkGuess(guess);
        int index = key.indexOf(guess);
        while(index >= 0 && match == true)
        { 
            result.add(index);
            //System.out.println(index);
            index = key.indexOf(guess, index + 1);
        }
       
        for(var i: result)
        {
            System.out.println(i);
        }
        
        return result;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
}
