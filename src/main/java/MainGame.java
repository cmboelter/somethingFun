import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) throws IllegalAccessException {

        FieldContent[][] board = new FieldContent[10][10];
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
        board[1][0] = verticalBorderWall;
        board[2][0] = verticalBorderWall;
        board[3][0] = verticalBorderWall;
        board[4][0] = verticalBorderWall;
        board[5][0] = verticalBorderWall;
        board[6][0] = verticalBorderWall;
        board[7][0] = verticalBorderWall;
        board[8][0] = verticalBorderWall;
        board[9][0] = botLeftCorner;
        while(true){
            board[blompyRow][blompyColumn] = blompy1;

        printout(board);
        String command = FieldContent.readCommandFromTheUser();
        if (command.equals("g")) {
            blompyColumn = blompyColumn - 1;
        } else if (command.equals("h")) {
            if(blompyColumn == 0){
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = topLeftCorner;
            } else {
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = borderWall;
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
                    if(columnNumber >=3){
                        FieldContent fieldPrior = row[columnNumber -1];
                        if(fieldPrior != null && fieldPrior.equals("━")){
                            System.out.println("━");
                        }
                    } else {
                        System.out.print(".");
                    }

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






