public class Tile {

    //instance fields
    private int r, c, value;

    //constructors
    public Tile(int r, int c, int value){

        this.r = r;
        this.c = c;
        this.value = value;

    }//end constructor

    //methods

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

}//end class
