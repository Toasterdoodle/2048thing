import java.awt.*;

public class Tile {

    //instance fields
    private int r, c, value;

    //constructors
    public Tile(int r, int c, int value){

        this.r = r;
        this.c = c;
        this.value = value;

    }//end constructor

    //--------------------

    //methods

    //getters and setters, you know the gist
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //--------------------

    public void draw(int tileSize, Graphics2D g2){
        //draws each specific tile

        if(value == 0){

            g2.setColor(new Color(235, 235, 235));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);

        }else if(value == 2){

            g2.setColor(new Color(255, 238, 73));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(89, 67, 25));
            g2.drawString("2", c * tileSize + 95, r * tileSize + 165);

        }else if(value == 4){

            g2.setColor(new Color(255, 201, 76));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(89, 67, 25));
            g2.drawString("4", c * tileSize + 95, r * tileSize + 165);

        }else if(value == 8){

            g2.setColor(new Color(255, 147, 76));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(89, 67, 25));
            g2.drawString("8", c * tileSize + 95, r * tileSize + 165);

        }
        //TODO: add more numbers until 2048

    }//end draw

}//end class
