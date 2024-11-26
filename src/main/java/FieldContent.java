import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FieldContent extends MainGame {

    private final String thing;

//    public static List<String> validCommands = new ArrayList<>();
//    validCommands.add("y");
//    validCommands.add("b");
//    validCommands.add("g");
//    validCommands.add("h");
//    validCommands.add("q");

    FieldContent(String whatIsIt) {
        this.thing = whatIsIt;
    }

    // this is what the field will look like on the board
    public String getVisualRepresentation() {
        return thing;
    }

    public static String readCommandFromTheUser()  {
        // do the stuff with the scanner here and check if the character is a valid command (like L for left or whatever you wish)
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine().toLowerCase();
        if(!(entry.equals("g") || entry.equals("h") || entry.equals("y") || entry.equals("b")|| entry.equals("q") || entry.equals("p")
        )) {
            System.out.println("Invalid Entry");
        }
        // then return the char so that it can be used by the rest of the program
        return entry;

    }

    public static String validQuestResponse() {
        // do the stuff with the scanner here and check if the character is a valid command (like L for left or whatever you wish)
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine().toLowerCase();
        if(!(entry.equals("yes") || entry.equals("no"))) {
            throw new IllegalArgumentException("Invalid entry");
        }
        // then return the char so that it can be used by the rest of the program
        return entry;

    }


    // this is used to update what the board looks like when the command is executed

//    }
    // we run through the matrix and produce one character for every field content
    private static void printout(FieldContent[][] board) {
        for (int i = 0; i < board.length; i++) {
            // the first index in the matrix indicates the row
            FieldContent[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                // for every 'thing' in the row we create an output
                FieldContent field = row[i];
                System.out.print(field.getVisualRepresentation());
            }
            // after each row we want a new line
            System.out.println();
        }
    }

    private static int[] getLocation(FieldContent[][] board, FieldContent character){
        int result[] = {-1, -1};
        for(int i =0; i<board.length; i++){
            for(int j=0; j <board[i].length; j++){
                if(board[i][j] == character){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }return result;
    }

    private static void moveRight(FieldContent thing1, FieldContent thing2){
        FieldContent[][] location = new FieldContent[2][2];
        location[0][0] = thing1;
        location[0][1] = thing2;

    }

    private static void swapContent(FieldContent thing){
        //if in one position, change

    }
    public static boolean hasWisdom(int value) {
        return (value>2);
    }

    public static boolean isBigBlompy(int wisdom, int compassion){
        return (wisdom ==5 && compassion == 2);
    }




}
