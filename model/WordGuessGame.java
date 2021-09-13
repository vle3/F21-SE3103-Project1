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

    public WordGuessGame()
    {
        GenerateKey();
    }

    private void GenerateKey()
    {
        Random r = new Random();
        key = wordPool.get(r.nextInt(wordPool.size()));
    }
    
    public String getKey() {
        return key;
    }
    
}
