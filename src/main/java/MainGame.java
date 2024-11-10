import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {

        FieldContent[][] board = new FieldContent[8][29];
        FieldContent blompy1 = new FieldContent("B");
        FieldContent topLeftC = new FieldContent("┏");
        FieldContent topRightC = new FieldContent("┓");
        FieldContent botLeftC = new FieldContent("┗");
        FieldContent botRightC = new FieldContent("┛");
        FieldContent borderWall = new FieldContent("━");
        FieldContent wall = new FieldContent("-");
        FieldContent door = new FieldContent("║");

        board[0][0] = topLeftC;
        board[0][1] = borderWall;
        board[0][2] = borderWall;
        board[0][3] = borderWall;
        board[0][4] = borderWall;

        printout(board);






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
        for (int i = 0; i < board.length; i++) {
            // the first index in the matrix indicates the row
            FieldContent[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                // for every 'thing' in the row we create an output
                FieldContent field = row[i];
                if(field == null){
                    System.out.print(".");
                } else {
                    System.out.print(field.getVisualRepresentation());
                }

            }
            // after each row we want a new line
            System.out.println();
        }
    }


    }


//        System.out.println(blompy1.getSymbol());
//        System.out.println(Arrays.deepToString(blompy1.getLocation()));


//    };






