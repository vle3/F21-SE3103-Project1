package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import view.WordGamePanel.GameState;

public class WordGameCanvas extends JPanel
{
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int health ; 

    private WordGamePanel panel ;

    public WordGameCanvas(WordGamePanel panel)
    {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        WordGamePanel.GameState state = panel.getGameState();
        if(state == GameState.READY)
        {
            g2.setColor(Color.red);
            g2.setFont(new Font("New Courier", Font.BOLD, 40));
            g2.drawString("Press NEW to start" , 70 ,50);
        }
        else if(state == GameState.PLAYING)
        {
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("New Courier", Font.BOLD, 40));
            g2.drawString("Health Level" , 20 ,40);

            //draw healthbar
            for(int i = 0 ; i < health; i++)
            {
                g2.fillRect(i * 50 + 20, 60 , 40, 60);
            }
        }
        else if(state == GameState.WINNING)
        {
            g2.setColor(Color.red);
            g2.setFont(new Font("New Courier", Font.BOLD, 40));
            g2.drawString("You Won!" , 70 ,100);
        }
        else if(state == GameState.LOOSING)
        {
            g2.setColor(Color.red);
            g2.setFont(new Font("New Courier", Font.BOLD, 40));
            g2.drawString("You Died!" , 70 ,100);
            g2.drawString("Press New to start", 70, 140);
        }
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
}
