import javax.swing.JFrame;

import model.WordGuessGame;

public class Main
{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400,100);

        WordGuessGame wordGame = new WordGuessGame();

        window.pack();
        window.setVisible(true);

    }
}