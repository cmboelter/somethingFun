import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Movement extends MainGame {

    public static int[] emptySpace(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, String command) {
        int[] location = findLocation(board, blompy1);
        if (location == null)
            location = findLocation(board, blompy2);
        if (command.equals("y")) {
            blompyRow = blompyRow - 1;
            board[blompyRow + 1][blompyColumn] = null;
        } else if (command.equals("g")) {
            blompyColumn = blompyColumn - 1;
            board[blompyRow][blompyColumn + 1] = null;
        } else if (command.equals("b")) {
            blompyRow = blompyRow + 1;
            board[blompyRow - 1][blompyColumn] = null;
        } else if (command.equals("h")) {
            blompyColumn = blompyColumn + 1;
            board[blompyRow][blompyColumn - 1] = null;
        }
        return location;
    }




    }









