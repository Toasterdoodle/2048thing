import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends JPanel {

    //instance fields
    private Game game;

    //0 = none
    //1 = up
    //2 = right
    //3 = down
    //4 = left
    private int keyInputCode = 0;

    private int width, height;

    private int boardWidth, boardHeight;

    //--------------------

    //constructor
    public GamePanel(int w, int h) {

        setSize(w, h);
        this.width = w;
        this.height = h;
        boardWidth = 600;
        boardHeight = 600;
        game = new Game(boardWidth, boardHeight);
        setUpMouseListener();
        setUpKeyListener();

    }//end GamePanel

    //--------------------

    //methods
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(new Color(255, 236, 132));

        g2.fillRect(0, 0, width, height);

        g2.setColor(new Color(89, 67, 25));
        g2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        g2.drawString("2048", 320, 35);

        g2.setColor(new Color(235, 235, 235));
        g2.fillRect(50, 50, boardWidth, boardHeight);

        game.draw(g2);

    }//end paintComponent

    //--------------------

    public void setUpMouseListener(){

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }//end mouseClicked

            @Override
            public void mousePressed(MouseEvent e) {

                //finds the x and y position of the cursor
                int x = e.getX();
                int y = e.getY();

                System.out.println(x + ", " + y);

            }//end mousePressed

            @Override
            public void mouseReleased(MouseEvent e) {

            }//end mouseReleased

            @Override
            public void mouseEntered(MouseEvent e) {

            }//end mouseEntered

            @Override
            public void mouseExited(MouseEvent e) {

            }//end mouseExited

        });//end addMouseListener

    }//end setUpMouseListener

    //--------------------

    public void setUpKeyListener(){

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }//end keyTyped

            @Override
            public void keyPressed(KeyEvent e) {

                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_W){

                    keyInputCode = 1;
                    game.moveUp();
                    repaint();

                }//end if
                if(keyCode == KeyEvent.VK_D){

                    keyInputCode = 2;
                    game.moveRight();
                    repaint();

                }//end if
                if(keyCode == KeyEvent.VK_S){

                    keyInputCode = 3;
                    game.moveDown();
                    repaint();

                }//end if
                if(keyCode == KeyEvent.VK_A){

                    keyInputCode = 4;
                    game.moveLeft();
                    repaint();

                }//end if

            }//end keyPressed

            @Override
            public void keyReleased(KeyEvent e) {

                keyInputCode = 0;

            }//end keyReleased

        });

    }//end setUpKeyListener

}//end class
