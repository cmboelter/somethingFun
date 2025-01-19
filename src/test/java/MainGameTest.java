import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MainGameTest {


    private FieldContent[][] board = new FieldContent[10][15];
    private FieldContent blompy1 = new FieldContent("b");
    private FieldContent blompy2 = new FieldContent("B");
    private FieldContent topLeftCorner = new FieldContent("┏");
    private FieldContent topRightCorner = new FieldContent("┓");
    private FieldContent botLeftCorner = new FieldContent("┗");
    private FieldContent botRightCorner = new FieldContent("┛");
    private FieldContent borderWall = new FieldContent("━");
    private FieldContent verticalBorderWall = new FieldContent("┃");

    int blompyRow = 0;
    int blompyColumn = 0;



    @Before
    public void createBoard(){
        board[0][0] = topLeftCorner;
        board[0][1] = borderWall;
        board[0][2] = borderWall;
        board[0][3] = borderWall;
        board[0][4] = borderWall;
        board[0][5] = borderWall;
        board[0][6] = borderWall;
        board[0][7] = borderWall;
        board[0][8] = borderWall;
        board[0][9] = borderWall;
        board[0][10] = borderWall;
        board[0][11] = borderWall;
        board[0][12] = borderWall;
        board[0][13] = borderWall;
        board[0][14] = topRightCorner;
        board[1][0] = verticalBorderWall;
        board[2][0] = verticalBorderWall;
        board[3][0] = verticalBorderWall;
        board[4][0] = verticalBorderWall;
        board[5][0] = verticalBorderWall;
        board[6][0] = verticalBorderWall;
        board[7][0] = verticalBorderWall;
        board[8][0] = verticalBorderWall;
        board[9][0] = botLeftCorner;
        board[1][14] = verticalBorderWall;
        board[2][14] = verticalBorderWall;
        board[3][14] = verticalBorderWall;
        board[4][14] = verticalBorderWall;
        board[5][14] = verticalBorderWall;
        board[6][14] = verticalBorderWall;
        board[7][14] = verticalBorderWall;
        board[8][14] = verticalBorderWall;
        board[9][1] = borderWall;
        board[9][2] = borderWall;
        board[9][3] = borderWall;
        board[9][4] = borderWall;
        board[9][5] = borderWall;
        board[9][6] = borderWall;
        board[9][7] = borderWall;
        board[9][8] = borderWall;
        board[9][9] = borderWall;
        board[9][10] = borderWall;
        board[9][11] = borderWall;
        board[9][12] = borderWall;
        board[9][13] = borderWall;
        board[9][14] = botRightCorner;

    }

    @Test
    void whereDoesBlompyWannaGoTestUp(){

        //Create a blompy location
        board[1][0] = blompy1;
        //where blompy should end up
        int[] outcome = blompy1.whereDoesBlompyWannaGo(board, blompy1, blompy2, "y");
        int[] expected = {0,0};

        Assertions.assertArrayEquals(expected,outcome);

    }

    @Test
    void whereDoesBlompyWannaGoTestDown(){
        //Create a blompy location
        board[1][0] = blompy1;
        //where blompy should end up
        int[] outcome = blompy1.whereDoesBlompyWannaGo(board, blompy1, blompy2, "b");
        int[] expected = {2,0};

        Assertions.assertArrayEquals(expected,outcome);
    }

    @Test
    void whereDoesBlompyWannaGoTestLeft(){
        //Create a blompy location
        board[1][2] = blompy1;
        //where blompy should end up
        int[] outcome = blompy1.whereDoesBlompyWannaGo(board, blompy1, blompy2, "g");
        int[] expected = {1,1};

        Assertions.assertArrayEquals(expected,outcome);
        //Getting arrayindexoutofboundsexception: index 10 out of bounds for length 10 for this test.
    }


    @Test
    void whereDoesBlompyWannaGoTestRight(){
        //Create a blompy location
        board[0][0] = blompy1;
        //where blompy should end up
        int[] outcome = blompy1.whereDoesBlompyWannaGo(board, blompy1, blompy2, "h");
        int[] expected = {0,1};

        Assertions.assertArrayEquals(expected,outcome);
    }

    @Test
    void leaveTopLeftCornerDown(){
        //Create a blompy at top left corner
       board[blompyRow][blompyColumn] = blompy1;
        //Corner should be visible in it's place when it moves down
       FieldContent expected = topLeftCorner;
       FieldContent outcome = blompy1.leaveTopLeftCorner(board, blompyColumn,blompyRow,topLeftCorner, "b");
       Assertions.assertEquals(expected, outcome);
    }

    @Test
    void leaveTopLeftCornerRight(){
        //Create a blompy at top left corner
        board[blompyRow][blompyColumn] = blompy1;
        //Corner should be visible in it's place when it moves down
        FieldContent expected = topLeftCorner;
        FieldContent outcome = blompy1.leaveTopLeftCorner(board, blompyColumn,blompyRow,topLeftCorner, "h");
        Assertions.assertEquals(expected, outcome);
    }

    @Test
    void leaveTopLeftCornerWrongEntryB(){
        //Create a blompy at top left corner
        board[blompyRow][blompyColumn] = blompy1;
        //Corner should be visible in it's place when it moves down
        FieldContent expected = topLeftCorner;
        FieldContent outcome = blompy1.leaveTopLeftCorner(board, blompyColumn,blompyRow,topLeftCorner, "b");
        Assertions.assertEquals(expected, outcome);
    }
}


