import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author Alan Huynh
 *         MancalaView: Draw the Mancala Board and all related buttons
 *         Right now, it draws the basic board with rectangles.
 *         To do:
 *         Implement buttons
 *         Add other functionality - the undo button, a way to draw how many stones are in each pit
 *         Add mouse listeners so we can make moves
 */

public class MancalaView extends JFrame implements ChangeListener
{
    private MancalaBoard board;

    /**
     * @param b the MancalaBoard we are using to initialize the view
     * @author Alan Huynh, Kory Le
     * Initialize a MancalaView with a given MancalaBoard.
     */
    public MancalaView(MancalaBoard b)
    {
        board = b;
        setSize(400, 400);
        setLayout(new BorderLayout());
        GameBoard gameBoard = new GameBoard(0, 0);
        add(gameBoard);
        setTitle("Mancala Game");

        //Buttons for game control
        JPanel buttonPanel = new JPanel();
        JButton three = new JButton("3 Stones");
        three.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {//Fill each player side with 3 stones TODO: call method to draw stones
            }
        });

        JButton four = new JButton("4 Stones");
        four.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {//Fill each player side with 4 stones TODO: call method to draw stones
            }
        });

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {//Reset the game
            }
        });

        buttonPanel.add(three);
        buttonPanel.add(four);
        buttonPanel.add(reset);
        add(buttonPanel, BorderLayout.SOUTH);


        /* Create a mouse listener object */
        MouseListener mouse = new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                // TODO Auto-generated method stub
            }
        };
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        // TODO Auto-generated method stub

    }

}

/**
 * @author Alan Huynh
 *         The panel that displays the board.
 */
class GameBoard extends JPanel
{
    private int x = 0;
    private int y = 0;

    /**
     * @param offsetX how far to the right does it go
     * @param offsetY how far down does it go
     */
    public GameBoard(int offsetX, int offsetY)
    {
        x = offsetX;
        y = offsetY;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        double boardWidth = 50;
        double boardHeight = 50;
        Rectangle2D.Double[] boardArray = new Rectangle2D.Double[14]; //Our array of represented pits
        boardArray[13] = new Rectangle2D.Double(x, y, boardWidth, 2 * boardHeight);
        for (int i = 1; i < 7; i++)
        {//The pits are added in order based on the Pit array in the google doc 
            boardArray[13 - i] = new Rectangle2D.Double(x + (50 * i), y, boardWidth, boardHeight);
            boardArray[i - 1] = new Rectangle2D.Double(x + (50 * i), y + 50, boardWidth, boardHeight);
        }
        boardArray[6] = new Rectangle2D.Double(x + 350, y, boardWidth, 2 * boardHeight);
        for (int i = 0; i < boardArray.length; i++)
        {//Draw all of the pits. Todo: Have them display the stones
            g2.draw(boardArray[i]);

        }
    }
}