package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordGameListener;
import model.WordGuessGame;

public class WordGamePanel
{
    public enum GameState
    {
        READY, PLAYING, WINNING , LOOSING
    }

    private JFrame window;
    private JButton newGame = new JButton("New");
    private JButton[] alphabetButton;
    private JTextField gameKey = new JTextField();
    private JTextField guessField = new JTextField();
    private WordGameCanvas canvas;
    private GameState gameState = GameState.READY;

    private WordGuessGame wordGame;

    public WordGamePanel(JFrame window)
    {
        this.window = window;
    }

    public void init()
    {
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(gameKey);
        northPanel.add(guessField);
        gameKey.setEditable(false);
        guessField.setEditable(false);

        gameKey.setBackground(Color.yellow);
        gameKey.setFont(new Font("New Courier" , Font.BOLD, 14));

        guessField.setFont(new Font("Arial", Font.BOLD, 16));

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordGameCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,7));
        
        WordGameListener keyListener = new WordGameListener(this);
        alphabetButton = new JButton[26];
        char[] alpha = new char[26];
        for(int i = 0 ; i < 26 ; i++)
        {
            alpha[i] = (char)(97 + i);
            alphabetButton[i] = new JButton("" + alpha[i]);
            alphabetButton[i].addActionListener(keyListener);
            southPanel.add(alphabetButton[i]);
        }
        southPanel.add(newGame);
        cp.add(BorderLayout.SOUTH, southPanel);
        for(var a: alphabetButton)
        {
            a.setEnabled(false);
        }

        newGame.addActionListener(keyListener);
    }

    public WordGuessGame getWordGame()
    {
        return wordGame;
    }

    public void setWordGame(WordGuessGame wordGame) {
        this.wordGame = wordGame;
    }

    public JFrame getWindow()
    {
        return window;
    }

    public WordGameCanvas getCanvas()
    {
        return canvas;
    }

    public JTextField getGameKeyField()
    {
        return gameKey;
    }

    public JTextField getGuessField()
    {
        return guessField;
    }
   

    public JButton getNewButton()
    {
        return newGame;
    }

    public JButton[] getAlphabetButton()
    {
        return alphabetButton;
    }
    public GameState getGameState()
    {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}