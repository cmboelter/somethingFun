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
        System.out.println(board);
        System.out.println(blompy1);

//        System.out.println("       ┏━━━━━━━━━━━━━━━━━━━┓");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("━━━━━━━┛ ║─────────────────┃");
//        System.out.println("         ║─────────────────┃");
//        System.out.println("━━━━━━━┓ ║─────────────────┃");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("       ┃───────────────────┃");
//        System.out.println("       ┗━━━━━━━━━━━━━━━━━━━┛");










        }


    }


//        System.out.println(blompy1.getSymbol());
//        System.out.println(Arrays.deepToString(blompy1.getLocation()));


//    };





