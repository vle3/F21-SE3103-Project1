package test;

import java.util.ArrayList;

import model.WordGuessGame;

public class WordGuessTest {
   public static void main(String[] args) {
       WordGuessGame game = new WordGuessGame();

       game.setKey("bannanas");
       System.out.println(game.getKey());
       //System.out.println(game.getHealth());
       String guess = "a";
       ArrayList<Integer> test = game.findGuessInKey(guess, game.getKey());

    //    int index = game.getKey().indexOf(guess);
    //    while(index >= 0)
    //    {
    //        System.out.println(index);
    //        index = game.getKey().indexOf(guess, index + 1);
    //    }
       
   }
}
