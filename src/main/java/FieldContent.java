import java.util.Scanner;

public class FieldContent {

    private final String thing;

    FieldContent(String whatIsIt) {
        this.thing = whatIsIt;
    }

    // this is what the field will look like on the board
    public String getVisualRepresentation() {
        return thing;
    }


    private static String readCommandFromTheUser(String input) {
        // do the stuff with the scanner here and check if the character is a valid command (like L for left or whatever you wish)
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine().toLowerCase();
        // then return the char so that it can be used by the rest of the program
        return entry;

    }
    // this is used to update what the board looks like when the command is executed
    private static void updateStuffOnTheBoard(FieldContent[][] board, FieldContent character,String command) {
        // find where the player is on the board; what array location
        int[] location = getLocation(board, character);
        int row = location[0];
        int column = location[1];
        // put the player into another field
        String direction = readCommandFromTheUser(command);
        //h is right; g is left
        if (direction.equals("h")) {
            moveRight();
            // replace the old place with e.g. empty floor
        }
    }
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

    private static void moveRight(FieldContent[][] current){
        for(int i=0; i< current.length; i++){
            for(int j=0; j<current[i].length; j++){
                if((current[i+1][j]).equals("━")){
                    //maybe I need to check what is to the right and left to determine what goes in it's place
                    current[i+1][j] = current[i][j];
                }
                if((current[i][j]).equals("║")){
                    current[i][j] = ;
                    current[i+1][j]= current[i][j];
                }
            }
        }

    }

}
