import java.awt.*;
import java.util.*;

public class Game {

    private int size = 4;

    //instance fields
    private Tile[][] gameBoard = new Tile[size][size];
    private ArrayList<Tile> freeSpaces = new ArrayList<>();
    private ArrayList<Tile> beenCombined = new ArrayList<>();
    private boolean gameOver = false;
    private int boardSize;

    //0 = empty square
    //other numbers signify the actual number

    //--------------------

    //constructor
    public Game(int boardSize){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                gameBoard[r][c] = new Tile(r, c, 0, false);

            }//end for
        }//end for
        
        this.boardSize =  boardSize;
        initFreeSpaces();
//        printFreeSpacesList();
//        printBoard();
        generate(4);
//        printBoard();
//        initTestBoard();
//        printFreeSpacesList();
        System.out.println("Free Space: " + freeSpaces.size());
        System.out.println(moveChecker());

    }//end Game

    //--------------------

    //methods:
    private void generate(int reps){
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

    private void printFreeSpacesList(){

        for (int i = 0; i < freeSpaces.size(); i++) {

            System.out.println(freeSpaces.get(i).getR() + ", " + freeSpaces.get(i).getC());

        }//end for

        System.out.println(freeSpaces.size());

    }//end printFreeSpacesList

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

        if(deadGame){

            System.out.println("No more possible moves!");

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

        if(freeSpaces.size() > 1) {

            generate(2);

        }else if(freeSpaces.size() == 1){

            generate(1);

        }else{

            gameOver = moveChecker();

        }//end else

        resetBeenCombined();

//        printBoard();
//        printFreeSpacesList();

    }//end moveUp

    //--------------------
    
    public void moveDown(){

        for (int r = gameBoard.length - 2; r >= 0; r--) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                move(3, r, c);

            }//end for
        }//end for

        if(freeSpaces.size() > 1) {

            generate(2);

        }else if(freeSpaces.size() == 1){

            generate(1);

        }else{

            gameOver = moveChecker();

        }//end else

        resetBeenCombined();

//        printBoard();
//        printFreeSpacesList();
        
    }//end moveDown

    //--------------------

    public void moveLeft(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 1; c < gameBoard[0].length; c++) {

                move(4, r, c);

            }//end for
        }//end for

        if(freeSpaces.size() > 1) {

            generate(2);

        }else if(freeSpaces.size() == 1){

            generate(1);

        }else{

            gameOver = moveChecker();

        }//end else

        resetBeenCombined();

//        printBoard();
//        printFreeSpacesList();
        
    }//end moveLeft

    //--------------------

    public void moveRight(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = gameBoard.length - 2; c >= 0; c--) {

                move(2, r, c);

            }//end for
        }//end for

        if(freeSpaces.size() > 1) {

            generate(2);

        }else if(freeSpaces.size() == 1){

            generate(1);

        }else{

            gameOver = moveChecker();

        }//end else

        resetBeenCombined();

