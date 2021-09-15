package controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.WordGuessGame;
import view.WordGamePanel;
import view.WordGamePanel.GameState;

import java.awt.event.ActionEvent;

public class WordGameListener implements ActionListener {

    private WordGamePanel panel;

    public WordGameListener(WordGamePanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        int health = 0;
        if(button == panel.getNewButton())
        {
            var wordGame = new WordGuessGame();
            panel.setWordGame(wordGame);
            health = panel.getWordGame().getHealth();
            panel.getCanvas().setHealth(health);
            panel.setGameState(GameState.PLAYING);
            for(var b: panel.getAlphabetButton())
            {
                b.setEnabled(true);
            }
            panel.getGameKeyField().setText(panel.getWordGame().getKey());
            String hiddenKey = panel.getWordGame().hideKey();
            panel.getGuessField().setText(hiddenKey);
            panel.getCanvas().repaint();
        }
        else
        {
            button.setEnabled(false);
            JTextField guessField = panel.getGuessField();
            WordGuessGame wordGame = panel.getWordGame();
            boolean guessInKey = wordGame.checkGuess(button.getText());
            if(guessInKey == true)
            {
                ArrayList<Integer> guessPos = wordGame.findGuessInKey(button.getText(), wordGame.getKey());
                health = panel.getWordGame().getHealth();
                for (int i : guessPos) {
                    StringBuffer reveal = new StringBuffer(panel.getGuessField().getText());
                    reveal.setCharAt(i, button.getText().toCharArray()[0]);
                    String revealGuess = reveal.toString();
                    panel.getGuessField().setText(reveal.toString());;
                }
            }
            else if(guessInKey == false)
            {
                health = panel.getWordGame().getHealth();
                if(health == 0)
                {
                    for(var b: panel.getAlphabetButton())
                    {
                        b.setEnabled(false);
                    }
                }
            }
            if(!panel.getGuessField().getText().contains("_"))
            {
                for(var b: panel.getAlphabetButton())
                {
                    b.setEnabled(false);
                }
                panel.setGameState(GameState.WINNING);
            }
            if(panel.getWordGame().getHealth() == 0)
            {
                panel.setGameState(GameState.LOOSING);
            }
        panel.getCanvas().setHealth(health);
        panel.getCanvas().repaint();

        }
    }
    
}
