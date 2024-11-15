import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) throws IllegalAccessException {

        FieldContent[][] board = new FieldContent[10][15];
        FieldContent blompy1 = new FieldContent("B");
        FieldContent topLeftCorner = new FieldContent("┏");
        FieldContent topRightCorner = new FieldContent("┓");
        FieldContent botLeftCorner = new FieldContent("┗");
        FieldContent botRightCorner = new FieldContent("┛");
        FieldContent borderWall = new FieldContent("━");
        FieldContent verticalBorderWall = new FieldContent("┃");
        FieldContent wall = new FieldContent("-");
        FieldContent door = new FieldContent("║");
        int blompyRow = 0;
        int blompyColumn = 0;
        int borderWallColumn =0;
        int borderWallRow = 0;

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
        while(true){
            board[blompyRow][blompyColumn] = blompy1;

        printout(board);
        String command = FieldContent.readCommandFromTheUser();
        if (command.equals("g")) {
            if(blompyColumn == 0){
                System.out.println("You cannot move any further.");
            } else {
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = borderWall;
            }
        } else if (command.equals("h")) {
            if(blompyColumn == 0){
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = topLeftCorner;
            } else {
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = borderWall;
            }
            //going down
        } else if(command.equals("b")){
            if(blompyRow == 0){
                blompyRow = blompyRow + 1;
                board[blompyRow - 1][blompyColumn] = topLeftCorner;
            } else if(blompyRow == 9){
                System.out.println("You cannot move any further.");
            } else {
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = verticalBorderWall;
            }
            //going up
        } else if(command.equals("y")){
            if(blompyRow == 0){
                System.out.println("You cannot move any further.");
            } else {
                blompyRow = blompyRow - 1;
                board[blompyRow + 1][blompyColumn] = verticalBorderWall;
            }
        }

    }







//        System.out.println("       ┏━━━━━━━━━━━━━━━━━━━┓");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("━━━━━━━┛ ║b────────────────┃");
//        System.out.println("         ║─────────────────┃");
//        System.out.println("━━━━━━━┓ ║─────────────────┃");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("       ┗━━━━━━━━━━━━━━━━━━━┛");










        }
    private static void printout(FieldContent[][] board) {
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
            // the first index in the matrix indicates the row
            FieldContent[] row = board[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
                // for every 'thing' in the row we create an output
                FieldContent field = row[columnNumber];

                if(field == null){

                        System.out.print(".");

                } else {
                    System.out.print(field.getVisualRepresentation());
                }

            }
            // after each row we want a new line
            System.out.println();
        }
        System.out.println("----------------------------------");
    }


    }


//        System.out.println(blompy1.getSymbol());
//        System.out.println(Arrays.deepToString(blompy1.getLocation()));


//    };