//        printBoard();
//        printFreeSpacesList();

    }//end moveRight

    //--------------------

    private void move(int dir, int r, int c){
        //method to move a specific tile in a certain direction until it combines or runs out of free spaces
        //doesn't actually move the tile object, instead, it only shifts the values
        //1 is up, 2 is right, 3 is down, 4 is left
        //I could probably make each direction its own method, but meh
        //could use more optimzation with movementR and movementC

        if(dir == 1){
            //move up

            if(r-1 >= 0) {
                if (gameBoard[r-1][c].getValue() == 0) {

                    gameBoard[r-1][c].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    freeSpaces.add(gameBoard[r][c]);
                    freeSpaces.remove(gameBoard[r-1][c]);
                    move(dir, r-1, c);

                }else if(gameBoard[r][c].getValue() == gameBoard[r-1][c].getValue()){
                    if(!gameBoard[r-1][c].isAlreadyCombined()){

                        gameBoard[r-1][c].setValue(gameBoard[r-1][c].getValue()*2);
                        //doubles the value
                        gameBoard[r][c].setValue(0);
                        //sets the current one to zero
                        gameBoard[r-1][c].setAlreadyCombined(true);
                        beenCombined.add(gameBoard[r-1][c]);
                        //updates the beenCombined array for future resetting
                        freeSpaces.add(gameBoard[r][c]);

                    }//end if
                }//end else if
            }//end if

        }else if(dir == 2){
            //move right

            if(c+1 < gameBoard[0].length) {
                if (gameBoard[r][c+1].getValue() == 0) {

                    gameBoard[r][c+1].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    freeSpaces.add(gameBoard[r][c]);
                    freeSpaces.remove(gameBoard[r][c+1]);
                    move(dir, r, c+1);

                }else if(gameBoard[r][c].getValue() == gameBoard[r][c+1].getValue()){
                    if(!gameBoard[r][c+1].isAlreadyCombined()) {

                        gameBoard[r][c+1].setValue(gameBoard[r][c+1].getValue() * 2);
                        //doubles the value
                        gameBoard[r][c].setValue(0);
                        //sets the current one to zero
                        gameBoard[r][c+1].setAlreadyCombined(true);
                        beenCombined.add(gameBoard[r][c+1]);
                        freeSpaces.add(gameBoard[r][c]);

                    }//end if
                }//end elif
            }//end if

        }else if(dir == 3){
            //move down

            if(r+1 < gameBoard.length) {
                if (gameBoard[r+1][c].getValue() == 0) {

                    gameBoard[r+1][c].setValue(gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    freeSpaces.add(gameBoard[r][c]);
                    freeSpaces.remove(gameBoard[r+1][c]);
                    move(dir, r+1, c);

                }else if(gameBoard[r][c].getValue() == gameBoard[r+1][c].getValue()){
                    if(!gameBoard[r+1][c].isAlreadyCombined()) {

                        gameBoard[r+1][c].setValue(gameBoard[r+1][c].getValue() * 2);
                        //doubles the value
                        gameBoard[r][c].setValue(0);
                        //sets the current one to zero
                        gameBoard[r+1][c].setAlreadyCombined(true);
                        beenCombined.add(gameBoard[r+1][c]);
                        freeSpaces.add(gameBoard[r][c]);

                    }//end if
                }//end elif
            }//end if

        }else if(dir == 4){
            //move left

            if(c-1 >= 0) {
                if (gameBoard[r][c-1].getValue() == 0) {

                    gameBoard[r][c-1].setValue(gameBoard[r][c-1].getValue() + gameBoard[r][c].getValue());
                    gameBoard[r][c].setValue(0);
                    freeSpaces.add(gameBoard[r][c]);
                    freeSpaces.remove(gameBoard[r][c-1]);
                    move(dir, r, c-1);

                }else if(gameBoard[r][c].getValue() == gameBoard[r][c-1].getValue()){
                    if(!gameBoard[r][c-1].isAlreadyCombined()) {

                        gameBoard[r][c-1].setValue(gameBoard[r][c-1].getValue() * 2);
                        //doubles the value
                        gameBoard[r][c].setValue(0);
                        //sets the current one to zero
                        gameBoard[r][c-1].setAlreadyCombined(true);
                        beenCombined.add(gameBoard[r][c-1]);
                        freeSpaces.add(gameBoard[r][c]);

                    }//end if
                }//end elif
            }//end if

        }else{

            System.out.println("Invalid Move Command");

        }//end if chain

    }//end move

    //--------------------

    private void resetBeenCombined(){

        while(beenCombined.size() > 0){

            beenCombined.remove(0).setAlreadyCombined(false);
            //sets all the "beencombined" objects to false

        }//end for

//        System.out.println(beenCombined.size());

    }//end resetBeenCombined

    //--------------------

    private void initTestBoard(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                gameBoard[r][c] = new Tile(r, c, 2, false);

            }//end for
        }//end for

    }//end initTestBoard

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
