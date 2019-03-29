import java.awt.*;

public class Tile {

    //instance fields
    private int r, c, value;
    private boolean alreadyCombined;

    //constructors
    public Tile(int r, int c, int value, boolean alreadyCombined){

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

    public boolean isAlreadyCombined() {
        return alreadyCombined;
    }

    public void setAlreadyCombined(boolean alreadyCombined) {
        this.alreadyCombined = alreadyCombined;
    }

    //--------------------

    public void draw(int tileSize, Graphics2D g2){
        //draws each specific tile

        g2.setFont(new Font("Comic Sans", Font.BOLD, 100));

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
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("2", c * tileSize + 95, r * tileSize + 165);

        }else if(value == 4){

            g2.setColor(new Color(255, 201, 76));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("4", c * tileSize + 95, r * tileSize + 165);

        }else if(value == 8){

            g2.setColor(new Color(255, 147, 76));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("8", c * tileSize + 95, r * tileSize + 165);

        }else if(value == 16){

            g2.setColor(new Color(255, 132, 84));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("16", c * tileSize + 60, r * tileSize + 165);

        }else if(value == 32){

            g2.setColor(new Color(255, 98, 84));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("32", c * tileSize + 60, r * tileSize + 165);

        }else if(value == 64){

            g2.setColor(new Color(255, 92, 127));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("64", c * tileSize + 60, r * tileSize + 165);

        }else if(value == 128){

            g2.setFont(new Font("Comic Sans", Font.BOLD, 75));
            g2.setColor(new Color(232, 97, 167));
            g2.fillRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
            g2.setColor(new Color(65, 65, 65));
            g2.drawRect(50 + c * tileSize, 50 + r * tileSize, tileSize, tileSize);
//            g2.setColor(new Color(255, 255, 255));
            g2.drawString("128", c * tileSize + 50, r * tileSize + 155);

        }

    }//end draw

}//end class
