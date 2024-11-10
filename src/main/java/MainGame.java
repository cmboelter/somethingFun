import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) throws IllegalAccessException {

        FieldContent[][] board = new FieldContent[2][2];
        FieldContent blompy1 = new FieldContent("B");
        FieldContent topLeftCorner = new FieldContent("┏");
        FieldContent topRightCorner = new FieldContent("┓");
        FieldContent botLeftCorner = new FieldContent("┗");
        FieldContent botRightCorner = new FieldContent("┛");
        FieldContent borderWall = new FieldContent("━");
        FieldContent wall = new FieldContent("-");
        FieldContent door = new FieldContent("║");

        board[0][0] = topLeftCorner;
        board[0][1] = borderWall;
        board[1][0] = borderWall;
        board[1][1] = borderWall;
//        board[0][4] = borderWall;
        while(true){
        printout(board);
        String command = FieldContent.readCommandFromTheUser();
        if (command.equals("g")) {
            board[1][1] = door;
        } else if (command.equals("h")) {
            board[1][1] = wall;
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






