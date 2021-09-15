import javax.swing.JFrame;

import model.WordGuessGame;
import view.WordGamePanel;

public class Main
{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400,100);

        var wordGamePanel = new WordGamePanel(window);
        wordGamePanel.init();
        
        window.pack();
        window.setVisible(true);

    }
}