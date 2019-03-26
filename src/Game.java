import java.awt.*;
import java.util.*;

public class Game {

    private int size = 4;

    //instance fields
    private Tile[][] gameBoard = new Tile[size][size];

    private ArrayList<Tile> freeSpaces = new ArrayList<>();
    
    private boolean gameOver = false;

    private int boardSize;

    //0 = empty square
    //other numbers signify the actual number

    //--------------------

    //constructor
    public Game(int boardSize){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                gameBoard[r][c] = new Tile(r, c, 0);

            }//end for
        }//end for
        
        this.boardSize =  boardSize;
        initFreeSpaces();
//        printBoard();
        generate(4);
//        printBoard();
        System.out.println("Free Space: " + freeSpaces.size());
        System.out.println(moveChecker());

    }//end Game

    //--------------------

    //methods:
    public void generate(int reps){
        //need to be optimized for tile class
        //generates 2's and 4's on the board in free spaces
        //first, checks if there are enough free spaces.
        //if there are, it will generate them in these free spaces

        int randIndex;

        if(reps > freeSpaces.size()){

            System.out.println("Error: Not enough free space to generate");

        }else{

            for (int i = 0; i < reps; i++) {

                randIndex = (int)(Math.random() * freeSpaces.size());

                if((int)(Math.random() * 2) < 1){
                    //changes number to two

                    freeSpaces.get(randIndex).setValue(2);
                    freeSpaces.remove(randIndex);

                }else{

                    freeSpaces.get(randIndex).setValue(4);
                    freeSpaces.remove(randIndex);

                }//end if else

            }//end for

        }//end if else

    }//end generate

    //--------------------

    public void printBoard(){
        //compatible with new Tile system

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                System.out.print(gameBoard[r][c].getValue() + ", ");

            }//end for
            System.out.println();
        }//end for

    }//end printBoard

    //--------------------

    //checks if game is over or not
    public boolean moveChecker(){
        //Should comply with new Tile class

        boolean deadGame = true;

        //check for possible moves
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                if(c + 1 < gameBoard[0].length) {
                    if (gameBoard[r][c].getValue() == gameBoard[r][c + 1].getValue()) {

                        deadGame = false;

                    }//end if
                }//end if

                if(c - 1 >= 0){
                    if(gameBoard[r][c].getValue() == gameBoard[r][c - 1].getValue()){

                        deadGame = false;

                    }//end if
                }//end if

                if(r + 1 < gameBoard.length){
                    if(gameBoard[r][c].getValue() == gameBoard[r + 1][c].getValue()){

                        deadGame = false;

                    }//end if
                }//end if

                if(r - 1 >= 0){
                    if(gameBoard[r][c].getValue() == gameBoard[r-1][c].getValue()){

                        deadGame = false;

                    }//end if
                }//end if

            }//end for
        }//end for

        //checks for free spaces
        if(freeSpaces.size() > 0){

            deadGame = false;

        }//end if

        return deadGame;

    }//end moveChecker

    //--------------------

    private void initFreeSpaces(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                freeSpaces.add(gameBoard[r][c]);

            }//end for
        }//end for

    }//end initFreeSpaces

    //--------------------

    public void moveUp(){
        //if you're wondering why I'm not doing the moving in here is because this does it for all the tiles
        //move useful to make a separate method to move one tile and call it in this method

        for (int r = 1; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                move(1, r, c);
                
            }//end for
        }//end for

    }//end moveUp

    //--------------------
    
    public void moveDown(){

        for (int r = gameBoard.length - 2; r >= 0; r--) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                move(3, r, c);

            }//end for
        }//end for
        
    }//end moveDown

    //--------------------

    public void moveLeft(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 1; c < gameBoard[0].length; c++) {

                move(4, r, c);

            }//end for
        }//end for
        
    }//end moveLeft

    //--------------------

    public void moveRight(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = gameBoard.length - 2; c >= 0; c--) {

                move(2, r, c);

            }//end for
        }//end for

    }//end moveRight

    //--------------------

    public void move(int dir, int r, int c){
        //method to move a specific tile in a certain direction until it combines or runs out of free spaces
        //doesn't actually move the tile object, instead, it only shifts the values
        //1 is up, 2 is right, 3 is down, 4 is left
        //I could probably make each direction its own method, but meh

        if(dir == 1){
            //move up

            if(r-1 >= 0) {
                if (gameBoard[r-1][c].getValue() == 0) {

                    gameBoard[r-1][c].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    move(dir, r-1, c);

                }//end if
            }//end if

        }else if(dir == 2){
            //move right

            if(c+1 < gameBoard[0].length) {
                if (gameBoard[r][c+1].getValue() == 0) {

                    gameBoard[r][c+1].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    move(dir, r, c+1);

                }//end if
            }//end if

        }else if(dir == 3){
            //move down

            if(r+1 < gameBoard.length) {
                if (gameBoard[r+1][c].getValue() == 0) {

                    gameBoard[r+1][c].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    move(dir, r+1, c);

                }//end if
            }//end if

        }else if(dir == 4){
            //move left

            if(c-1 >= 0) {
                if (gameBoard[r][c-1].getValue() == 0) {

                    gameBoard[r][c-1].setValue(gameBoard[r][c-1].getValue() + gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    move(dir, r, c - 1);

                }//end if
            }//end if

        }else{

            System.out.println("Invalid Move Command");

        }//end if chain

    }//end move

    //--------------------

    public void combine(){
        //combines numbers


    }//end combine

    //--------------------

    public void draw(Graphics2D g2){

        g2.setStroke(new BasicStroke(3));

        g2.setFont(new Font("Comic Sans", Font.BOLD, 100));

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {
                
                gameBoard[r][c].draw(boardSize/size, g2);

            }//end for
        }//end for

    }//end draw

    //--------------------

}//end class
