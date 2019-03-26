import java.awt.*;

public class Game {

    private int size = 4;

    //instance fields
    private int[][] gameBoard = new int[size][size];

    //calculates amount of free space left in the game for generation purposes
    private int freeSpace = 16;
    
    private boolean gameOver = false;

    private int boardWidth, boardHeight;

    //0 = empty square
    //other numbers signify the actual number

    //--------------------

    //constructor
    public Game(int boardWidth, int boardHeight){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                gameBoard[r][c] = 0;

            }//end for
        }//end for

        this.boardHeight = boardHeight;
        this.boardWidth =  boardWidth;

        generate(4);

        printBoard();

        System.out.println("freeSpace: " + freeSpace);

        System.out.println(moveChecker());

    }//end Game

    //--------------------

    //methods
    public void generate(int reps){

        int randR, randC;

        if(reps > freeSpace){

            System.out.println("Error: Not enough free space to generate");

        }//end if
        else {

            for (int i = 0; i < reps; i++) {

                randR = (int) (Math.random() * size);
                randC = (int) (Math.random() * size);

                if (gameBoard[randR][randC] == 0) {

                    if ((int) (Math.random() * 2) >= 1) {

                        gameBoard[randR][randC] = 2;
                        freeSpace--;

                    }//end if
                    else {

                        gameBoard[randR][randC] = 4;
                        freeSpace--;

                    }

                }//end if
                else {

                    i--;

                }//end else

            }//end for

        }//end else

    }//end generate

    //--------------------

    public void printBoard(){

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                System.out.print(gameBoard[r][c] + ", ");

            }//end for
            System.out.println();
        }//end for

    }//end printBoard

    //--------------------

    //checks if game is over or not
    public boolean moveChecker(){

        boolean deadGame = true;

        //check for possible moves
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                if(c + 1 < gameBoard[0].length) {
                    if (gameBoard[r][c] == gameBoard[r][c + 1]) {

                        deadGame = false;

                    }//end if
                }//end if

                if(c - 1 >= 0){
                    if(gameBoard[r][c] == gameBoard[r][c - 1]){

                        deadGame = false;

                    }//end if
                }//end if

                if(r + 1 < gameBoard.length){
                    if(gameBoard[r][c] == gameBoard[r + 1][c]){

                        deadGame = false;

                    }//end if
                }//end if

                if(r - 1 >= 0){
                    if(gameBoard[r][c] == gameBoard[r-1][c]){

                        deadGame = false;

                    }//end if
                }//end if

            }//end for
        }//end for

        //checks for free spaces
        if(freeSpace > 0){

            deadGame = false;

        }//end if

        return deadGame;

    }//end moveChecker

    //--------------------

    public void moveUp(){

        for (int r = 1; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                //add matching numbers
                if(gameBoard[r][c] == gameBoard[r-1][c]){
                    
                    gameBoard[r-1][c] =+ gameBoard[r][c];
                    gameBoard[r][c] = 0;
                    
                }//end if

                //move if free space
                if(gameBoard[r-1][c] == 0){

                    gameBoard[r-1][c] = gameBoard[r][c];
                    gameBoard[r][c] = 0;
                    
                }//end if
                
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

                //add matching numbers
                if(gameBoard[r][c] == gameBoard[r+1][c]){

                    gameBoard[r][c+1] =+ gameBoard[r][c];
                    gameBoard[r][c] = 0;

                }//end if

            }//end for
        }//end for

    }//end moveRight

    //--------------------

    public void move(int dir, int r, int c){
        //1 is up, 2 is right, 3 is down, 4 is left

        if(dir == 1){



        }else if(dir == 2){



        }else if(dir == 3){

            if(gameBoard[r+1][c] == 0){

                gameBoard[r+1][c] = gameBoard[r][c];
                gameBoard[r][c] = 0;
                move(dir, r, c);

            }else if(gameBoard[r][c] == gameBoard[r+1][c]){

                gameBoard[r+1][c] =+ gameBoard[r][c];
                gameBoard[r][c] = 0;

            }//end if else

        }else if(dir == 4){

            if(gameBoard[r][c-1] == 0){

                gameBoard[r][c-1] = gameBoard[r][c];
                gameBoard[r][c] = 0;
                move(dir, r, c);

            }else if(gameBoard[r][c] == gameBoard[r+1][c]){

                gameBoard[r][c-1] =+ gameBoard[r][c];
                gameBoard[r][c] = 0;

            }//if else

        }else{

            System.out.println("Invalid Move Command");

        }//end if chain

    }//end move

    //--------------------

    public void draw(Graphics2D g2){

        g2.setStroke(new BasicStroke(3));

        g2.setFont(new Font("Comic Sans", Font.BOLD, 100));

        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[0].length; c++) {

                if(gameBoard[r][c] == 0){

                    g2.setColor(new Color(235, 235, 235));
                    g2.fillRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);
                    g2.setColor(new Color(65, 65, 65));
                    g2.drawRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);

                }else if(gameBoard[r][c] == 2){

                    g2.setColor(new Color(255, 238, 73));
                    g2.fillRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);
                    g2.setColor(new Color(65, 65, 65));
                    g2.drawRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);
                    g2.setColor(new Color(89, 67, 25));
                    g2.drawString("2", c * boardWidth/size + 95, r * boardHeight/size + 165);

                }else if(gameBoard[r][c] == 4){

                    g2.setColor(new Color(255, 201, 76));
                    g2.fillRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);
                    g2.setColor(new Color(65, 65, 65));
                    g2.drawRect(50 + c * boardWidth/size, 50 + r * boardHeight/size, boardWidth/size, boardHeight/size);
                    g2.setColor(new Color(89, 67, 25));
                    g2.drawString("4", c * boardWidth/size + 95, r * boardHeight/size + 165);

                }

            }//end for
        }//end for

    }//end draw

    //--------------------

}//end class
