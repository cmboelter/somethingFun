import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainGameTest {

    FieldContent[][] board = new FieldContent[10][15];
    FieldContent blompy1 = new FieldContent("b");
    FieldContent blompy2 = new FieldContent("B");
    FieldContent topLeftCorner = new FieldContent("┏");
    FieldContent topRightCorner = new FieldContent("┓");
    FieldContent botLeftCorner = new FieldContent("┗");
    FieldContent botRightCorner = new FieldContent("┛");
    FieldContent borderWall = new FieldContent("━");
    FieldContent verticalBorderWall = new FieldContent("┃");

    int blompyRow = 0;
    int blompyColumn = 0;


    @Test
    void whereDoesBlompyWannaGoTestY(){
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



        int[] expected = {0,1};

        Assertions.assertArrayEquals(expected, whereDoesBlompyWannaGo(board, blompy1, blompy2, "y"));

    }
}

//    public int[] whereDoesBlompyWannaGo(FieldContent[][] board, FieldContent blompy1, FieldContent blompy2, String command) {
//        int[] location = findLocation(board, blompy1);
//        if(location == null)
//            location = findLocation(board, blompy2);
//        if(command.equals("y")){
//            location[0] += 1;
//            return location;
//        } else if(command.equals("b")){
//            location[0] -= 1;
//            return location;
//        } else if(command.equals("g")){
//            location[1] -= 1;
//            return location;
//        } else if(command.equals("h")){
//            location[1] += 1;
//            return location;
//        } return location;
//    }